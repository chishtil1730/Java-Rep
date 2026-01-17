import java.util.Arrays;

public class QuadraP {

    public static void main(String[] args) {
        // Table configuration
        int tableSize = 10;
        int numKeys = 5;

        // Dataset to be inserted
        int[] keys = {90 ,88 ,45 ,78 ,102};

        // Create the hash table and initialize with -1 (empty)
        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable,-1);

        // Insertion Logic
        for(int i = 0; i < numKeys; i++){
            int key = keys[i];
            // Step 1: Basic Hash Function
            int index = key % tableSize;

            int j = 0;
            // Step 2: Collision handling using Quadratic formula: (h(k) + j^2) % size
            while(hashTable[index] != -1){
                j++;
                // Move by the square of the attempt number (1, 4, 9...)
                index = (index + j * j) % tableSize;
            }
            // Step 3: Insert key into the calculated empty slot
            hashTable[index] = key;
        }

        // Output Logic: Filter by Prime Indices
        for(int i = 0; i < tableSize; i++){
            // Only print if the slot is occupied AND the index itself is a prime number
            if(hashTable[i] != -1 && isPrime(i)){
                System.out.println("Element at prime index " + i + " is: " + hashTable[i]);
            }
        }
    }

    /**
     * Determines if the index 'n' is a prime number.
     * Quadratic Probing works best when the table size itself is a prime number.
     */
    static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true; // 2 is the only even prime

        // Check for factors up to n-1
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}