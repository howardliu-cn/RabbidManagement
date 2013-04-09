package rabbitmq.mgmt.model;

public class WebContext {

	protected String description;
	protected String path;
	protected int port;
	protected boolean ignore_in_use = false;
	
	public WebContext(){}

	public String getDescription() {
		return description;
	}

	public String getPath() {
		return path;
	}

	public int getPort() {
		return port;
	}

	public boolean isIgnore_in_use() {
		return ignore_in_use;
	}

	@Override
	public String toString() {
		return "WebContext [description=" + description + ", path=" + path
				+ ", port=" + port + ", ignore_in_use=" + ignore_in_use + "]";
	}
}
