package rabbitmq.test;

import rabbitmq.mgmt.model.Binding;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class BindingMatchers {

    public static SourceMatcher source(String exchangeName){

        return new SourceMatcher(exchangeName);
    }

    public static DestinationMatcher destination(String exchangeOrQueueName){

        return new DestinationMatcher(exchangeOrQueueName);
    }

    public static DestinationTypeMatcher isExToQ(){

        return new DestinationTypeMatcher("queue");
    }

    public static DestinationTypeMatcher isExToEx(){

        return new DestinationTypeMatcher("exchange");
    }

    public static RouteMatcher routingKey(String routingKey){

        return new RouteMatcher(routingKey);
    }


    public static class SourceMatcher implements BindingMatcher {

        private String source;

        public SourceMatcher(String source) {
            this.source = source;
        }

        @Override
        public boolean matches(Binding binding) {
            return source.equals(binding.getSource());
        }
    }

    public static class DestinationMatcher implements BindingMatcher {

        private String destination;

        public DestinationMatcher(String destination) {
            this.destination = destination;
        }

        @Override
        public boolean matches(Binding binding) {
            return destination.equals(binding.getDestination());
        }
    }

    public static class DestinationTypeMatcher implements BindingMatcher {

        private String destinationType;

        public DestinationTypeMatcher(String destinationType) {
            this.destinationType = destinationType;
        }

        @Override
        public boolean matches(Binding binding) {
            return destinationType.equals(binding.getDestinationType());
        }
    }

    public static class RouteMatcher implements BindingMatcher {

        String routingKey;

        public RouteMatcher(String routingKey) {
            this.routingKey = routingKey;
        }

        @Override
        public boolean matches(Binding binding) {

            return routingKey.equals(binding.getRoutingKey());
        }
    }
}
