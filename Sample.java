// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    // Constructor initializes with 1000 primary buckets and 1001 secondary buckets
    public MyHashSet() {
        this.primaryBuckets = 1000;
        // Secondary bucket size is 1001 to handle larger keys, avoid collisions more effectively and avoid index out of bounds exception. For example 1000000 would be to added to 1000th index which does not exist.
        // The slight offset from 1000 helps in distributing keys more evenly.
        this.secondaryBuckets = 1001;
        this.storage = new boolean[primaryBuckets][];
    }

    // Primary hash to map key to primary bucket
    private int getPrimaryHash(int key) {
        return key % primaryBuckets;
    }

    // Secondary hash to map key within the primary bucket
    private int getSecondaryHash(int key) {
        return key / secondaryBuckets;
    }

    // Adds key to the set
    public void add(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) {
            storage[primaryIndex] = new boolean[secondaryBuckets];
        }
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = true;
    }

    // Removes key from the set
    public void remove(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) return;
        int secondaryIndex = getSecondaryHash(key);
        storage[primaryIndex][secondaryIndex] = false;
    }

    // Checks if the set contains the key
    public boolean contains(int key) {
        int primaryIndex = getPrimaryHash(key);
        if (storage[primaryIndex] == null) return false;
        int secondaryIndex = getSecondaryHash(key);
        return storage[primaryIndex][secondaryIndex];
    }
}
