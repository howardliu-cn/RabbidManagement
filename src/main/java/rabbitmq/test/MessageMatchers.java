package rabbitmq.test;

import rabbitmq.mgmt.model.ReceivedMessage;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class MessageMatchers {

    public static StringBodyMatcher body(String body){

        return new StringBodyMatcher(body);
    }

    public static ByteBodyMatcher body(byte[] body){

        return new ByteBodyMatcher(body);
    }

    public static HeaderMatcher header(String key, Object value){

        return new HeaderMatcher(key, value);
    }

    public static PropertyMatcher property(String key, Object value){

        return new PropertyMatcher(key, value);
    }

    public static RouteMatcher route(String routingKey){

        return new RouteMatcher(routingKey);
    }

    public static class StringBodyMatcher implements MessageMatcher {

        String expectedBody;

        public StringBodyMatcher(String expectedBody) {
            this.expectedBody = expectedBody;
        }

        @Override
        public boolean matches(ReceivedMessage message) {
            return expectedBody.equals(message.getPayload());
        }
    }

    public static class ByteBodyMatcher implements MessageMatcher {

        byte[] expectedBody;

        public ByteBodyMatcher(byte[] expectedBody) {
            this.expectedBody = expectedBody;
        }

        @Override
        public boolean matches(ReceivedMessage message) {
            return expectedBody.equals(message.getPayloadBytes());
        }
    }

    public static class HeaderMatcher implements MessageMatcher {

        String key;

        Object value;

        public HeaderMatcher(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean matches(ReceivedMessage message) {

            if (message.getHeaders().containsKey(key))
                return message.getHeaders().get(key).equals(value);

            return false;
        }
    }

    public static class PropertyMatcher implements MessageMatcher {

        String key;

        Object value;

        public PropertyMatcher(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean matches(ReceivedMessage message) {

            if (message.getProperties().containsKey(key))
                return message.getProperties().get(key).equals(value);

            return false;
        }
    }

    public static class RouteMatcher implements MessageMatcher {

        String routingKey;

        public RouteMatcher(String routingKey) {
            this.routingKey = routingKey;
        }

        @Override
        public boolean matches(ReceivedMessage message) {

            return routingKey.equals(message.getRoutingKey());
        }
    }
}
