package cn.smallyard.jam;

import cn.smallyard.jam.adduser.AddUserPlugin;
import cn.smallyard.jam.install.InstallPlugin;
import cn.smallyard.jam.publish.PublishPlugin;
import cn.smallyard.jam.uninstall.UninstallPlugin;
import cn.smallyard.jam.unpublish.UnpublishPlugin;
import cn.smallyard.jam.update.UpdatePlugin;
import cn.smallyard.jam.version.VersionPlugin;

import java.util.HashMap;
import java.util.Map;

/**
 * JAM
 */
public class Jam {
    public static Map<String, Plugin> pluginMap = new HashMap<String, Plugin>();

    public Jam() {
        pluginMap.put("adduser", new AddUserPlugin());
        pluginMap.put("install", new InstallPlugin());
        pluginMap.put("uninstall", new UninstallPlugin());
        pluginMap.put("update", new UpdatePlugin());
        pluginMap.put("publish", new PublishPlugin());
        pluginMap.put("unpublish", new UnpublishPlugin());
        pluginMap.put("version", new VersionPlugin());
    }

    public void call(String pluginName, String value) {
        pluginMap.get(pluginName).call(value);
    }
}
