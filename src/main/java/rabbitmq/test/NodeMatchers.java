package rabbitmq.test;

import rabbitmq.mgmt.model.Node;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class NodeMatchers {

    public static NodeTypeMatcher isDiscNode(){

        return new NodeTypeMatcher("disc");
    }

    public static NodeTypeMatcher isRamNode(){

        return new NodeTypeMatcher("ram");
    }

    public static RunningMatcher isRunning(){

        return new RunningMatcher(true);
    }

    public static RunningMatcher isNotRunning(){

        return new RunningMatcher(false);
    }

    public static class NodeTypeMatcher implements NodeMatcher {

        String nodeType;

        public NodeTypeMatcher(String nodeType) {
            this.nodeType = nodeType;
        }

        @Override
        public boolean matches(Node item) {
            return nodeType.equals(item.getType());
        }
    }

    public static class RunningMatcher implements NodeMatcher {

        boolean shouldBeRunning;

        public RunningMatcher(boolean shouldBeRunning) {
            this.shouldBeRunning = shouldBeRunning;
        }

        @Override
        public boolean matches(Node item) {
            return item.isRunning() == shouldBeRunning;
        }
    }
}
