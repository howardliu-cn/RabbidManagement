package rabbitmq.mgmt.model;

public class ListenerContext {

	protected String node;
	protected String protocol;
	protected String ip_address;
	protected int port;
	
	public String getNode() {
		return node;
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	
	public int getPort() {
		return port;
	}

	@Override
	public String toString() {
		return "ListenerContext [node=" + node + ", protocol=" + protocol
				+ ", ip_address=" + ip_address + ", port=" + port + "]";
	}
}