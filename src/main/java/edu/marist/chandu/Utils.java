package edu.marist.chandu;

import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * General utilty and helper methods.
 *
 * @author marru chandu-chandu.marru1@marist.edu
 */
public class Utils {
    /**
     * Print help text.
     *
     * @param options CLI options to print
     */
    public void printHelpText(Options options) {
        System.out.println(CONSTANTS.getAppName());
        System.out.println("Version: " + CONSTANTS.getVersion());

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(CONSTANTS.getAppName(), options);
    }

    /**
     * Initialize CLI options.
     *
     * @return Options of CLI for use in parser
     */
    public Options initOptions() {
        Options options = new Options();
        options.addOption("v", false, "Verbose mode");
        options.addOption("h", false, "Display this help text");
        return options;
    }

    /**
     * Process command line arguments using Apache Commons CLI.
     *
     * @param args Arguments from command line
     * @return Parsed command line output
     */
    public CommandLine processArgs(String[] args) {
        Options options = initOptions();

        CommandLineParser parser = new PosixParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException pe) {
            printHelpText(options);
            error("Error parsing command line: " + pe.getMessage());
        }

        if (cmd.hasOption("h")) {
            printHelpText(options);
            System.exit(0);
        } else if (cmd.hasOption("v")) {
            System.out.println("Verbose mode");
            System.out.println(CONSTANTS.getAppName() + " version: " + CONSTANTS.getVersion());
        }

