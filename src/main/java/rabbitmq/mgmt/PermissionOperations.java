package rabbitmq.mgmt;

import static rabbitmq.Common.encodeSlashes;

import java.util.Collection;

import rabbitmq.mgmt.model.Permission;


public class PermissionOperations extends BaseFluent {

	public PermissionOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
		super(httpContext, mgmtService);
	}

	public Collection<Permission> all(){
		
		return HTTP.GET("/permissions", PERMISSION_COLLECTION);
	}
	
	public Permission get(String user){
		
		return get("/", user);
	}
	
	public Permission get(String vhost, String user){
		
		return HTTP.GET(String.format("/permissions/%s/%s", encodeSlashes(vhost), user),  PERMISSION);
	}
	
	public PermissionOperations set(Permission permission){
		
		HTTP.PUT(String.format("/permissions/%s/%s", 
			encodeSlashes(permission.getVhost()), permission.getUser()), permission);
		
		return this;
	}
	
	public PermissionOperations remove(String user){
		
		return remove(user);
	}
	
	public PermissionOperations remove(String vhost, String user){
		
		String url = String.format("/permissions/%s/%s", encodeSlashes(vhost), user);
		
		HTTP.DELETE(url);
		
		return this;
	}
	
}
