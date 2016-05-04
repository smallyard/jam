package cn.smallyard.jam.install;

import cn.smallyard.jam.AppInfo;
import cn.smallyard.jam.Jam;
import cn.smallyard.jam.Plugin;
import cn.smallyard.jam.util.ConfigurationUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * install plugin
 */
public class InstallPlugin implements Plugin {
    private static final String APP_LIST_FILE = Jam.JAM_HOME + File.separator + "appList.json";

    public void call(String value) {
        try {
            Map<String, AppInfo> appInfoMap = getAppInfoMap();
            if (appInfoMap.containsKey(value)) {
                AppInfo appInfo = appInfoMap.get(value);
                System.out.println(appInfo.toString());
                // jar
                String appPath = Jam.APP_PATH + value + File.separator;
                File appDirFile = new File(appPath);
                appDirFile.mkdirs();
                System.out.println("download jar from " + appInfo.getUrl());
                FileUtils.copyURLToFile(new URL(appInfo.getUrl()), new File(appPath + appInfo.getName() + ".jar"));
                System.out.println("download jar success.");

                // cmd
                String cmdDir = Jam.APP_PATH + value + ".cmd";
                String cmdContent = "@echo off \r\n java -jar " + Jam.APP_PATH + value + File.separator + value + ".jar %*";
                FileUtils.write(new File(cmdDir), cmdContent);
                System.out.println("install " + value + " success.");

            } else {
                System.out.println("Can't find " + value + " from app repository");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, AppInfo> getAppInfoMap() throws IOException {
        updateAppList();
        String appListJson = FileUtils.readFileToString(new File(APP_LIST_FILE));
        Gson gson = new Gson();
        Type type = new TypeToken<List<AppInfo>>() {
        }.getType();
        List<AppInfo> appInfoList = gson.fromJson(appListJson, type);
        Map<String, AppInfo> appInfoMap = new HashMap<String, AppInfo>();
        for (AppInfo appInfo : appInfoList) {
            appInfoMap.put(appInfo.getName(), appInfo);
        }
        return appInfoMap;
    }

    //更新app信息
    private void updateAppList() throws IOException {
        System.out.println("update app list ...");
        FileUtils.copyURLToFile(new URL(ConfigurationUtil.getConfiguration().getValue("file_list_url")), new File(APP_LIST_FILE));
        System.out.println("update app list success.");
    }
}
