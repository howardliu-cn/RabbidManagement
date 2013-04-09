package rabbitmq.mgmt.model;

public class QueueTotals {

	protected long messages;
	protected long messages_ready;
	protected long messages_unacknowledged;
	protected MessageDetails messages_details;
	protected MessageDetails messages_ready_details;
	protected MessageDetails messages_unacknowledged_details;
	
	public long getMessages() {
		return messages;
	}
	
	public long getMessages_ready() {
		return messages_ready;
	}
	
	public long getMessages_unacknowledged() {
		return messages_unacknowledged;
	}
	
	public MessageDetails getMessages_details() {
		return messages_details;
	}
	
	public MessageDetails getMessages_ready_details() {
		return messages_ready_details;
	}
	
	public MessageDetails getMessages_unacknowledged_details() {
		return messages_unacknowledged_details;
	}

	@Override
	public String toString() {
		return "QueueTotals [messages=" + messages + ", messages_ready="
				+ messages_ready + ", messages_unacknowledged="
				+ messages_unacknowledged + ", messages_details="
				+ messages_details + ", messages_ready_details="
				+ messages_ready_details + ", messages_unacknowledged_details="
				+ messages_unacknowledged_details + "]";
	}
}