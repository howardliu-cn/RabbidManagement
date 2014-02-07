RabbitMQ-Management-Java
========================

Java bindings for the RabbitMQ Management REST API.  The implementation uses the Jersey REST Client under the hood due to some bizarre issues encountered using Apache HttpComponents (via Spring RestTemplate).  It currently supports Basic Auth, but should have SSL Auth in the next day or so.


## Changelog

> Note about versions.  This library was originally keeping in sync with the AMPere project (so it started it's life at 3.1.0.  I'm going to break with tradition an let it version as needed.  Sorry for any confusion.

**v3.3.0**

- Support for Producing and Consuming using HTTP via the Management Console's pub/sub mechanisms.
- Added `Message`, `ReceivedMessage`, `PublishResponse`, `ConsumeOptions` to support PubSub.
- Revised the `HttpContext` to support the retrieval of objects on HTTP `POST` calls (which is generally the only time outside of a `GET` that you can expect an object back).
- Replaced return types with Google Guava's `Optional<T>` and added more robust error handling (no more GSON parsing exceptions if an entity does exist; i.e. 404 error as HTTP status).  Now you can check to see if you actually have a valid model object instead of incurring an error when it should not occur.  `Optional` is not imposed on methods that should return a response (these are generally the parameterless `GET` methods that will fail only if there is a connection error).
- Support for Integration Testing.  The real reason for the improvements was to allow me to make assertions about RabbitMQ's configuration and the presence of messages.
- Added a builder for `RabbitMgmtService`.

**v3.2.0**

- Bug fixes on some of the models to more accurately reflect the types coming back from the console.

**v3.1.0**

- Initial release including support for most of the RabbitMQ Management Console functions.


## Examples

There's basic command and control functionality that maps directly to the RabbitMQ Management Console.

```java
RabbitMgmtService mgmt = RabbitMgmtService.builder().host(hostname).port(15672).credentials("guest", "guest").build();

Collection<Exchange> exchanges =  mgmt.exchanges().all();

Exchange ex = new Exchange();
ex.setName("berico.tech");
ex.setType("direct");
ex.setAutoDelete(false);
ex.setDurable(true);
ex.setInternal(false);
ex.setVhost("/");
    		
mgmt.exchanges().create(ex);
    		
Optional<Exchange> exBackFromServer = mgmt.exchanges().get("berico.tech");

// Downstream = Exchange -> Exchange or Exchange -> Queue
Optional<Collection<Binding>> amqDirectBindings = mgmt.exchanges().downstreamBindings("amq.direct");

// Upstream = Exchange <- Exchange
Optional<Collection<Binding>> exchangeToExchangeBindgings = mgmt.exchanges().upstreamBindings("amq.topic");
    		
Collection<Permission> permissionsForDefaultVhost = mgmt.vhosts().permissions();
    		
Collection<User> users = mgmt.users().all();
    		
Optional<Collection<Permission>> permissionsForGuest = mgmt.users().permissionsFor("guest");
    		
User me = mgmt.users().whoAmI();
    		
Optional<Permission> permissionForGuestOnDefaultVhost = mgmt.permissions().get("/", "guest");
    		
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

You can now even publish and consume test messages with the API now:

```java
mgmt.queues()
        .create(new Queue("q1"))
    .and()
    .exchanges()
        .create(new Exchange("ex1"))
    .and()
    .bindings()
        .create(new Binding("ex1", "q1", "topic1"));

mgmt.exchanges().publish("ex1", new Message().setPayload("Hello!").setRoutingKey("topic1"));

Optional<Collection<ReceivedMessage>> messages =
        mgmt.queues().consume("q1", ConsumeOptions.builder().requeueMessage(false).build());
```


I've also added some helper functionality for testing the state of a RabbitMQ cluster which you can integrate into your integration-tests:

```java
RabbitMgmtService mgmt = RabbitMgmtService.builder().host("rabbit.archnet.mil").build();

RabbitAssert rabbitAssert = new RabbitAssert(mgmt);

rabbitAssert.hasExchange("test.example.exchange", isDirectType());

rabbitAssert.hasQueue("test.example.queue", isNotQDurable());

rabbitAssert.hasBinding("test.example.exchange", "test.example.queue", routingKey("test.topic"), isExToQ());

```