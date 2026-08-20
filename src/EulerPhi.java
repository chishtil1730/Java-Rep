public class EulerPhi {

    public static int euler(int n){
        int ans=n;
        for(int i=2;i*i<n;i++){
            if(n%i==0){
                ans=ans-ans/n;
            }
            while(n%i==0){
                n=n/i;
            }
        }
        if(n>0) ans=ans-ans/n;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(euler(23));
    }

}
