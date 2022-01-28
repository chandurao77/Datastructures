package edu.marist.gildein;

/**
 * Main app class.
 */
public final class App {
    protected App() {
    }

    /**
     * Says hello to the world!
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int returnCode = 0;
        Utils utils = new Utils();

        utils.processArgs(args);

        System.out.println("Hello World!");

        System.exit(returnCode);
    }
}
