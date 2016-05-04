package cn.smallyard.jam;

import org.apache.commons.cli.*;

/**
 * JAM CLI
 */
public class JamCli {
    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("v", "version", false, "show jam's version.");
        options.addOption("i", "install", true, "install app.");
        options.addOption("ui", "uninstall", true, "uninstall app.");
//        options.addOption("p", "publish", false, "publish app to repository.");
//        options.addOption("up", "unpublish", false, "remove app from repository.");

        try {
            CommandLine line = parser.parse(options, args);
            if (line.getOptions().length == 0) {
                showHelp(options);
            } else {
                Jam jam = new Jam();
                for (Option option : line.getOptions()) {
                    jam.call(option.getLongOpt(), option.getValue());
                }
            }
        } catch (ParseException exp) {
            showHelp(options);
        }
    }

    private static void showHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("jam", options);
    }
}
