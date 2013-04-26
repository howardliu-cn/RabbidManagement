package rabbitmq.mgmt;

import static rabbitmq.Common.encodeSlashes;

import java.util.Collection;

import com.sun.jersey.api.client.GenericType;

import rabbitmq.mgmt.model.Permission;
import rabbitmq.mgmt.model.Queue;
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
	
	public VirtualHostOperations create(VirtualHost vhost){
		
		String url = String.format("/vhosts/%s", encodeSlashes(vhost.getName()));
		
		HTTP.PUT(url, vhost);
		
		return this;
	}
	
	public Status status(){
		
		return this.status("/");
	}
	
	public Status status(String vhost){
		
		return HTTP.GET(
			String.format("/aliveness-test/%s", encodeSlashes(vhost)), new GenericType<Status>(){});
	}
	
	public Collection<Permission> permissions(){
		
		return permissions("/");
	}
	
	public Collection<Permission> permissions(String vhost){
		
		return HTTP.GET(String.format("/vhosts/%s/permissions", encodeSlashes(vhost)), PERMISSION_COLLECTION);
	}
	
	public Permission permissionsForUser(String user){
		
		return permissionsForUser("/", user);
	}
	
	public Permission permissionsForUser(String vhost, String user){
		
		return HTTP.GET(String.format("/permissions/%s/%s", encodeSlashes(vhost), user), PERMISSION);
	}
}
