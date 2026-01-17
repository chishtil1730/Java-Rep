import java.util.Arrays;

public class LinearProbing {

    public static void main(String[] args) {
        int tableSize =7;
        int[] keys = {50,700,76,85};
        int numKeys=4;

        int[] hashTable = new int[tableSize];
        Arrays.fill(hashTable,-1);

        for(int i=0;i<numKeys;i++){
            int key = keys[i];
            int hashIndex = key%tableSize;

            while(hashTable[hashIndex]!=-1){
                hashIndex = (hashIndex+1)%tableSize;
            }
            hashTable[hashIndex] = key;
        }

        for(int i=0;i<tableSize;i++){
            System.out.print(hashTable[i]+" ");
            //System.out.println(hashTable[i]+" inserted at: "+i);
        }
    }

}
