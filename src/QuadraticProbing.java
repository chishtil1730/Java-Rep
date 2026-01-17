import java.util.*;

public class QuadraticProbing {
    public static void main(String[] args) {
        // Configuration for the Hash Table
        int tableSize = 10;
        int numKeys = 5;

        // Input keys and the hash table array
        int[] keys = {90 ,88 ,45 ,78 ,102};
        int[] hashTable = new int[tableSize];

        // Initialize table with -1 to represent empty slots
        Arrays.fill(hashTable, -1);

        // Insertion Loop
        for(int i = 0; i < numKeys; i++){
            int key = keys[i];
            // Initial Hash Function (Modular Arithmetic)
            int hashIndex = key % tableSize;

            int j = 0;
            // Collision Handling: Search for the next slot using Quadratic Probing
            while(hashTable[hashIndex] != -1){
                j++;
                // Update index: (Initial Index + j^2) % Table Size
                hashIndex = (hashIndex + j * j) % tableSize;
            }
            // Place key in the found empty slot
            hashTable[hashIndex] = key;
        }

        // Search and Output Phase
        boolean found = false;

        // Iterate through table and find values stored at Prime Number indices
        for(int i = 0; i < tableSize; i++){
            if(hashTable[i] != -1 && isPrime(i)){
                System.out.println("Element at prime index " + i + " " + hashTable[i]);
                found = true;
            }
        }

        if(!found) System.out.println("No element at prime index.");
    }

    /**
     * Helper method to determine if a number is prime.
     * Used here to filter the indices of the hash table.
     */
    static boolean isPrime(int n){
        if(n == 2) return true; // 2 is the smallest prime
        if(n <= 1) return false; // 0 and 1 are not prime

        // Check for divisors from 2 up to n-1
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}