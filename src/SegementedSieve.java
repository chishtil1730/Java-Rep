// Java program to print all primes smaller than
// n using segmented sieve


import java.util.Arrays;
import java.util.Vector;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;

class SegmentedSieve {

    public static void segmentedSieve(int l, int r){
        if(l<=0)l=1;
        boolean[] primes = new boolean[r-l+1];
        Arrays.fill(primes,true);
        for(int i=2;i*i<=r;i++){
            int sm = (l/i)*i;
            if(sm<l)sm+=i;
            if(sm==i)sm+=i;
            for(int p=sm;p<=r;p+=i)primes[p-l]=false;
        }
        for(int i=l;i<=r;i++){
            System.out.print(primes[i-l]?i+" ":"");
        }
    }

    public static void main(String args[])
    {
        int n = 100;
        System.out.println("Primes smaller than " + n + ":");
        segmentedSieve(0,100);
    }
}