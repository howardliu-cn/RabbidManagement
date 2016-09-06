package rabbitmq.mgmt.model;

import java.io.Serializable;

public class Connection implements Serializable {
    private int recv_oct;
    private OctDetails recv_oct_details;
    private int send_oct;
    private OctDetails send_oct_details;
    private int recv_cnt;
    private int send_cnt;
    private int send_pend;
    private String state;
    private String last_blocked_by;
    private String last_blocked_age;
    private int channels;
    private String type;
    private String node;
    private String name;
    private int port;
    private int peer_port;
    private String host;
    private String peer_host;
    private boolean ssl;
    private String peer_cert_subject;
    private String peer_cert_issuer;
    private String peer_cert_validity;
    private String auth_mechanism;
    private String ssl_protocol;
    private String ssl_key_exchange;
    private String ssl_cipher;
    private String protocol;
    private String user;
    private String vhost;
    private int timeout;
    private int frame_max;
    private ClientProperties client_properties;

    public int getRecv_oct() {
        return recv_oct;
    }

    public void setRecv_oct(int recv_oct) {
        this.recv_oct = recv_oct;
    }

    public OctDetails getRecv_oct_details() {
        return recv_oct_details;
    }

    public void setRecv_oct_details(OctDetails recv_oct_details) {
        this.recv_oct_details = recv_oct_details;
    }

    public int getSend_oct() {
        return send_oct;
    }

    public void setSend_oct(int send_oct) {
        this.send_oct = send_oct;
    }

    public OctDetails getSend_oct_details() {
        return send_oct_details;
    }

    public void setSend_oct_details(OctDetails send_oct_details) {
        this.send_oct_details = send_oct_details;
    }

    public int getRecv_cnt() {
        return recv_cnt;
    }

    public void setRecv_cnt(int recv_cnt) {
        this.recv_cnt = recv_cnt;
    }

    public int getSend_cnt() {
        return send_cnt;
    }

    public void setSend_cnt(int send_cnt) {
        this.send_cnt = send_cnt;
    }

    public int getSend_pend() {
        return send_pend;
    }

    public void setSend_pend(int send_pend) {
        this.send_pend = send_pend;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLast_blocked_by() {
        return last_blocked_by;
    }

    public void setLast_blocked_by(String last_blocked_by) {
        this.last_blocked_by = last_blocked_by;
    }

    public String getLast_blocked_age() {
        return last_blocked_age;
    }

    public void setLast_blocked_age(String last_blocked_age) {
        this.last_blocked_age = last_blocked_age;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getPeer_port() {
        return peer_port;
    }

    public void setPeer_port(int peer_port) {
        this.peer_port = peer_port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPeer_host() {
        return peer_host;
    }

    public void setPeer_host(String peer_host) {
        this.peer_host = peer_host;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public String getPeer_cert_subject() {
        return peer_cert_subject;
    }

    public void setPeer_cert_subject(String peer_cert_subject) {
        this.peer_cert_subject = peer_cert_subject;
    }

    public String getPeer_cert_issuer() {
        return peer_cert_issuer;
    }

    public void setPeer_cert_issuer(String peer_cert_issuer) {
        this.peer_cert_issuer = peer_cert_issuer;
    }

    public String getPeer_cert_validity() {
        return peer_cert_validity;
    }

    public void setPeer_cert_validity(String peer_cert_validity) {
        this.peer_cert_validity = peer_cert_validity;
    }

    public String getAuth_mechanism() {
        return auth_mechanism;
    }

    public void setAuth_mechanism(String auth_mechanism) {
        this.auth_mechanism = auth_mechanism;
    }

    public String getSsl_protocol() {
        return ssl_protocol;
    }

    public void setSsl_protocol(String ssl_protocol) {
        this.ssl_protocol = ssl_protocol;
    }

    public String getSsl_key_exchange() {
        return ssl_key_exchange;
    }

    public void setSsl_key_exchange(String ssl_key_exchange) {
        this.ssl_key_exchange = ssl_key_exchange;
    }

    public String getSsl_cipher() {
        return ssl_cipher;
    }

    public void setSsl_cipher(String ssl_cipher) {
        this.ssl_cipher = ssl_cipher;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getFrame_max() {
        return frame_max;
    }

    public void setFrame_max(int frame_max) {
        this.frame_max = frame_max;
    }

    public ClientProperties getClient_properties() {
        return client_properties;
    }

    public void setClient_properties(ClientProperties client_properties) {
        this.client_properties = client_properties;
    }

    public static class OctDetails {
        private double rate;

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }

    public static class ClientProperties implements Serializable {
        private String product;
        private String information;
        private String platform;
        private String copyright;
        private String version;
        private ClientCapabilities capabilities;

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public ClientCapabilities getCapabilities() {
            return capabilities;
        }

        public void setCapabilities(ClientCapabilities capabilities) {
            this.capabilities = capabilities;
        }
    }

    public static class ClientCapabilities implements Serializable {
       private boolean exchange_exchange_bindings;
       private boolean consumer_cancel_notify;
       private boolean basic_nack;
       private boolean publisher_confirms;

        public boolean isExchange_exchange_bindings() {
            return exchange_exchange_bindings;
        }

        public void setExchange_exchange_bindings(boolean exchange_exchange_bindings) {
            this.exchange_exchange_bindings = exchange_exchange_bindings;
        }

        public boolean isConsumer_cancel_notify() {
            return consumer_cancel_notify;
        }

        public void setConsumer_cancel_notify(boolean consumer_cancel_notify) {
            this.consumer_cancel_notify = consumer_cancel_notify;
        }

        public boolean isBasic_nack() {
            return basic_nack;
        }

        public void setBasic_nack(boolean basic_nack) {
            this.basic_nack = basic_nack;
        }

        public boolean isPublisher_confirms() {
            return publisher_confirms;
        }

        public void setPublisher_confirms(boolean publisher_confirms) {
            this.publisher_confirms = publisher_confirms;
        }
    }
}
