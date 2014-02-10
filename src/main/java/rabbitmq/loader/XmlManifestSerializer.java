package rabbitmq.loader;

import com.thoughtworks.xstream.XStream;
import rabbitmq.mgmt.model.*;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class XmlManifestSerializer implements ManifestSerializer {

    static XStream xstream = new XStream();

    static {

        xstream.alias("exchange", Exchange.class);
        xstream.alias("queue", Queue.class);
        xstream.alias("binding", Binding.class);
        xstream.alias("user", User.class);
        xstream.alias("connection", ConnectionInfo.class);
        xstream.alias("vhost", VirtualHost.class);
        xstream.alias("permission", Permission.class);
    }

    @Override
    public Manifest deserializer(String serializedManifest) {

        return (Manifest) xstream.fromXML(serializedManifest);
    }

    @Override
    public String serialize(Manifest manifest) {

        return xstream.toXML(manifest);
    }
}
