package rabbitmq.loader;

import com.google.gson.Gson;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class JsonManifestSerializer implements ManifestSerializer {

    static Gson gson = new Gson();

    @Override
    public Manifest deserializer(String serializedManifest) {

        return gson.fromJson(serializedManifest, Manifest.class);
    }

    @Override
    public String serialize(Manifest manifest) {

        return gson.toJson(manifest);
    }
}
