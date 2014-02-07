package rabbitmq.test;

import rabbitmq.mgmt.model.Queue;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class QueueMatchers {

    public static CountMatcher count(int numMessages){

        return new CountMatcher(numMessages);
    }

    public static DurableMatcher isQDurable(){

        return new DurableMatcher(true);
    }

    public static DurableMatcher isNotQDurable(){

        return new DurableMatcher(false);
    }

    public static AutoDeleteMatcher isQAutoDelete(){

        return new AutoDeleteMatcher(true);
    }

    public static AutoDeleteMatcher isNotQAutoDelete(){

        return new AutoDeleteMatcher(false);
    }

    public static class CountMatcher implements QueueMatcher {

        private int count;

        public CountMatcher(int count) {
            this.count = count;
        }

        @Override
        public boolean matches(Queue queue) {
            return count == queue.getMessages();
        }
    }

    public static class DurableMatcher implements QueueMatcher {

        boolean shouldBeDurable;

        public DurableMatcher(boolean shouldBeDurable) {
            this.shouldBeDurable = shouldBeDurable;
        }

        @Override
        public boolean matches(Queue queue) {

            return queue.isDurable() == shouldBeDurable;
        }
    }

    public static class AutoDeleteMatcher implements QueueMatcher {

        boolean shouldBeAutoDelete;

        public AutoDeleteMatcher(boolean shouldBeAutoDelete) {
            this.shouldBeAutoDelete = shouldBeAutoDelete;
        }

        @Override
        public boolean matches(Queue queue) {

            return queue.isAutoDelete() == shouldBeAutoDelete;
        }
    }
}
