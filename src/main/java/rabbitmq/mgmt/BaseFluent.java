package rabbitmq.mgmt;

import java.util.Collection;

import rabbitmq.mgmt.model.Binding;
import rabbitmq.mgmt.model.Exchange;
import rabbitmq.mgmt.model.Node;
import rabbitmq.mgmt.model.Permission;
import rabbitmq.mgmt.model.Queue;
import rabbitmq.mgmt.model.User;
import rabbitmq.mgmt.model.VirtualHost;


import com.sun.jersey.api.client.GenericType;

public class BaseFluent {
	
	/**
	 * Helps deserialization with Gson.
	 */
	static final GenericType<Exchange> EXCHANGE = new GenericType<Exchange>(){};
	static final GenericType<Collection<Exchange>> EXCHANGE_COLLECTION = new GenericType<Collection<Exchange>>(){};
	
	static final GenericType<Binding> BINDING = new GenericType<Binding>(){};
	static final GenericType<Collection<Binding>> BINDING_COLLECTION = new GenericType<Collection<Binding>>(){};
	
	static final GenericType<Queue> QUEUE = new GenericType<Queue>(){};
	static final GenericType<Collection<Queue>> QUEUE_COLLECTION = new GenericType<Collection<Queue>>(){};
	
	static final GenericType<VirtualHost> VHOST = new GenericType<VirtualHost>(){};
	static final GenericType<Collection<VirtualHost>> VHOST_COLLECTION = new GenericType<Collection<VirtualHost>>(){};
	
	static final GenericType<Permission> PERMISSION = new GenericType<Permission>(){};
	static final GenericType<Collection<Permission>> PERMISSION_COLLECTION = new GenericType<Collection<Permission>>(){};
	
	static final GenericType<User> USER = new GenericType<User>(){};
	static final GenericType<Collection<User>> USER_COLLECTION = new GenericType<Collection<User>>(){};
	
	static final GenericType<Node> NODE = new GenericType<Node>(){};
	static final GenericType<Collection<Node>> NODE_COLLECTION = new GenericType<Collection<Node>>(){};
	
	HttpContext HTTP;
	RabbitMgmtService mgmtService;

	public BaseFluent(HttpContext httpContext, RabbitMgmtService mgmtService){
		
		this.HTTP = httpContext;
		this.mgmtService = mgmtService;
	}
	
	public RabbitMgmtService and(){
		
		return this.mgmtService;
	}
}
