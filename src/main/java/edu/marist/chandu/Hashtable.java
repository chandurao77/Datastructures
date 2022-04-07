package edu.marist.chandu;

/**
 *
 */

class HashTable {
    private int collisionCount;
    private int e;
    private int d;
    private LinkedList[] hashTable;
    /**
     *
     *  */

    public HashTable(int x, int v) {
        this.collisionCount = 0;
        this.e = x;
        x = 13;
        this.d = v;
        v = 101;
        this.hashTable = new LinkedList[this.d];

        for (int i = 0; i < this.d; i++) {
            this.hashTable[i] = new LinkedList();
        }

    }

    public int getCollisionCount() {
        return this.collisionCount;
    }

    public int getP() {
        return this.e;
    }

    public int getM() {
        return this.d;
    }

    public LinkedList[] getHashTable() {
        return this.hashTable;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public void setP(int b) {
        this.e = b;
    }

    public void setM(int c) {
        this.d = c;
    }

    public void setHashTable(LinkedList[] hashTable) {
        this.hashTable = hashTable;
    }
    /**
     *
     */

    public void clear() {
        //
        for (int i = 0; i < this.M; i++) {
            this.hashTable[i].clear();
        }
    }
    /**
     *
     * @param key
     * @return
     */

    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * this.e + key.charAt(i)) % this.d;
        }
        return hash;
    }
    /**
     *
     * @param key
     * @param value
     * @return
     */

    public int insert(String key, String value) {
        // if the hash table is full, return -1
        int hash = this.hash(key);
        // if the key already exists, return 1
        if (this.hashTable[hash].isEmpty()) {
            this.hashTable[hash].add(key);
            this.hashTable[hash].add(value);
            return 0;
        // if the key does not exist, return 0
        } else {
            this.collisionCount++;
            // System.out.println("Collision: " + key);
            return 1;
        }

    }
    /**
     *
     * @param key
     * @return
     */

    public int remove(String key) {
        // if the key is not found, return -1
        int hash = this.hash(key);
        if (this.hashTable[hash].isEmpty()) {
            return -1;
        } else {
            // if the key is found, remove it and return 0
            this.hashTable[hash].remove(key);
            return 0;
        }
    }
    /**
     *
     * @param key
     * @return
     */

    public String read(String key) {
        int hash = this.hash(key);
        // if the key is not found, return null
        if (this.hashTable[hash].isEmpty()) {
            return null;
        } else {
            // if the key is found, return the value
            return this.hashTable[hash].get(key);
        }
        /**
        *
        *
        * */

    }
    /**
     *
     *
     * */

    public boolean search(String value) {
        // if the value is not found, return false
        for (int i = 0; i < this.M; i++) {
            if (this.hashTable[i].contains(value)) {
                return true;
            }
        }
        return false;
    }
    /**
     *  */

    public void printHashTable() {
        for (int i = 0; i < this.M; i++) {
            System.out.println(this.hashTable[i].toString());
        }
    }
    /**
     *
     */

    public String toString() {
        String str = "";
        for (int i = 0; i < this.M; i++) {
            str += this.hashTable[i].toString() + "\n";
        }
        return str;
    }

}
