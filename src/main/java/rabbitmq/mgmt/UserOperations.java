package rabbitmq.mgmt;

import java.util.Collection;

import rabbitmq.mgmt.model.Permission;
import rabbitmq.mgmt.model.User;


public class UserOperations extends BaseFluent {

	public UserOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
		super(httpContext, mgmtService);
	}
	
	public Collection<User> all(){
		
		return HTTP.GET("/users", USER_COLLECTION);
	}
	
	public User whoAmI(){
		
		return HTTP.GET("/whoami", USER);
	}
	
	public Collection<Permission> permissionsFor(String user){
		
		return HTTP.GET(String.format("/users/%s/permissions", user), PERMISSION_COLLECTION);
	}
	
	public UserOperations create(User user){
		
		HTTP.PUT(String.format("/users/%s", user.getName()), user);
		
		return this;
	}
	
	public UserOperations delete(String name){
		
		HTTP.DELETE(String.format("/users/%s", name));
		
		return this;
	}
}
