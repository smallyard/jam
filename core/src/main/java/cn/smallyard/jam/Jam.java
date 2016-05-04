package cn.smallyard.jam;

import cn.smallyard.jam.install.InstallPlugin;
import cn.smallyard.jam.publish.PublishPlugin;
import cn.smallyard.jam.uninstall.UninstallPlugin;
import cn.smallyard.jam.unpublish.UnpublishPlugin;
import cn.smallyard.jam.version.VersionPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * JAM
 */
public class Jam {
    public static Map<String, Plugin> pluginMap = new HashMap<String, Plugin>();
    public static final String JAM_HOME = System.getProperty("JAM_HOME");
    public static final String APP_PATH = Jam.JAM_HOME + File.separator + "apps" + File.separator;

    public Jam() {
        pluginMap.put("install", new InstallPlugin());
        pluginMap.put("uninstall", new UninstallPlugin());
        pluginMap.put("publish", new PublishPlugin());
        pluginMap.put("unpublish", new UnpublishPlugin());
        pluginMap.put("version", new VersionPlugin());
    }

    public void call(String pluginName, String value) {
        pluginMap.get(pluginName).call(value);
    }
}
