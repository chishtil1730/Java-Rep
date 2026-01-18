public class SpecialNum {

    public static void main(String[] args) {

        int num = 123;
        int temp = num;
        int sum=0;
        while(temp>0 ){
            sum +=temp%10;
            temp=temp/10;
        }
        System.out.println(sum==num);

    }

}
