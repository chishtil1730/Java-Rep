import java.util.*;

public class QuadraticProbing {
    public static void main(String[] args) {
        int tableSize = 10;
        int numKeys = 5;

        int[] keys = {90 ,88 ,45 ,78 ,102};
        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable,-1);

        for(int i=0;i<numKeys;i++){
            int key = keys[i];
            int hashIndex = key%tableSize;

            int j=0;
            while(hashTable[hashIndex]!=-1){
                j++;
                hashIndex = (hashIndex + j*j)%tableSize;
            }
            hashTable[hashIndex] = key;
        }

        boolean found = false;

        for(int i=0;i<tableSize;i++){
            if(hashTable[i]!=-1 && isPrime(i)){
                System.out.println("Element at prime index "+i+" "+hashTable[i]);
                found=true;
            }
        }
        if(!found) System.out.println("No element at prime index.");

    }

    static boolean isPrime(int n){
        if(n==2) return true;
        if(n<=1) return false;

        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;

    }

}
