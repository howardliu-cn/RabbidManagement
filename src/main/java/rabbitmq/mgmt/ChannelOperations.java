package rabbitmq.mgmt;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rabbitmq.mgmt.model.Channel;

import java.util.Collection;

/**
 * <br/>created at 16-9-7
 *
 * @author liuxh
 * @since 1.2.0
 */
public class ChannelOperations extends BaseFluent {
    private static final Logger logger = LoggerFactory.getLogger(ChannelOperations.class);

    public ChannelOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
        super(httpContext, mgmtService);
    }

    public Collection<Channel> all() {
        return HTTP.GET("/channels", CHANNEL_COLLECTION).get();
    }

    public Optional<Channel> get(String name) {
        return HTTP.GET(String.format("/channels/%s", name), CHANNEL);
    }
}