        return cmd;
    }

    /**
     * Error helper method to print error message to stderr and exit with return code.
     *
     * @param msg        Error message to be printed
     * @param returnCode Return code to exit with
     */
    public void error(String msg, int returnCode) {
        System.err.println(msg);
        System.exit(returnCode);
    }

    /**
     * Error helper method to print error message to stderr and exit with return code -1.
     *
     * @param msg Error message to be printed
     */
    public void error(String msg) {
        System.err.println(msg);
        System.exit(-1);
    }

    /**
     * Open file and read in file content string.
     *
     * @param filename Name of file to be read
     * @return String of file content if found
     */
    public String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                sb.append(fileScanner.nextLine());
                sb.append("\n");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            error("Error: File " + filename + " not found.");
        }
        return sb.toString();
    }

    /**
     * This is linkedlist method.
     *
     * @param file
     */
    public void linkedlist(String file) {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        System.out.println("------------------------------------------");
        //Linkedlist creation.
        StringTokenizer stringTokenizer2 = new StringTokenizer(file, " \t\n\r\f");
        LinkedList<String> linkedList = new LinkedList();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to create - " + timeTaken + " ns");

        //Linkedlist insert string.
        startTime = System.nanoTime();
        while (stringTokenizer2.hasMoreTokens()) {
            linkedList.add(stringTokenizer2.nextToken());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to insert - " + timeTaken + " ns");

        //Linkedlist get first element.
        startTime = System.nanoTime();
        if (linkedList.size() > 0)
            linkedList.contains(linkedList.get(0));
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to get first element - " + timeTaken + " ns");

        //Linkedlist get last element.
        startTime = System.nanoTime();
        int linkedlistSize = linkedList.size();
        if (linkedlistSize > 0)
            linkedList.contains(linkedList.get(linkedList.size() - 1));
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to search last element - " + timeTaken + " ns");

        //Linkedlist search not found.
        startTime = System.nanoTime();
        linkedList.contains("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to search not found - " + timeTaken + " ns");

        //Linkedlist read element.
        startTime = System.nanoTime();
        if (linkedList.size() > 0) {
            String readValue = linkedList.get(0);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to read - " + timeTaken + " ns");

        //Linkedlist remove 10 elements.
        startTime = System.nanoTime();
        if (linkedList.size() > 10) {
            linkedList.remove(3);
            linkedList.remove(14);
            linkedList.remove(21);
            linkedList.remove(7);
            linkedList.remove(2);
            linkedList.remove(5);
            linkedList.remove(9);
            linkedList.remove(23);
            linkedList.remove(12);
            linkedList.remove(11);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by linkedlist to remove - " + timeTaken + " ns");
    }

    /**
     * This is arraylist.
     *
     * @param file
     */
    public void arraylistmethod(String file) {
        StringTokenizer stringTokenizer = new StringTokenizer(file, " \t\n\r\f");
        System.out.println("--------------------------------------");
        //ArrayList Creation time taken.
        long startTime = System.nanoTime();
        ArrayList<String> arrayList = new ArrayList();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to create - " + timeTaken + " ns");

        //Arraylist insertion time taken.
        startTime = System.nanoTime();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to insert into arraylist - " + timeTaken + " ns");

        //Arraylist search first elemnt time taken.
        startTime = System.nanoTime();
        if (arrayList.size() > 0) {
            arrayList.contains(arrayList.get(0));
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to get first element - " + timeTaken + " ns");

        //Arraylist search last element time taken.
        startTime = System.nanoTime();
        int arraySize = arrayList.size();
        if (arraySize > 0)
            arrayList.contains(arrayList.get(arrayList.size() - 1));
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to search last element - " + timeTaken + " ns");

        //Arraylist not exist token time taken.
        startTime = System.nanoTime();
        arrayList.contains("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to search not found - " + timeTaken + " ns");

        //Arraylist read next value.
        startTime = System.nanoTime();
        if (arrayList.size() > 0) {
            String readValue = arrayList.get(0);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to read - " + timeTaken + " ns");

        //Arraylist remove 10 items.
        startTime = System.nanoTime();
        if (arrayList.size() > 10) {
            arrayList.remove(5);
            arrayList.remove(9);
            arrayList.remove(23);
            arrayList.remove(12);
            arrayList.remove(3);
            arrayList.remove(14);
            arrayList.remove(21);
            arrayList.remove(11);
            arrayList.remove(7);
            arrayList.remove(2);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by arraylist to remove 10 items - " + timeTaken + " ns");
    }

    /**
     * This is hashmap method
     *
     * @param file
     */
    public void hashMap(String file) {
        StringTokenizer stringTokenizer = new StringTokenizer(file, " \t\n\r\f");
        System.out.println("------------------------------------------");
        //Hashmap Creation time taken.
        long startTime = System.nanoTime();
        HashMap<Integer, String> hashMap = new HashMap<>();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to create - " + timeTaken + " ns");

        //Hashmap insertion time taken.
        startTime = System.nanoTime();
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            hashMap.put(i, stringTokenizer.nextToken());
            i++;
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to insert into arraylist - " + timeTaken + " ns");

        //Hashmap search first elemnt time taken.
        startTime = System.nanoTime();
        if (hashMap.size() > 0) {
            hashMap.containsValue(hashMap.get(0));
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to get first element - " + timeTaken + " ns");

        //Hashmap search last element time taken.
        startTime = System.nanoTime();
        int arraySize = hashMap.size();
        if (arraySize > 0) {
            hashMap.containsValue(hashMap.get(hashMap.size() - 1));
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to search last element - " + timeTaken + " ns");

        //Hashmap not exist token time taken.
        startTime = System.nanoTime();
        hashMap.containsValue("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to search not found - " + timeTaken + " ns");

        //Hashmap read next value.
        startTime = System.nanoTime();
        if (hashMap.size() > 0) {
            String readValue = hashMap.get(0);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to read - " + timeTaken + " ns");

        //Hashmap remove 10 items.
        startTime = System.nanoTime();
        if (hashMap.size() > 10) {
            hashMap.remove(5);
            hashMap.remove(9);
            hashMap.remove(23);
            hashMap.remove(12);
            hashMap.remove(3);
            hashMap.remove(14);
            hashMap.remove(21);
            hashMap.remove(11);
            hashMap.remove(7);
            hashMap.remove(2);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by hashmap to remove 10 items - " + timeTaken + " ns");
    }

    /**
     * This is treemap method.
     *
     * @param file
     */
    public void treemap(String file) {
        StringTokenizer stringTokenizer = new StringTokenizer(file, " \t\n\r\f");

        //Treemap Creation time taken.
        long startTime = System.nanoTime();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to create - " + timeTaken + " ns");

        //Treemap insertion time taken.
        startTime = System.nanoTime();
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            treeMap.put(i, stringTokenizer.nextToken());
            i++;
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to insert into arraylist - " + timeTaken + " ns");

        //Treemap search first elemnt time taken.
        startTime = System.nanoTime();
        if (treeMap.size() > 0) {
            treeMap.containsValue(treeMap.get(0));
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to get first element - " + timeTaken + " ns");

        //Treemap search last element time taken.
        startTime = System.nanoTime();
        int arraySize = treeMap.size();
        if (arraySize > 0) {
            treeMap.containsValue(treeMap.get(treeMap.size() - 1));
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to search last element - " + timeTaken + " ns");

        //Treemap not exist token time taken.
        startTime = System.nanoTime();
        treeMap.containsValue("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to search not found - " + timeTaken + " ns");

        //Treemap read next value.
        startTime = System.nanoTime();
        if (treeMap.size() > 0) {
            String readValue = treeMap.get(0);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to read - " + timeTaken + " ns");

        //Treemap remove 10 items.
        startTime = System.nanoTime();
        if (treeMap.size() > 10) {
            treeMap.remove(5);
            treeMap.remove(9);
            treeMap.remove(23);
            treeMap.remove(12);
            treeMap.remove(3);
            treeMap.remove(14);
            treeMap.remove(21);
            treeMap.remove(11);
            treeMap.remove(7);
            treeMap.remove(2);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by treemap to remove 10 items - " + timeTaken + " ns");
    }

    /**
     * This is stack method.
     *
     * @param file
     */
    public void stackmethod(String file) {
        StringTokenizer stringTokenizer = new StringTokenizer(file, " \t\n\r\f");

        //Stack Creation time taken.
        long startTime = System.nanoTime();
        Stack<String> stack = new Stack();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by stack to create - " + timeTaken + " ns");

        //Stack insertion time taken.
        startTime = System.nanoTime();
        while (stringTokenizer.hasMoreTokens()) {
            stack.add(stringTokenizer.nextToken());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to insert into Stack - " + timeTaken + " ns");

        //Stack search first elemnt time taken.
        startTime = System.nanoTime();
        if (stack.size() > 0)
            stack.contains(stack.get(0));
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to get first element - " + timeTaken + " ns");

        //Stack search last element time taken.
        startTime = System.nanoTime();
        int arraySize = stack.size();
        if (arraySize > 0)
            stack.contains(stack.get(stack.size() - 1));
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to search last element - " + timeTaken + " ns");

        //Stack not exist token time taken.
        startTime = System.nanoTime();
        stack.contains("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to search not found - " + timeTaken + " ns");

        //Stack read next value.
        startTime = System.nanoTime();
        if (stack.size() > 0) {
            String readValue = stack.get(0);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to read - " + timeTaken + " ns");

        //Stack remove 10 items.
        startTime = System.nanoTime();
        if (stack.size() > 10) {
            stack.remove(12);
            stack.remove(3);
            stack.remove(14);
            stack.remove(5);
            stack.remove(9);
            stack.remove(23);
            stack.remove(21);
            stack.remove(11);
            stack.remove(7);
            stack.remove(2);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by stack to remove 10 items - " + timeTaken + " ns");

    }

    /**
     * This is sorted set.
     *
     * @param file
     */
    public void sortedset(String file) {
        StringTokenizer stringTokenizer3 = new StringTokenizer(file, " \t\n\r\f");
        long startTime = System.nanoTime();
        SortedSet sortedSet = new TreeSet();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to create - " + timeTaken + " ns");

        startTime = System.nanoTime();
        while (stringTokenizer3.hasMoreTokens()) {
            sortedSet.add(stringTokenizer3.nextToken());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to insert - " + timeTaken + " ns");

        startTime = System.nanoTime();
        if (sortedSet.size() > 0)
            sortedSet.contains(sortedSet.first());
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to get first element - " + timeTaken + " ns");

        startTime = System.nanoTime();
        int sortedSetSize = sortedSet.size();
        if (sortedSetSize > 0)
            sortedSet.contains(sortedSet.last());
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to search last element - " + timeTaken + " ns");

        startTime = System.nanoTime();
        sortedSet.contains("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to search not found - " + timeTaken + " ns");

        startTime = System.nanoTime();
        if (sortedSet.size() > 0) {
            String readValue = (String) sortedSet.first();
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to read - " + timeTaken + " ns");

        startTime = System.nanoTime();
        if (sortedSet.size() > 10) {
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
            sortedSet.remove(sortedSet.first());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by sortedset to remove - " + timeTaken + " ns");
    }

    /**
     * This is priority queue method.
     *
     * @param file
     */
    public void priorityQueue(String file) {
        StringTokenizer stringTokenizer = new StringTokenizer(file, " \t\n\r\f");
        System.out.println("-------------------------------------------------------");
        //PriorityQueue Creation time taken.
        long startTime = System.nanoTime();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to create - " + timeTaken + " ns");

        //PriorityQueue insertion time taken.
        startTime = System.nanoTime();
        while (stringTokenizer.hasMoreTokens()) {
            priorityQueue.add(stringTokenizer.nextToken());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to insert into arraylist - " + timeTaken + " ns");

        //PriorityQueue search first elemnt time taken.
        startTime = System.nanoTime();
        if (priorityQueue.size() > 0) {
            priorityQueue.contains(priorityQueue.peek());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to get first element - " + timeTaken + " ns");

        //PriorityQueue search last element time taken.
        startTime = System.nanoTime();
        int arraySize = priorityQueue.size();
        if (arraySize > 0) {
            priorityQueue.contains(priorityQueue.poll());
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to search last element - " + timeTaken + " ns");

        //PriorityQueue not exist token time taken.
        startTime = System.nanoTime();
        priorityQueue.contains("mikewashere");
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to search not found - " + timeTaken + " ns");

        //PriorityQueue read next value.
        startTime = System.nanoTime();
        if (priorityQueue.size() > 0) {
            String readValue = priorityQueue.peek();
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to read - " + timeTaken + " ns");

        //PriorityQueue remove 10 items.
        startTime = System.nanoTime();
        if (priorityQueue.size() > 10) {
            priorityQueue.remove(23);
            priorityQueue.remove(12);
            priorityQueue.remove(3);
            priorityQueue.remove(14);
            priorityQueue.remove(5);
            priorityQueue.remove(9);
            priorityQueue.remove(21);
            priorityQueue.remove(11);
            priorityQueue.remove(7);
            priorityQueue.remove(2);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("time taken by priority queue to remove 10 items - " + timeTaken + " ns");
    }
}
