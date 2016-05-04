package cn.smallyard.jam;

/**
 * application information
 */
public class AppInfo {
    private String name;
    private String version;
    private String url;
    private String describe;
    private String user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String toString() {
        return "name: " + this.getName() + "\r\n" + "version: " + this.getVersion() + "\r\n"
                + "url: " + url + "\r\n" + "describe: " + this.describe + "\r\n" + "user: " + this.user;
    }
}
