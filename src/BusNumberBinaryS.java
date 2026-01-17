public class BusNumberBinaryS {
    public static void main(String[] args) {
        int[] arr = {43, 67 ,89 ,90 ,96};

        int left=0;
        int right = arr.length-1;
        int index=-1;
        int target =90;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                index = mid;
                right = mid-1;
            }else if(arr[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(index+"  " +arr[index]);
    }

}
