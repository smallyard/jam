package cn.smallyard.jam.version;

import cn.smallyard.jam.Plugin;
import cn.smallyard.jam.util.ConfigurationUtil;

/**
 * version plugin
 */
public class VersionPlugin implements Plugin {
    public void call(String value) {
        String version = ConfigurationUtil.getConfiguration().getValue("version");
        System.out.println("jam version " + version);
    }
}
