import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Attendance {

    public static void main(String[] args) {

        LinkedHashMap<String,int[]> classes = new LinkedHashMap<>();
        String[] slots = {"A1-COA","A2-MGT","B1-STS","C1-SWE","D1-DBMS","E1-MATH","F1-ML"};
        String[] days_values = {"TUE","WED","THU","FRI","SAT"};
        String[] days = {"1","2","3","4","5"};

        String days_left = "23451234512345";
        String[] leftOut = days_left.split("");
        //System.out.println(Arrays.toString(leftOut));

        int[]  finished = {49,24,35,37,35,34,34};
        int[] finished2 = {49,24,35,37,35,34,34};
        int[]  attended = {42,20,30,31,32,31,31};
                               //a1 a2 b1 c1 d1 e1 f1
        classes.put("1",new int[]{1, 1, 1, 1, 1, 0, 0});//tue
        classes.put("2",new int[]{0, 0, 1, 0, 1, 1, 1});//wed
        classes.put("3",new int[]{1, 1, 0, 1, 1, 0, 0});//thu
        classes.put("4",new int[]{1, 0, 1, 0, 0, 1, 1});//fri
        classes.put("5",new int[]{1, 0, 0, 1, 0, 1, 1});//sat



        int num = leftOut.length;

        for (String i: leftOut){
            int[] toAdd = classes.get(i);
            addArrays(finished,toAdd);
            num--;
            if(num==2){
                //printArr(finished);
            }
        }


        /*System.out.println("\nTotal finished classes:");
        System.out.println(Arrays.toString(slots));
        printArr(finished);*/

        int[] classLeftToAttend = {0,0,0,0,0,0,0};
        for (String i: leftOut){
            int[] toAdd = classes.get(i);
            addArrays(classLeftToAttend,toAdd);
        }

        int[] classYouHaveToAttend = new int[7];

        //System.out.println("Classes you have to attend: ");

        //System.out.print("[");
        int k=0;
        for (int i : finished){
            //System.out.print("  "+( ( (i*75)/100 +1 )-attended[k] )+"    ");
            classYouHaveToAttend[k] = ( ( (i*75)/100 +1 )-attended[k] );
            k++;
        }
        //System.out.println("]");

        LinkedHashMap<String,Integer> left_to_attend = new LinkedHashMap<>();
        for(int i=0;i<finished.length;i++){
            left_to_attend.put(slots[i],classYouHaveToAttend[i]);
        }



        /*System.out.println(Arrays.toString(finished));
        System.out.println(Arrays.toString(attended));*/
        System.out.println("Classes attended until now: ");
        System.out.println(Arrays.toString(slots));
        printArr(attended);
        System.out.println("Classes finished: ");
        printArr(finished2);
        System.out.println("Current attendance: ");
        System.out.print("[");
        for(int i=0;i<finished2.length;i++){
            System.out.print("  "+(attended[i]*100/finished2[i])+"%   ");
        }
        System.out.println("]");

        System.out.println();

        System.out.println("Classes left to attend: ");
        System.out.print("[");
        for (int i: classLeftToAttend){
            System.out.print(" "+i+"      ");
        }
        System.out.println("]");

        System.out.println("Classes you have to attend: ");
        System.out.print("[");
        for (int i: classYouHaveToAttend){
            System.out.print(" "+i+"       ");
        }
        System.out.println("]");


        System.out.println("Classes you can bunk with attendance left: ");

        System.out.print("[");
        for (int i=0;i<classYouHaveToAttend.length;i++){
            System.out.print(" "+(classLeftToAttend[i]-classYouHaveToAttend[i])+"       ");
        }
        System.out.println("]");
        System.out.print("[");
        for(int i=0;i<finished.length;i++){
            System.out.print("  "+((attended[i]+classYouHaveToAttend[i])*100/finished[i])+"%   ");
        }
        System.out.println("]");


        System.out.println();

        System.out.println("Summary: ");
        int p=0;
        for(Map.Entry<String,Integer> mp : left_to_attend.entrySet()){
            System.out.println(mp.getKey()+" => "+mp.getValue()+" out of "+classLeftToAttend[p]);
            p++;
        }

    }

    public static void addArrays(int[] arr1, int[] arr2){
        if(arr1.length!=arr2.length){
            System.out.println("Lengths do not match");
        }else {
            for(int i=0;i<arr1.length;i++){
                arr1[i]+=arr2[i];
            }
        }
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for(int i: arr){
            System.out.print("  "+i+"    ");
        }
        System.out.println("]");
    }

}