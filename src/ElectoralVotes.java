import java.util.HashMap;
import java.util.Map;

public class ElectoralVotes {

    public static void main(String[] args) {
        // Input data: An array representing individual votes cast for candidates
        String[] votes = {"Alice", "Bob", "Charlie", "Alice", "Charlie", "Charlie", "Alice", "Charlie"};

        // HashMap to store Candidate Name (String) and their Vote Count (Integer)
        HashMap<String, Integer> map = new HashMap<>();

        // Phase 1: Counting Votes
        for (String s : votes) {
            // If the candidate is already in the map, increment their count
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                // If this is the first time we see the candidate, initialize count to 1
                map.put(s, 1);
            }
        }

        // Phase 2: Finding the Winner
        int maxVal = 0;       // Track the highest number of votes found
        String winner = "";   // Track the name of the candidate with maxVal votes

        // Iterate through each Entry (Key-Value pair) in the Map
        for (Map.Entry<String, Integer> hm : map.entrySet()) {
            // Check if the current candidate's votes are higher than the current max
            if (hm.getValue() > maxVal) {
                maxVal = hm.getValue();
                winner = hm.getKey();
            }
        }

        // Output the result
        System.out.println("The winner is: " + winner + " with votes: " + maxVal);
    }
}