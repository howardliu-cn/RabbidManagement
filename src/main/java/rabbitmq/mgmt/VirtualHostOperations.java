package rabbitmq.mgmt;

import static rabbitmq.Common.encodeSlashes;

import java.util.Collection;

import com.sun.jersey.api.client.GenericType;

import rabbitmq.mgmt.model.Permission;
import rabbitmq.mgmt.model.Status;
import rabbitmq.mgmt.model.VirtualHost;


public class VirtualHostOperations extends BaseFluent {

	public VirtualHostOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
		super(httpContext, mgmtService);
	}

	public Collection<VirtualHost> all(){
		
		return HTTP.GET("/vhosts", VHOST_COLLECTION);
	}
	
	public VirtualHost get(String vhost){
		
		return HTTP.GET(String.format("/vhosts/%s", encodeSlashes(vhost)), VHOST);
	}
	
	public Status status(){
		
		return this.status("/");
	}
	
	public Status status(String vhost){
		
		return HTTP.GET(
			String.format("/aliveness-test/%s", encodeSlashes(vhost)), new GenericType<Status>(){});
	}
	
	public Collection<Permission> permissions(){
		
		return HTTP.GET("/permissions", PERMISSION_COLLECTION);
	}
	
	public Permission permissions(String user){
		
		return permissions("/", user);
	}
	
	public Permission permissions(String vhost, String user){
		
		return HTTP.GET(String.format("/permissions/%s/%s", encodeSlashes(vhost), user), PERMISSION);
	}
}
