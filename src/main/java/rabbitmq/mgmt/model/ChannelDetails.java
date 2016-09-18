package rabbitmq.mgmt.model;

/**
 * <br/>created at 16-9-7
 *
 * @author liuxh
 * @since 1.2.0
 */
public class ChannelDetails {
    private String name;
    private long number;
    private String connection_name;
    private String peer_port;
    private String peer_host;

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

    public String getConnection_name() {
        return connection_name;
    }

    public void setConnection_name(String connection_name) {
        this.connection_name = connection_name;
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
}
