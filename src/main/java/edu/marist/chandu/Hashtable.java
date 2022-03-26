package edu.marist.chandu;

class HashTable {
    private int collisionCount;
    private int P;
    private int M;
    private LinkedList<String>[] hashTable;

    public HashTable() {
        this.collisionCount = 0;
        this.P = 13;
        this.M = 101;
        this.hashTable = new LinkedList[this.M];

        for (int i = 0; i < this.M; i++) {
            this.hashTable[i] = new LinkedList<String>();
        }

    }

    public int getCollisionCount() {
        return this.collisionCount;
    }

    public int getP() {
        return this.P;
    }

    public int getM() {
        return this.M;
    }

    public LinkedList<String>[] getHashTable() {
        return this.hashTable;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public void setP(int P) {
        this.P = P;
    }

    public void setM(int M) {
        this.M = M;
    }

    public void setHashTable(LinkedList<String>[] hashTable) {
        this.hashTable = hashTable;
    }
   
    
    public void clear() {
        // 
        for (int i = 0; i < this.M; i++) {
            this.hashTable[i].clear();
        }
    }

    public int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * this.P + key.charAt(i)) % this.M;
        }
        return hash;
    }

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


    public String read(String key) {
        int hash = this.hash(key);
        // if the key is not found, return null
        if (this.hashTable[hash].isEmpty()) {
            return null;
        } else {
            // if the key is found, return the value
            return this.hashTable[hash].get(key);
        }

    }

    public boolean search(String value) {
        // if the value is not found, return false
        for (int i = 0; i < this.M; i++) {
            if (this.hashTable[i].contains(value)) {
                return true;
            }
        }
        return false;
    }

    public void printHashTable() {
        for (int i = 0; i < this.M; i++) {
            System.out.println(this.hashTable[i].toString());
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.M; i++) {
            str += this.hashTable[i].toString() + "\n";
        }
        return str;
    }

}



  