package edu.marist.chandu;

/**
 * App utility class for constants.
 *
 * @author marru chandu-chandu.marru1@marist.edu
 */
public final class CONSTANTS {
    private static String appName = "ninja1";
    private static String version = "4.0.0";

    private CONSTANTS() {
    }

    /**
     * App version getter.
     *
     * @return Version string of app
     */
    public static String getVersion() {
        return version;
    }

    /**
     * App name getter.
     *
     * @return App name string
     */
    public static String getAppName() {
        return appName;
    }
}
