package rabbitmq.mgmt.model;

/**
 * <br/>created at 16-9-7
 *
 * @author liuxh
 * @since 1.2.0
 */
public class CustomDetails {
    private ChannelDetails channel_details;
    private Queue queue;
    private String consumer_tag;
    private boolean exclusive;
    private boolean ack_required;
    private long prefetch_count;
    private Object arguments;

    public ChannelDetails getChannel_details() {
        return channel_details;
    }

    public void setChannel_details(ChannelDetails channel_details) {
        this.channel_details = channel_details;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public String getConsumer_tag() {
        return consumer_tag;
    }

    public void setConsumer_tag(String consumer_tag) {
        this.consumer_tag = consumer_tag;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isAck_required() {
        return ack_required;
    }

    public void setAck_required(boolean ack_required) {
        this.ack_required = ack_required;
    }

    public long getPrefetch_count() {
        return prefetch_count;
    }

    public void setPrefetch_count(long prefetch_count) {
        this.prefetch_count = prefetch_count;
    }

    public Object getArguments() {
        return arguments;
    }

    public void setArguments(Object arguments) {
        this.arguments = arguments;
    }
}
