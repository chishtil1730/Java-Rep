import java.util.*;
public class BinarySCountries {
    //New Comment.
    public static void main(String[] args) {
        String s = "Canada Japan India Spain UK";
        String[] countries = s.split(" ");

        String target = "India";

        int left=0;
        int right = countries.length-1;
        int index=-1;

        while(left<=right){
            int mid = ( left + right )/2;
            if(countries[mid].equals(target)){
                index=mid;
                right = mid-1;
            }else if(countries[mid].compareTo(target)>0){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        System.out.println(index);

    }

}
