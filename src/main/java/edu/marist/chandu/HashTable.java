package edu.marist.chandu;

/**
 * HashTable Data structure
 * Implementation.
 */
public class HashTable {
    private final int P = 13;
    private int M;
    private LinkedList[] table;
    private int collisonCount;
    private int totalSize;
    private int fullSize;

    /**
     * Below is the constructor of hashtable with tablesize as argument.
     * @param hashtableSize
     */
    HashTable(int hashtableSize) {
        this.M = hashtableSize;
        table = new LinkedList[M];
    }

    /**
     * This is hashtable constructor.
     */
    public HashTable() {
    }

    /**
     * Below is the method to return collision count.
     * @return
     */
    public int getCollisonCount() {
        return collisonCount;
    }

    /**
     * Below is the method to get M.
     * @return
     */
    public int getM() {
        return M;
    }

    /**
     * Below is the method to clear contents.
     */
    public void clear() {
        table = new LinkedList[M];
        collisonCount = 0;
    }

    /**
     * Below is the method to remove key.
     * @param key
     * @return
     */
    public int remove(String key) {
        if (totalSize == 0) {
            return -1;
        }
        int index = hash(key);
        LinkedList ll = table[index];
        int search = ll.search(key);
        if (search == -1) {
            return -1;
        } else {
            ll.remove(search);
        }
        if (table[index].getHead() == null) {
            totalSize--;
        }
        return 1;
    }

    /**
     * Below is the method to insert data.
     * @param key
     * @param value
     * @return
     */
    public int insert(String key, String value) {
        int rvalue = 0;
        int index = hash(key);
        if (fullSize == M) {
            return -1;
        }
        if (table[index] == null) {
            fullSize++;
            LinkedList ll =  new LinkedList();
            ll.insert(0, new Node(key, value));
            table[index] = ll;
            rvalue = 0;
        } else {
            LinkedList ll = table[index];
            collisonCount++;
            int found = ll.search(key);
            if (found == -1) {
                ll.addLast(new Node(key, value));
                rvalue = 0;
            } else {
                ll.readNode(found).setData(value);
                rvalue = 1;
            }
        }
        totalSize++;
        return rvalue;
    }

    /**
     * Below is the method to read from hashtable using key.
     * @param key
     * @return
     */
    public String read(String key) {
        if (totalSize == 0) {
            return null;
        }
        int index = hash(key);
        LinkedList ll = table[index];
        Node found = null;
        int search = ll.search(key);
        if (search == -1) {
            return null;
        } else {
            found = ll.readNode(search);
        }
        return found.getData();
    }

    /**
     * Below is the method to search for value.
     * @param value
     * @return
     */
    public String search(String value) {
        if (totalSize == 0) {
            return "false";
        }
        for (LinkedList ll : table) {
            int search = ll.search(value);
            if (search != -1) {
                return "true";
            }
        }
        return "false";
    }

    /**
     * Below is the method to get hash of key.
     * @param key
     * @return
     */
    private int hash(String key) {
        int value = 0;
        int power = 1;
        for (int i = 0; i < key.length(); i++) {
            power = (int) (Math.pow(P, i + 1) % M);
            value = (value + (key.charAt(i) * power)) % M;
        }
        return value;
    }

    /**
     * Below is the method to print hashtable.
     * @return
     */
    public String printHashTable() {
        StringBuilder sb = new StringBuilder();
        if (totalSize == 0) {
            return "";
        }
        for (LinkedList ll: table) {
            if (ll != null) {
                Node current = ll.getHead();
                while (current != null) {
                    sb.append(hash(current.getData()) + ":" + current.getData() + "\n");
                    current.setNext(current.getNext());
                }
            }

        }
        return sb.toString();
    }
}
