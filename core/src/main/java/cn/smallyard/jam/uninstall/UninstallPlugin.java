package cn.smallyard.jam.uninstall;

import cn.smallyard.jam.Jam;
import cn.smallyard.jam.Plugin;

import java.io.File;

/**
 * uninstall plugin
 */
public class UninstallPlugin implements Plugin {
    public void call(String value) {
        String appPath = Jam.APP_PATH + value + File.separator;
        File appDirFile = new File(appPath);
        if (appDirFile.exists()) {
            appDirFile.delete();
            String cmdDir = Jam.APP_PATH + value + ".cmd";
            File cmdFile = new File(cmdDir);
            if (cmdFile.exists()) {
                cmdFile.delete();
            }
            System.out.println("uninstall " + value + " success.");
        } else {
            System.out.println("Can't find " + value + " in your computer.");
        }
    }
}
