package rabbitmq.mgmt.model;

public class User {

	protected String name;
	protected String tags;
	
	public User(){}
	
	public User(String name, String tags) {
		this.name = name;
		this.tags = tags;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}
	
	public String getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", tags=" + tags + "]";
	}
}