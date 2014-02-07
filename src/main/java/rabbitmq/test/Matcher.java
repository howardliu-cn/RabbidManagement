package rabbitmq.test;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public interface Matcher<T> {

    boolean matches(T item);
}
