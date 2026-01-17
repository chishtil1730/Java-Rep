import java.util.HashMap;
import java.util.Map;

public class ElectoralVotes {

    public static void main(String[] args) {
        String[] votes = {"Alice", "Bob", "Charlie" ,"Alice" ,"Charlie", "Charlie" ,"Alice" ,"Charlie"};
        HashMap<String,Integer> map = new HashMap<>();

        for(String s : votes){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else {
                map.put(s,1);
            }
        }
        int maxVal=0;
        String winner = "";
        for(Map.Entry<String,Integer> hm : map.entrySet()){
           if(hm.getValue()>maxVal){
               maxVal= hm.getValue();
               winner = hm.getKey();
           }
        }
        System.out.println("The winner is: "+winner+",sa with votes: "+maxVal);
    }

}
