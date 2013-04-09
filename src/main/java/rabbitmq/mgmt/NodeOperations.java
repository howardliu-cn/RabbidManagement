package rabbitmq.mgmt;

import java.util.Collection;

import rabbitmq.mgmt.model.Node;

public class NodeOperations extends BaseFluent {

	public NodeOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
		super(httpContext, mgmtService);
	}

	
	public Collection<Node> all(){
		
		return HTTP.GET("/nodes", NODE_COLLECTION);
	}
	
	public Node get(String name){
		
		return HTTP.GET(String.format("/nodes/%s", name), NODE);
	}
	
}
