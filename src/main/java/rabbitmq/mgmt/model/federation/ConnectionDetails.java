package rabbitmq.mgmt.model.federation;

/**
 * @author Richard Clayton (Berico Technologies)
 * @author liuxh (http://www.howardliu.cn)
 */
public class ConnectionDetails {
    protected String name;
    protected String peer_port;
    protected String peer_host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeer_port() {
        return peer_port;
    }

    public void setPeer_port(String peer_port) {
        this.peer_port = peer_port;
    }

    public String getPeer_host() {
        return peer_host;
    }

    public void setPeer_host(String peer_host) {
        this.peer_host = peer_host;
    }

    @Override
    public String toString() {
        return "ConnectionDetails{" +
                "name='" + name + '\'' +
                ", peer_port='" + peer_port + '\'' +
                ", peer_host='" + peer_host + '\'' +
                '}';
    }
}
