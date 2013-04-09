package rabbitmq.mgmt.model;

public class VirtualHost {

	protected String name;
	protected boolean tracing;
	
	public VirtualHost(){}
	
	public VirtualHost(String name, boolean tracing) {
		this.name = name;
		this.tracing = tracing;
	}

	public String getName() {
		return name;
	}
	
	public boolean isTracing() {
		return tracing;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTracing(boolean tracing) {
		this.tracing = tracing;
	}

	@Override
	public String toString() {
		return "VirtualHost [name=" + name + ", tracing=" + tracing + "]";
	}
	
}
