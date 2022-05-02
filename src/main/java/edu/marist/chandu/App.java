package edu.marist.chandu;

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
            String fileContent = utils.readFile(cmdArgs[0]);
            System.out.println(everyOtherLine(fileContent));
            sameCharacterLines(fileContent);
            HashTable hashTable = new HashTable();
            hashTable.printHashTable();
            String[] array = fileContent.split("\n");
            SortingAlgorithms algorithms = new SortingAlgorithms();
            algorithms.bubbleSort(array);
            algorithms.insertionSort(array);
            algorithms.mergeSort(array);
            algorithms.heapSort(array);
            algorithms.quickSort(array);
        } else {
            utils.error("Error: Incorrect number arguments. One FILE argument required.");
        }

        System.exit(returnCode);
    }

    /**
     * Below method is to output the lines having same character endings.
     * @param str
     */
    public static void sameCharacterLines(String str) {
        String[] inStringLineArray = str.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inStringLineArray.length; i = i + 1) {
            if (check(inStringLineArray[i].trim())) {
                System.out.println(inStringLineArray[i]);
            }
        }
    }

    /**
     * Below method is to check the string endings using enqueue and dequeue.
     * @param line
     * @return
     */
    public static  boolean check(String line) {
        Stack stack = new Stack();
        Queue queue = new Queue();
        for (int i = 0; i < line.length(); i++) {
            stack.push(String.valueOf(line.charAt(i)));
            queue.enqueue(String.valueOf(line.charAt(i)));
        }
        return stack.pop().equalsIgnoreCase(queue.deqeueue());
    }
}
