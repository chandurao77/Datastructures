package edu.marist.Nandakishore;
import org.apache.commons.cli.CommandLine;
/**
 * Main app class.
 * @author marru chandu-chandu.marru1@marist.edu
 */
public final class App {
    protected App() {
    }

    /**
     * Filter  input string to evry other line.
     * Essentially, return only even numbered lines including Zero.
     * @param inString String to filter
     * @return Filtered String
     */
    public static String everyOtherLine(String inString) {
        String[] inStringLineArray = inString.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inStringLineArray.length; i = i + 2) {
            sb.append(inStringLineArray[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Says hello to the world!
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int returnCode = 0;
        Utils utils = new Utils();
        CommandLine cmdLine = utils.processArgs(args);
        String[] cmdArgs = cmdLine.getArgs();
        if (cmdArgs.length == 1) {
            if (cmdLine.hasOption("v")) {
                System.out.println("File to be used: " + cmdArgs[0]);
            }
            System.out.println(everyOtherLine(utils.readFile(cmdArgs[0])));
        } else {
            utils.error("Error: Incorrect number arguments. One FILE argument required.");
        }

        System.exit(returnCode);
    }
}