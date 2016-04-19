package cn.smallyard.jam;

/**
 * JAM CLI
 */
public class JamCli {
    public static void main(String[] args) {
        System.out.println("Welcome to use JAM.");
        for (String arg : args) {
            System.out.println(arg);
        }

        Jam jam = new Jam();
        jam.call("version", args);
    }
}
