public class ChineseRemainderTheorem {
    public static void main(String[] args) {
        int[] num = {3, 5, 7};
        int[] rem = {2, 3, 2};

        int x = findMinX(num, rem);
        System.out.println("The smallest solution x is: " + x);
    }

    public static int findMinX(int[] num, int[] rem) {
        int x=1;
        while(true){
            int j;
            for(j=0;j<num.length;j++){
                if(x%num[j]!=rem[j]){
                    break;
                }
            }
            if(j== num.length){
                return x;
            }
            x++;
        }
    }
}
