RabbitMQ-Management-Java
========================

Java bindings for the RabbitMQ Management REST API.  The implementation uses the Jersey REST Client under the hood due to some bizarre issues encountered using Apache HttpComponents (via Spring RestTemplate).  It currently supports Basic Auth, but should have SSL Auth in the next day or so.

> This is definitely a work in progress!  It will continue to mature in support of our AMP project.  Admittedly, the API is a little verbose at the moment.  I have plans to make it far easier to use!

## Examples

```java
BasicAuthHttpClientProvider provider = new BasicAuthHttpClientProvider("guest", "guest");
      	
RabbitMgmtService mgmt = 
  new RabbitMgmtService("localhost", 15672, provider).initialize();

Collection<Exchange> exchanges =  mgmt.exchanges().all();

Exchange ex = new Exchange();
ex.setName("berico.tech");
ex.setType("direct");
ex.setAutoDelete(false);
ex.setDurable(true);
ex.setInternal(false);
ex.setVhost("/");
    		
mgmt.exchanges().create(ex);
    		
Exchange exBackFromServer = mgmt.exchanges().get("berico.tech");

// Downstream = Exchange -> Exchange or Exchange -> Queue
Collection<Binding> amqDirectBindings = mgmt.exchanges().downstreamBindings("amq.direct");

// Upstream = Exchange <- Exchange
Collection<Binding> exchangeToExchangeBindgings = mgmt.exchanges().upstreamBindings("amq.topic");
    		
Collection<Permission> permissionsForDefaultVhost = mgmt.vhosts().permissions();
    		
Collection<User> users = mgmt.users().all();
    		
Collection<Permission> permissionsForGuest = mgmt.users().permissionsFor("guest");
    		
User me = mgmt.users().whoAmI();
    		
Permission permissionForGuestOnDefaultVhost = mgmt.permissions().get("/", "guest");
    		
Queue q = new Queue();
q.setName("test-queue");
q.setDurable(true);
q.setAutoDelete(false);
q.setVhost("/");
    		
// All of the mutation methods are fluent:
mgmt.queues().create(q).get("test-queue");

Binding b = new Binding();
b.setSource(ex.getName());
b.setDestination(q.getName());
b.setDestinationType("queue");
b.setRoutingKey("some.generic.key");
b.setVhost("/");

// Bind the previous exchange to the queue with the binding above.
mgmt.exchanges()
      .create(ex)
    .and()
    .queues()
      .create(q)
    .and()
    .bindings()
      .create(b);
```
