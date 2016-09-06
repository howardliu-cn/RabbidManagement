package rabbitmq.mgmt.model;

import java.util.Collection;

/**
 * Overview information for a single instance of the RabbitMQ Management Console
 * (i.e. not everything is cluster information).
 *
 * @author Richard Clayton (Berico Technologies)
 * @author liuxh (http://www.howardliu.cn)
 */
public class Overview {
    protected String management_version;
    protected String rates_mode;
    protected Collection<ExchangeType> exchange_types;
    protected String rabbitmq_version;
    protected String cluster_name;
    protected String erlang_version;
    protected String erlang_full_version;
    protected MessageStats message_stats;
    protected QueueTotals queue_totals;
    protected TopologyObjectTotals object_totals;
    protected Long statistics_db_event_queue;
    protected String statistics_level;
    protected String node;
    protected String statistics_db_node;
    protected Collection<ListenerContext> listeners;
    protected Collection<WebContext> contexts;

    public String getManagement_version() {
        return management_version;
    }

    public void setManagement_version(String management_version) {
        this.management_version = management_version;
    }

    public String getRates_mode() {
        return rates_mode;
    }

    public void setRates_mode(String rates_mode) {
        this.rates_mode = rates_mode;
    }

    public Collection<ExchangeType> getExchange_types() {
        return exchange_types;
    }

    public void setExchange_types(Collection<ExchangeType> exchange_types) {
        this.exchange_types = exchange_types;
    }

    public String getRabbitmq_version() {
        return rabbitmq_version;
    }

    public void setRabbitmq_version(String rabbitmq_version) {
        this.rabbitmq_version = rabbitmq_version;
    }

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getErlang_version() {
        return erlang_version;
    }

    public void setErlang_version(String erlang_version) {
        this.erlang_version = erlang_version;
    }

    public String getErlang_full_version() {
        return erlang_full_version;
    }

    public void setErlang_full_version(String erlang_full_version) {
        this.erlang_full_version = erlang_full_version;
    }

    public MessageStats getMessage_stats() {
        return message_stats;
    }

    public void setMessage_stats(MessageStats message_stats) {
        this.message_stats = message_stats;
    }

    public QueueTotals getQueue_totals() {
        return queue_totals;
    }

    public void setQueue_totals(QueueTotals queue_totals) {
        this.queue_totals = queue_totals;
    }

    public TopologyObjectTotals getObject_totals() {
        return object_totals;
    }

    public void setObject_totals(TopologyObjectTotals object_totals) {
        this.object_totals = object_totals;
    }

    public Long getStatistics_db_event_queue() {
        return statistics_db_event_queue;
    }

    public void setStatistics_db_event_queue(Long statistics_db_event_queue) {
        this.statistics_db_event_queue = statistics_db_event_queue;
    }

    public String getStatistics_level() {
        return statistics_level;
    }

    public void setStatistics_level(String statistics_level) {
        this.statistics_level = statistics_level;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getStatistics_db_node() {
        return statistics_db_node;
    }

    public void setStatistics_db_node(String statistics_db_node) {
        this.statistics_db_node = statistics_db_node;
    }

    public Collection<ListenerContext> getListeners() {
        return listeners;
    }

    public void setListeners(Collection<ListenerContext> listeners) {
        this.listeners = listeners;
    }

    public Collection<WebContext> getContexts() {
        return contexts;
    }

    public void setContexts(Collection<WebContext> contexts) {
        this.contexts = contexts;
    }

    @Override
    public String toString() {
        return "Overview{" +
                "management_version='" + management_version + '\'' +
                ", rates_mode='" + rates_mode + '\'' +
                ", exchange_types=" + exchange_types +
                ", rabbitmq_version='" + rabbitmq_version + '\'' +
                ", cluster_name='" + cluster_name + '\'' +
                ", erlang_version='" + erlang_version + '\'' +
                ", erlang_full_version='" + erlang_full_version + '\'' +
                ", queue_totals=" + queue_totals +
                ", object_totals=" + object_totals +
                ", statistics_db_event_queue=" + statistics_db_event_queue +
                ", statistics_level='" + statistics_level + '\'' +
                ", node='" + node + '\'' +
                ", statistics_db_node='" + statistics_db_node + '\'' +
                ", listeners=" + listeners +
                ", contexts=" + contexts +
                '}';
    }

    /**
     * <br/>created at 16-8-29
     *
     * @author liuxh (http://www.howardliu.cn)
     * @since 3.8.0
     */
    public static class MessageStats {
        protected long publish;
        protected MessageDetails publish_details;
        protected long ack;
        protected MessageDetails ack_details;
        protected long deliver_get;
        protected MessageDetails deliver_get_details;
        protected long confirm;
        protected MessageDetails confirm_details;
        protected long redeliver;
        protected MessageDetails redeliver_details;
        protected long deliver;
        protected MessageDetails deliver_details;

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

        public long getRedeliver() {
            return redeliver;
        }

        public void setRedeliver(long redeliver) {
            this.redeliver = redeliver;
        }

        public MessageDetails getRedeliver_details() {
            return redeliver_details;
        }

        public void setRedeliver_details(MessageDetails redeliver_details) {
            this.redeliver_details = redeliver_details;
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
    }
}
