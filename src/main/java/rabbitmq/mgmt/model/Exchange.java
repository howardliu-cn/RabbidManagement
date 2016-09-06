package rabbitmq.mgmt.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * An AMQP Exchange.
 *
 * @author Richard Clayton (Berico Technologies)
 */
public class Exchange {
    protected String name;
    protected String vhost = "/";
    protected String type = "direct";
    protected boolean durable = false;
    protected boolean auto_delete = false;
    protected boolean internal = false;
    protected Map<String, Object> arguments = Maps.newHashMap();
    protected String policy;
    protected MessageStats message_stats;

    public Exchange() {
    }

    public Exchange(String name) {
        this.name = name;
    }

    public Exchange(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDurable() {
        return durable;
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }

    public boolean isAuto_delete() {
        return auto_delete;
    }

    public void setAuto_delete(boolean auto_delete) {
        this.auto_delete = auto_delete;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public Map<String, Object> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, Object> arguments) {
        this.arguments = arguments;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public MessageStats getMessage_stats() {
        return message_stats;
    }

    public void setMessage_stats(MessageStats message_stats) {
        this.message_stats = message_stats;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "name='" + name + '\'' +
                ", vhost='" + vhost + '\'' +
                ", type='" + type + '\'' +
                ", durable=" + durable +
                ", auto_delete=" + auto_delete +
                ", internal=" + internal +
                ", arguments=" + arguments +
                ", policy='" + policy + '\'' +
                ", message_stats=" + message_stats +
                '}';
    }

    public static Builder builder(){ return new Builder(); }

    public static class Builder {
        Exchange exchange = new Exchange();

        public Builder name(String exchangeName){
            exchange.setName(exchangeName);
            return this;
        }

        public Builder vhost(String vhost){
            exchange.setVhost(vhost);
            return this;
        }

        public Builder direct(){
            return type("direct");
        }

        public Builder fanout(){
            return type("fanout");
        }

        public Builder topic(){
            return type("topic");
        }

        public Builder headers(){
            return type("headers");
        }

        public Builder type(String exchangeType){
            exchange.setType(exchangeType);
            return this;
        }

        public Builder durable(boolean trueIfDurable){
            exchange.setDurable(trueIfDurable);
            return this;
        }

        public Builder durable(){
            return durable(true);
        }

        public Builder autoDelete(boolean trueIfAutoDelete){
            exchange.setAuto_delete(trueIfAutoDelete);
            return this;
        }

        public Builder autoDelete(){
            return autoDelete(true);
        }

        public Builder internal(boolean trueIfInternal){
            exchange.setInternal(trueIfInternal);
            return this;
        }

        public Builder internal(){
            return internal(true);
        }

        public Builder arg(String key, Object value){
            exchange.getArguments().put(key, value);
            return this;
        }

        public Builder arguments(Map<String, Object> arguments){
            exchange.getArguments().putAll(arguments);
            return this;
        }
        public Exchange build(){ return exchange; }
    }

    /**
     * <br/>created at 16-9-6
     *
     * @author liuxh (http://www.howardliu.cn)
     * @since 3.8.1
     */
    public static class MessageStats {
        private long confirm;
        private MessageDetails confirm_details;
        private long publish_in;
        private MessageDetails publish_in_details;
        private long publish_out;
        private MessageDetails publish_out_details;

        public long getConfirm() {
            return confirm;
        }

        public void setConfirm(long confirm) {
            this.confirm = confirm;
        }

        public MessageDetails getConfirm_details() {
            return confirm_details;
        }

        public void setConfirm_details(MessageDetails confirm_details) {
            this.confirm_details = confirm_details;
        }

        public long getPublish_in() {
            return publish_in;
        }

        public void setPublish_in(long publish_in) {
            this.publish_in = publish_in;
        }

        public MessageDetails getPublish_in_details() {
            return publish_in_details;
        }

        public void setPublish_in_details(MessageDetails publish_in_details) {
            this.publish_in_details = publish_in_details;
        }

        public long getPublish_out() {
            return publish_out;
        }

        public void setPublish_out(long publish_out) {
            this.publish_out = publish_out;
        }

        public MessageDetails getPublish_out_details() {
            return publish_out_details;
        }

        public void setPublish_out_details(MessageDetails publish_out_details) {
            this.publish_out_details = publish_out_details;
        }

        @Override
        public String toString() {
            return "MessageStats{" +
                    "confirm=" + confirm +
                    ", confirm_details=" + confirm_details +
                    ", publish_in=" + publish_in +
                    ", publish_in_details=" + publish_in_details +
                    ", publish_out=" + publish_out +
                    ", publish_out_details=" + publish_out_details +
                    '}';
        }
    }
}