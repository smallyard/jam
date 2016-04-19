package cn.smallyard.jam.test;

import cn.smallyard.jam.Plugin;
import cn.smallyard.jam.version.VersionPlugin;
import org.junit.Test;

/**
 * version plugin test
 */
public class TestVersionPlugin {
    @Test
    public void test() {
        Plugin versionPlugin = new VersionPlugin();
        versionPlugin.call(null);
    }
}
