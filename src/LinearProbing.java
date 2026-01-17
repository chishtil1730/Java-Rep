import java.util.Arrays;

public class LinearProbing {

    public static void main(String[] args) {
        // Configuration: Table size and keys to insert
        int tableSize = 7;
        int[] keys = {50, 700, 76, 85};
        int numKeys = 4;

        // Initialize the Hash Table array
        int[] hashTable = new int[tableSize];

        // Fill table with -1 to indicate all slots are currently empty
        Arrays.fill(hashTable, -1);

        // Insertion Process
        for(int i = 0; i < numKeys; i++){
            int key = keys[i];

            // Step 1: Calculate the initial hash index using modulo
            int hashIndex = key % tableSize;

            // Step 2: Linear Probing (Collision Handling)
            // While the current slot is occupied (not -1), move to the next index
            while(hashTable[hashIndex] != -1){
                // Increment index and use modulo to "wrap around" to the start of the array
                hashIndex = (hashIndex + 1) % tableSize;
            }

            // Step 3: Insert the key into the first available empty slot found
            hashTable[hashIndex] = key;
        }

        // Print the final state of the Hash Table
        for(int i = 0; i < tableSize; i++){
            // Displays the value at each index (will show -1 for empty slots)
            System.out.print(hashTable[i] + " ");
        }
    }
}