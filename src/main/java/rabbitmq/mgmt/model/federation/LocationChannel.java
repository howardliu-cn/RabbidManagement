package rabbitmq.mgmt.model.federation;

/**
 * @author Richard Clayton (Berico Technologies)
 * @author liuxh (http://www.howardliu.cn)
 */
public class LocationChannel {
    protected ConnectionDetails connection_details;
    protected String idle_since;
    protected boolean transactional;
    protected boolean confirm;
    protected int consumer_count;
    protected int messages_unacknowledged;
    protected int messages_unconfirmed;
    protected int messages_uncommitted;
    protected int acks_uncommitted;
    protected int prefetch_count;
    protected int global_prefetch_count;
    protected String state;
    protected String node;
    protected String name;
    protected int number;
    protected String user;
    protected String vhost;

    public ConnectionDetails getConnection_details() {
        return connection_details;
    }

    public void setConnection_details(ConnectionDetails connection_details) {
        this.connection_details = connection_details;
    }

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

    public int getConsumer_count() {
        return consumer_count;
    }

    public void setConsumer_count(int consumer_count) {
        this.consumer_count = consumer_count;
    }

    public int getMessages_unacknowledged() {
        return messages_unacknowledged;
    }

    public void setMessages_unacknowledged(int messages_unacknowledged) {
        this.messages_unacknowledged = messages_unacknowledged;
    }

    public int getMessages_unconfirmed() {
        return messages_unconfirmed;
    }

    public void setMessages_unconfirmed(int messages_unconfirmed) {
        this.messages_unconfirmed = messages_unconfirmed;
    }

    public int getMessages_uncommitted() {
        return messages_uncommitted;
    }

    public void setMessages_uncommitted(int messages_uncommitted) {
        this.messages_uncommitted = messages_uncommitted;
    }

    public int getAcks_uncommitted() {
        return acks_uncommitted;
    }

    public void setAcks_uncommitted(int acks_uncommitted) {
        this.acks_uncommitted = acks_uncommitted;
    }

    public int getPrefetch_count() {
        return prefetch_count;
    }

    public void setPrefetch_count(int prefetch_count) {
        this.prefetch_count = prefetch_count;
    }

    public int getGlobal_prefetch_count() {
        return global_prefetch_count;
    }

    public void setGlobal_prefetch_count(int global_prefetch_count) {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    @Override
    public String toString() {
        return "LocationChannel{" +
                "connection_details=" + connection_details +
                ", idle_since='" + idle_since + '\'' +
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
                '}';
    }
}
