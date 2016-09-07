package rabbitmq.mgmt.model;

/**
 * <br/>created at 16-9-6
 *
 * @author liuxh
 * @since 1.2.0
 */
public enum Direction {
    source("source"),
    destination("destination");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
