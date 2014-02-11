package rabbitmq.test;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import rabbitmq.mgmt.RabbitMgmtService;
import rabbitmq.mgmt.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class RabbitAssert {

    private RabbitMgmtService mgmt;

    public RabbitAssert(RabbitMgmtService mgmt){
        this.mgmt = mgmt;
    }

    public RabbitAssert hasNode(String nodeName, NodeMatcher... matchers){

        Optional<Node> node = mgmt.nodes().get(nodeName);

        assertTrue(node.isPresent());

        if (matchers != null && matchers.length > 0) assertTrue(isMatch(node.get(), matchers));

        return this;
    }

    public RabbitAssert doesNotHaveNode(String nodeName, NodeMatcher... matchers){

        Optional<Node> node = mgmt.nodes().get(nodeName);

        if (node.isPresent()){
            if (matchers != null && matchers.length > 0) assertFalse(isMatch(node.get(), matchers));
        }

        return this;
    }

    public RabbitAssert hasVHost(String vhostName){

        Optional<VirtualHost> vhost = mgmt.vhosts().get(vhostName);

        assertTrue(vhost.isPresent());

        return this;
    }

    public RabbitAssert doesNotHaveVHost(String vhostName){

        Optional<VirtualHost> vhost = mgmt.vhosts().get(vhostName);

        assertFalse(vhost.isPresent());

        return this;
    }

    public RabbitAssert hasUser(String username){

        Optional<User> user = mgmt.users().get(username);

        assertTrue(user.isPresent());

        return this;
    }

    public RabbitAssert doesNotHaveUser(String username){

        Optional<User> user = mgmt.users().get(username);

        assertFalse(user.isPresent());

        return this;
    }

    public RabbitAssert iAm(String username){

        User clientUser = mgmt.users().whoAmI();

        assertEquals(username, clientUser.getName());

        return this;
    }

    public RabbitAssert userHasTags(String username, String... expectedTags){

        Preconditions.checkNotNull(expectedTags);
        Preconditions.checkArgument(expectedTags.length > 0);

        Optional<User> user = mgmt.users().get(username);

        assertTrue(user.isPresent());

        String tagCsv = user.get().getTags();

        if (!Strings.isNullOrEmpty(tagCsv)){

            List<String> tagList = splitTags(tagCsv);

            assertTrue(tagList.containsAll(Arrays.asList(expectedTags)));
        }
        else {

            fail();
        }

        return this;
    }

    public RabbitAssert userNotHaveTags(String username, String... notExpectedTags){

        Preconditions.checkNotNull(notExpectedTags);
        Preconditions.checkArgument(notExpectedTags.length > 0);

        Optional<User> user = mgmt.users().get(username);

        assertTrue(user.isPresent());

        String tagCsv = user.get().getTags();

        if (!Strings.isNullOrEmpty(tagCsv)){

            List<String> tagList = splitTags(tagCsv);

            for (String notExpectedTag : notExpectedTags)
                assertFalse(tagList.contains(notExpectedTag));
        }

        return this;
    }

    public RabbitAssert userHasReadPermission(String user, String permissionExpression){

        return this.userHasPermission("/", user, permissionExpression, 1);
    }

    public RabbitAssert userHasReadPermission(String vhost, String user, String permissionExpression){

        return this.userHasPermission(vhost, user, permissionExpression, 1);
    }

    public RabbitAssert userHasWritePermission(String user, String permissionExpression){

        return this.userHasPermission("/", user, permissionExpression, 2);
    }

    public RabbitAssert userHasWritePermission(String vhost, String user, String permissionExpression){

        return this.userHasPermission(vhost, user, permissionExpression, 2);
    }

    public RabbitAssert userHasConfigurePermission(String user, String permissionExpression){

        return this.userHasPermission("/", user, permissionExpression, 3);
    }

    public RabbitAssert userHasConfigurePermission(String vhost, String user, String permissionExpression){

        return this.userHasPermission(vhost, user, permissionExpression, 3);
    }

    private RabbitAssert userHasPermission(String vhost, String user, String permissionExpression, int permissionType){

        Optional<Permission> permission = mgmt.permissions().get(vhost, user);

        assertTrue(permission.isPresent());

        switch (permissionType){
            case 1: assertEquals(permissionExpression, permission.get().getRead()); break;
            case 2: assertEquals(permissionExpression, permission.get().getWrite()); break;
            default: assertEquals(permissionExpression, permission.get().getConfigure()); break;
        }

        return this;
    }

    public RabbitAssert hasExchange(String exchangeName, ExchangeMatcher... matchers){

        return hasExchange("/", exchangeName);
    }

    public RabbitAssert hasExchange(String vhost, String exchangeName, ExchangeMatcher... matchers){

        Optional<Exchange> exchange = mgmt.exchanges().get(vhost, exchangeName);

        assertTrue(exchange.isPresent());

        if (matchers != null && matchers.length > 0) assertTrue(isMatch(exchange.get(), matchers));

        return this;
    }

    public RabbitAssert doesNotHaveExchange(String exchangeName){

        return this.doesNotHaveExchange("/", exchangeName);
    }

    public RabbitAssert doesNotHaveExchange(String vhost, String exchangeName){

        Optional<Exchange> exchange = mgmt.exchanges().get(vhost, exchangeName);

        assertFalse(exchange.isPresent());

        return this;
    }

    public RabbitAssert hasQueue(String queueName, QueueMatcher... matchers){

        return hasQueue("/", queueName, matchers);
    }

    public RabbitAssert hasQueue(String vhost, String queueName, QueueMatcher... matchers) {

        Optional<Queue> queue = mgmt.queues().get(vhost, queueName);

        assertTrue(queue.isPresent());

        if (matchers != null && matchers.length > 0) assertTrue(isMatch(queue.get(), matchers));

        return this;
    }

    public RabbitAssert doesNotHaveQueue(String queueName){

        return doesNotHaveQueue("/", queueName);
    }

    public RabbitAssert doesNotHaveQueue(String vhost, String queueName) {

        Optional<Queue> queue = mgmt.queues().get(vhost, queueName);

        assertFalse(queue.isPresent());

        return this;
    }

    public RabbitAssert hasBinding(String exchange, String queue, BindingMatcher... matchers) {

        return hasBinding("/", exchange, queue, matchers);
    }

    public RabbitAssert hasBinding(String vhost, String exchange, String queue, BindingMatcher... matchers) {

        Optional<Collection<Binding>> bindings = mgmt.bindings().getEtoQ(vhost, exchange, queue);

        assertTrue(bindings.isPresent());
        assertTrue(bindings.get().size() > 0);

        if (matchers != null && matchers.length > 0) assertTrue(hasMatch(bindings.get(), matchers));

        return this;
    }

    public RabbitAssert doesNotHaveBinding(String exchange, String queue, BindingMatcher... matchers) {

        return doesNotHaveBinding("/", exchange, queue, matchers);
    }

    public RabbitAssert doesNotHaveBinding(String vhost, String exchange, String queue, BindingMatcher... matchers) {

        Optional<Collection<Binding>> bindings = mgmt.bindings().getEtoQ(vhost, exchange, queue);

        if (bindings.isPresent() && bindings.get().size() > 0)
            if (matchers != null && matchers.length > 0) assertFalse(hasMatch(bindings.get(), matchers));

        return this;
    }

    public RabbitAssert hasMessage(String queueName, MessageMatcher... matchers){

        return hasMessage("/", queueName, matchers);
    }

    public RabbitAssert hasMessage(String vhost, String queueName, MessageMatcher... matchers){

        Preconditions.checkNotNull(matchers);

        Optional<Collection<ReceivedMessage>> messages =
                mgmt.queues().consume(vhost, queueName, ConsumeOptions.builder().retrieveAtMost(100).build());

        assertTrue(messages.isPresent());
        assertTrue(messages.get().size() > 0);

        assertTrue(hasMatch(messages.get(), matchers));

        return this;
    }

    public RabbitAssert doesNotHaveMessage(String queueName, MessageMatcher... matchers){

        return doesNotHaveMessage("/", queueName, matchers);
    }

    public RabbitAssert doesNotHaveMessage(String vhost, String queueName, MessageMatcher... matchers){

        Preconditions.checkNotNull(matchers);

        Optional<Collection<ReceivedMessage>> messages =
                mgmt.queues().consume(vhost, queueName, ConsumeOptions.builder().retrieveAtMost(100).build());

        if (messages.isPresent() && messages.get().size() > 0) assertFalse(hasMatch(messages.get(), matchers));

        return this;
    }

    private static List<String> splitTags(String tagCsv){

        Iterable<String> tags = Splitter.on(",").trimResults().split(tagCsv);

        ArrayList<String> tagList = Lists.newArrayList();

        Iterables.addAll(tagList, tags);

        return tagList;
    }

    private static <T> boolean hasMatch(Collection<T> items, Matcher<T>[] matchers){

        for (T item : items) if (isMatch(item, matchers)) return true;

        return false;
    }

    private static <T> boolean isMatch(T item, Matcher<T>[] matchers){

        for(Matcher<T> matcher : matchers) if (!matcher.matches(item)) return false;

        return true;
    }


}
