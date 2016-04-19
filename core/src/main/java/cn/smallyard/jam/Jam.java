package cn.smallyard.jam;

import cn.smallyard.jam.version.VersionPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * JAM
 */
public class Jam {
    public static Map<String, Plugin> pluginMap = new HashMap<String, Plugin>();

    public Jam() {
        Plugin versionPlugin = new VersionPlugin();
        pluginMap.put("version", versionPlugin);
    }

    public void call(String pluginName, String[] args) {
        pluginMap.get(pluginName).call(args);
    }
}
