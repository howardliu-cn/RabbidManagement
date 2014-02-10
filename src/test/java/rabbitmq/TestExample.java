package rabbitmq;

import org.junit.*;
import rabbitmq.mgmt.RabbitMgmtService;
import rabbitmq.mgmt.model.Binding;
import rabbitmq.mgmt.model.Exchange;
import rabbitmq.mgmt.model.Queue;
import rabbitmq.test.RabbitAssert;

import static rabbitmq.test.ExchangeMatchers.*;
import static rabbitmq.test.QueueMatchers.*;
import static rabbitmq.test.BindingMatchers.*;

/**
 * @author Richard Clayton (Berico Technologies)
 */
@Ignore("Just an example.")
public class TestExample {

    static RabbitMgmtService mgmt;

    static RabbitAssert rabbitAssert;

    @BeforeClass
    public static void setup(){

        mgmt = RabbitMgmtService.builder().build();

        rabbitAssert = new RabbitAssert(mgmt);

        mgmt.exchanges().create(new Exchange("test.example.exchange"));

        mgmt.queues().create(new Queue("test.example.queue"));

        mgmt.bindings().create(new Binding("test.example.exchange", "test.example.queue", "test.topic"));
    }

    @AfterClass
    public static void teardown(){

        mgmt.exchanges().delete("test.example.exchange");

        mgmt.queues().delete("test.example.queue");
    }

    @Test
    public void test_topology_state_and_make_other_assertions(){

        rabbitAssert.hasExchange("test.example.exchange", isDirectType());

        rabbitAssert.hasQueue("test.example.queue", isNotQDurable());

        rabbitAssert.hasBinding("test.example.exchange", "test.example.queue", routingKey("test.topic"), isExToQ());
    }

}
