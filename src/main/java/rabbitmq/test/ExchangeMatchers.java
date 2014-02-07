package rabbitmq.test;

import rabbitmq.mgmt.model.Exchange;
import rabbitmq.mgmt.model.Queue;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class ExchangeMatchers {

    public static ExchangeTypeMatcher isTopicType(){

        return new ExchangeTypeMatcher("topic");
    }

    public static ExchangeTypeMatcher isDirectType(){

        return new ExchangeTypeMatcher("direct");
    }

    public static ExchangeTypeMatcher isFanoutType(){

        return new ExchangeTypeMatcher("fanout");
    }

    public static ExchangeTypeMatcher isHeadersType(){

        return new ExchangeTypeMatcher("headers");
    }

    public static ExchangeTypeMatcher isType(String exchangeType){

        return new ExchangeTypeMatcher(exchangeType);
    }

    public static DurableMatcher isExDurable(){

        return new DurableMatcher(true);
    }

    public static DurableMatcher isNotExDurable(){

        return new DurableMatcher(false);
    }

    public static AutoDeleteMatcher isExAutoDelete(){

        return new AutoDeleteMatcher(true);
    }

    public static AutoDeleteMatcher isNotExAutoDelete(){

        return new AutoDeleteMatcher(false);
    }

    public static class ExchangeTypeMatcher implements ExchangeMatcher {

        private String exchangeType;

        public ExchangeTypeMatcher(String exchangeType) {
            this.exchangeType = exchangeType;
        }

        @Override
        public boolean matches(Exchange exchange) {
            return exchangeType.equals(exchange.getType());
        }
    }

    public static class DurableMatcher implements ExchangeMatcher {

        boolean shouldBeDurable;

        public DurableMatcher(boolean shouldBeDurable) {
            this.shouldBeDurable = shouldBeDurable;
        }

        @Override
        public boolean matches(Exchange exchange) {

            return exchange.isDurable() == shouldBeDurable;
        }
    }

    public static class AutoDeleteMatcher implements ExchangeMatcher {

        boolean shouldBeAutoDelete;

        public AutoDeleteMatcher(boolean shouldBeAutoDelete) {
            this.shouldBeAutoDelete = shouldBeAutoDelete;
        }

        @Override
        public boolean matches(Exchange exchange) {

            return exchange.isAutoDelete() == shouldBeAutoDelete;
        }
    }
}
