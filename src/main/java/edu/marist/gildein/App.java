package edu.marist.Nandakishore;

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

        System.out.println("ninja1!");

        System.exit(returnCode);
    }
}
