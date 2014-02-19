package rabbitmq.mgmt;

import rabbitmq.mgmt.model.Parameter;

import java.util.Collection;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class ParameterOperations extends BaseFluent {

    public ParameterOperations(HttpContext httpContext, RabbitMgmtService mgmtService) {
        super(httpContext, mgmtService);
    }

    public Collection<Parameter> all(){

        return HTTP.GET("/parameters", PARAMETER_COLLECTION).get();
    }
}
