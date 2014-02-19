package rabbitmq.mgmt.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class Parameter<T> {

    T value;
    String vhost;
    String component;
    String name;

    public T getValue() {

        return value;
    }

    public String getVhost() {
        return vhost;
    }

    public String getComponent() {
        return component;
    }

    public String getName() {
        return name;
    }

    public void setValue(T value) {

        this.value = value;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setName(String name) {
        this.name = name;
    }
}
