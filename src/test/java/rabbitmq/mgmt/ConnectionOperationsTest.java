package rabbitmq.mgmt;

import com.google.common.base.Optional;
import org.junit.Ignore;
import org.junit.Test;
import rabbitmq.mgmt.model.Channel;
import rabbitmq.mgmt.model.Binding;
import rabbitmq.mgmt.model.Connection;
import rabbitmq.mgmt.model.Exchange;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;

/**
 * <br/>created at 16-9-1
 *
 * @author liuxh (http://www.howardliu.cn)
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

    @Test
    @Ignore
    public void testGetDownstreamBindings() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        Optional<Collection<Binding>> directExchange = mgmt.exchanges().downstreamBindings("directExchange");
        if(directExchange.isPresent()) {
            System.out.println(directExchange.get());
        } else {
            System.out.println(Collections.emptyList());
        }
    }

    @Test
    @Ignore
    public void testGetUpstreamBindings() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        Optional<Collection<Binding>> directExchange = mgmt.exchanges().upstreamBindings("directExchange");
        if(directExchange.isPresent()) {
            System.out.println(directExchange.get());
        } else {
            System.out.println(Collections.emptyList());
        }
    }

    @Test
    @Ignore
    public void testGetChannels() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        ChannelOperations channelOperations = mgmt.channels();
        Collection<Channel> all = channelOperations.all();
        System.out.println(all);
    }
    @Test
    @Ignore
    public void testGetChannelByName() throws Exception {
        RabbitMgmtService mgmt = RabbitMgmtService.builder()
                .host("10.6.4.74")
                .port(15672)
                .credentials("admin", "12345")
                .build();
        ChannelOperations channelOperations = mgmt.channels();
        Optional<Channel> channelOptional = channelOperations
                .get(URLEncoder.encode("10.6.4.74:20835 -> 10.6.4.74:5672 (1)", "UTF-8"));
        if (channelOptional.isPresent()) {
            System.out.println(channelOptional.get());
        }
    }
}