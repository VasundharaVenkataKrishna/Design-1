// HASHSET
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



//MIN STACK

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MinStack {
    Stack<Integer> stack;    // Regular stack to store all values
    Stack<Integer> minStack; // Stack to keep track of minimum values
    int min;                 // Current minimum value

    // Constructor initializes stacks and pushes a dummy value to avoid empty stack issues
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);  // Avoid empty stack issues during pop and peek
    }

    // Push a new value onto the stack. Update the minimum value
    // and push it onto the minStack for tracking
    public void push(int val) {
        min = Math.min(val, min);
        stack.push(val);
        minStack.push(min);
    }

    // Remove the top element from both the stack and minStack.
    // Update the min to the new top of minStack after the pop
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    // Return the top element of the stack without removing it
    public int top() {
        return stack.peek();
    }
    // Return the current minimum value
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
