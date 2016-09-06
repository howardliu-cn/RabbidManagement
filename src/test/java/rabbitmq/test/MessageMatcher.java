package rabbitmq.test;

import rabbitmq.mgmt.model.ReceivedMessage;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public interface MessageMatcher extends Matcher<ReceivedMessage> {}