package rabbitmq.mgmt.model;

import rabbitmq.mgmt.model.federation.ConnectionDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>created at 16-9-7
 *
 * @author liuxh
 * @since 1.2.0
 */
public class Channel {
    private String idle_since;
    private boolean transactional;
    private boolean confirm;
    private long consumer_count;
    private long messages_unacknowledged;
    private long messages_unconfirmed;
    private long messages_uncommitted;
    private long acks_uncommitted;
    private long prefetch_count;
    private long global_prefetch_count;
    private String state;
    private String node;
    private String name;
    private long number;
    private String user;
    private String vhost;
    private ConnectionDetails connection_details;
    private MessageStat message_stats;
    private List<String> publishes = new ArrayList<String>();
    private List<String> deliveries = new ArrayList<String>();
    private List<CustomDetails> consumer_details;

    public String getIdle_since() {
        return idle_since;
    }

    public void setIdle_since(String idle_since) {
        this.idle_since = idle_since;
    }

    public boolean isTransactional() {
        return transactional;
    }

    public void setTransactional(boolean transactional) {
        this.transactional = transactional;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public long getConsumer_count() {
        return consumer_count;
    }

    public void setConsumer_count(long consumer_count) {
        this.consumer_count = consumer_count;
    }

    public long getMessages_unacknowledged() {
        return messages_unacknowledged;
    }

    public void setMessages_unacknowledged(long messages_unacknowledged) {
        this.messages_unacknowledged = messages_unacknowledged;
    }

    public long getMessages_unconfirmed() {
        return messages_unconfirmed;
    }

    public void setMessages_unconfirmed(long messages_unconfirmed) {
        this.messages_unconfirmed = messages_unconfirmed;
    }

    public long getMessages_uncommitted() {
        return messages_uncommitted;
    }

    public void setMessages_uncommitted(long messages_uncommitted) {
        this.messages_uncommitted = messages_uncommitted;
    }

    public long getAcks_uncommitted() {
        return acks_uncommitted;
    }

    public void setAcks_uncommitted(long acks_uncommitted) {
        this.acks_uncommitted = acks_uncommitted;
    }

    public long getPrefetch_count() {
        return prefetch_count;
    }

    public void setPrefetch_count(long prefetch_count) {
        this.prefetch_count = prefetch_count;
    }

    public long getGlobal_prefetch_count() {
        return global_prefetch_count;
    }

    public void setGlobal_prefetch_count(long global_prefetch_count) {
        this.global_prefetch_count = global_prefetch_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public ConnectionDetails getConnection_details() {
        return connection_details;
    }

    public void setConnection_details(ConnectionDetails connection_details) {
        this.connection_details = connection_details;
    }

    public MessageStat getMessage_stats() {
        return message_stats;
    }

    public void setMessage_stats(MessageStat message_stats) {
        this.message_stats = message_stats;
    }

    public List<String> getPublishes() {
        return publishes;
    }

    public void setPublishes(List<String> publishes) {
        this.publishes = publishes;
    }

    public List<String> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<String> deliveries) {
        this.deliveries = deliveries;
    }

    public List<CustomDetails> getConsumer_details() {
        return consumer_details;
    }

    public void setConsumer_details(List<CustomDetails> consumer_details) {
        this.consumer_details = consumer_details;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "idle_since='" + idle_since + '\'' +
                ", transactional=" + transactional +
                ", confirm=" + confirm +
                ", consumer_count=" + consumer_count +
                ", messages_unacknowledged=" + messages_unacknowledged +
                ", messages_unconfirmed=" + messages_unconfirmed +
                ", messages_uncommitted=" + messages_uncommitted +
                ", acks_uncommitted=" + acks_uncommitted +
                ", prefetch_count=" + prefetch_count +
                ", global_prefetch_count=" + global_prefetch_count +
                ", state='" + state + '\'' +
                ", node='" + node + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", user='" + user + '\'' +
                ", vhost='" + vhost + '\'' +
                ", connection_details=" + connection_details +
                '}';
    }

    public static class MessageStat{
        private long ack;
        private MessageDetails ack_details;
        private long deliver;
        private MessageDetails deliver_details;
        private long deliver_get;
        private MessageDetails deliver_get_details;
        private long publish;
        private MessageDetails publish_details;

        public long getAck() {
            return ack;
        }

        public void setAck(long ack) {
            this.ack = ack;
        }

        public MessageDetails getAck_details() {
            return ack_details;
        }

        public void setAck_details(MessageDetails ack_details) {
            this.ack_details = ack_details;
        }

        public long getDeliver() {
            return deliver;
        }

        public void setDeliver(long deliver) {
            this.deliver = deliver;
        }

        public MessageDetails getDeliver_details() {
            return deliver_details;
        }

        public void setDeliver_details(MessageDetails deliver_details) {
            this.deliver_details = deliver_details;
        }

        public long getDeliver_get() {
            return deliver_get;
        }

        public void setDeliver_get(long deliver_get) {
            this.deliver_get = deliver_get;
        }

        public MessageDetails getDeliver_get_details() {
            return deliver_get_details;
        }

        public void setDeliver_get_details(MessageDetails deliver_get_details) {
            this.deliver_get_details = deliver_get_details;
        }

        public long getPublish() {
            return publish;
        }

        public void setPublish(long publish) {
            this.publish = publish;
        }

        public MessageDetails getPublish_details() {
            return publish_details;
        }

        public void setPublish_details(MessageDetails publish_details) {
            this.publish_details = publish_details;
        }

        @Override
        public String toString() {
            return "MessageStat{" +
                    "ack=" + ack +
                    ", ack_details=" + ack_details +
                    ", deliver=" + deliver +
                    ", deliver_details=" + deliver_details +
                    ", deliver_get=" + deliver_get +
                    ", deliver_get_details=" + deliver_get_details +
                    ", publish=" + publish +
                    ", publish_details=" + publish_details +
                    '}';
        }
    }
}
