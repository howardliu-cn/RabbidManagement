package rabbitmq.mgmt.model;

import java.util.HashMap;
import java.util.Map;

public class Queue {

	protected long memory;
	protected String idle_since;
	protected String policy;
	protected String exclusive_consumer_tag;
	protected long messages_ready;
	protected long messages_unacknowledged;
	protected long messages;
	protected int consumers;
	protected int active_consumers;
	protected BackingQueueStatus backing_queue_status;
	protected String name;
	protected String vhost;
	protected boolean durable;
	protected boolean auto_delete;
	protected Map<String, String> arguments = new HashMap<String, String>();
	protected String node;
	protected MessageDetails messages_details;
	protected MessageDetails messages_ready_details;
	protected MessageDetails messages_unacknowledged_details;
	
	public Queue(){}
	
	public Queue(String name, String vhost, boolean durable,
			boolean auto_delete, Map<String, String> arguments) {
		this.name = name;
		this.vhost = vhost;
		this.durable = durable;
		this.auto_delete = auto_delete;
		this.arguments = arguments;
	}

	public long getMemory() {
		return memory;
	}
	
	public String getIdleSince() {
		return idle_since;
	}
	
	public String getPolicy() {
		return policy;
	}
	
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	public String getExclusiveConsumerTag() {
		return exclusive_consumer_tag;
	}
	
	public long getMessagesReady() {
		return messages_ready;
	}
	
	public long getMessagesUnacknowledged() {
		return messages_unacknowledged;
	}
	
	public long getMessages() {
		return messages;
	}
	
	public int getConsumers() {
		return consumers;
	}
	
	public int getActiveConsumers() {
		return active_consumers;
	}
	
	public BackingQueueStatus getBackingQueueStatus() {
		return backing_queue_status;
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
	
	public boolean isDurable() {
		return durable;
	}
	
	public void setDurable(boolean durable) {
		this.durable = durable;
	}
	
	public boolean isAutoDelete() {
		return auto_delete;
	}
	
	public void setAutoDelete(boolean autoDelete) {
		this.auto_delete = autoDelete;
	}
	
	public Map<String, String> getArguments() {
		return arguments;
	}
	
	public void setArguments(Map<String, String> arguments) {
		this.arguments = arguments;
	}
	
	public String getNode() {
		return node;
	}

	public MessageDetails getMessagesDetails() {
		return messages_details;
	}

	public MessageDetails getMessagesReadyDetails() {
		return messages_ready_details;
	}

	public MessageDetails getMessagesUnacknowledgedDetails() {
		return messages_unacknowledged_details;
	}

	@Override
	public String toString() {
		return "Queue [memory=" + memory + ", idle_since=" + idle_since
				+ ", policy=" + policy + ", exclusive_consumer_tag="
				+ exclusive_consumer_tag + ", messages_ready=" + messages_ready
				+ ", messages_unacknowledged=" + messages_unacknowledged
				+ ", messages=" + messages + ", consumers=" + consumers
				+ ", active_consumers=" + active_consumers
				+ ", backing_queue_status=" + backing_queue_status + ", name="
				+ name + ", vhost=" + vhost + ", durable=" + durable
				+ ", auto_delete=" + auto_delete + ", arguments=" + arguments
				+ ", node=" + node + ", messages_details=" + messages_details
				+ ", messages_ready_details=" + messages_ready_details
				+ ", messages_unacknowledged_details="
				+ messages_unacknowledged_details + "]";
	}
	
}