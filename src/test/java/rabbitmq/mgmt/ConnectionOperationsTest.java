package rabbitmq.mgmt;

import com.google.common.base.Optional;
import org.junit.Ignore;
import org.junit.Test;
import rabbitmq.mgmt.model.Connection;
import rabbitmq.mgmt.model.Exchange;

import java.net.URLEncoder;
import java.util.Collection;

/**
 * <br/>created at 16-9-1
 *
 * @author liuxh
 * @since 1.2.0
 */
public class ConnectionOperationsTest {
    @Test
    @Ignore
    public void testGetConnectionByName() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        Optional<Connection> connectionOptional = mgmt.connections()
                .get(URLEncoder.encode("10.6.4.74:20291 -> 10.6.4.75:5672", "UTF-8"));
        System.out.println(connectionOptional.get());
    }

    @Test
    @Ignore
    public void testGetExchanges() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        Collection<Exchange> all = mgmt.exchanges().all();
        System.out.println(all);
    }

    @Test
    @Ignore
    public void testGetExchangeByName() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        Optional<Exchange> exchangeOptional = mgmt.exchanges().get("amq.default");
        if (exchangeOptional.isPresent()) {
            System.out.println(exchangeOptional.get());
        }
    }
}