package rabbitmq;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rabbitmq.httpclient.BasicAuthHttpClientProvider;
import rabbitmq.mgmt.RabbitMgmtService;
import rabbitmq.mgmt.model.Exchange;
import rabbitmq.mgmt.model.Queue;


public class App 
{
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) throws URISyntaxException
    {	
    		BasicAuthHttpClientProvider provider = new BasicAuthHttpClientProvider("guest", "guest");
    		
    		RabbitMgmtService mgmt = 
    			new RabbitMgmtService("localhost", 15672, provider).initialize();
    		
    		log(mgmt.exchanges().downstreamBindings("amq.direct"));
    		
    		log(mgmt.exchanges().upstreamBindings("amq.topic"));
    		
    		log(mgmt.vhosts().permissions());
    		
    		log(mgmt.users().all());
    		
    		log(mgmt.users().permissionsFor("guest"));
    		
    		log(mgmt.users().whoAmI());
    		
    		log(mgmt.permissions().get("/", "guest"));
    		
    		log(mgmt.exchanges().all());
    		
    		Exchange ex = new Exchange();
    		ex.setName("jersey.rules");
    		ex.setType("direct");
    		ex.setAutoDelete(false);
    		ex.setDurable(true);
    		ex.setInternal(false);
    		ex.setVhost("/");
    		
    		mgmt.exchanges().create(ex);
    		
    		log(mgmt.exchanges().get("jersey.rules"));
    		
    		Queue q = new Queue();
    		q.setName("test-queue");
    		q.setDurable(true);
    		q.setAutoDelete(false);
    		q.setVhost("/");
    		
    		log(mgmt.queues().create(q).get("test-queue"));
    		
    		log(mgmt.nodes().all());
    		
    		log(mgmt.overview());
    		
    		log(mgmt.vhosts().status());
    		
    		log(mgmt.vhosts().status("test"));
    }
    
    public static void log(String template, Object... args){
    	
    		logger.info(template, args);
    }
    
    public static void log(Object obj){
    	
		logger.info("{}", obj);
    }
}
