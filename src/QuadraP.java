import java.util.Arrays;

public class QuadraP {

    public static void main(String[] args) {
        int tableSize = 10;
        int numKeys = 5;

        int[] keys = {90 ,88 ,45 ,78 ,102};

        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable,-1);

        for(int i=0;i<numKeys;i++){
            int key = keys[i];
            int index = key%tableSize;

            int j=0;
            while(hashTable[index]!=-1){
                j++;
                index = (index+ j*j)%tableSize;
            }
            hashTable[index] = key;
        }

        for(int i=0;i<tableSize;i++){
            if(hashTable[i]!=-1 && isPrime(i)){
                System.out.println("Element at prime index "+i+" is: "+hashTable[i]);
            }
        }

    }

    static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;

        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }


}
