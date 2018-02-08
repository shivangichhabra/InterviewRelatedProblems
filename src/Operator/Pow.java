package Operator;

public class Pow {

    /*
    O(n)
     */
    public double myPow(double x, int n) {
        if(n == 0)
            return x;

        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }

        double result = 1;
        for(long i=0; i<N; i++)
            result *= x;
        return result;
    }


    /*
    long(N) recursive
     */
    public double getPowHalf(double x, long n){
        if(n == 0)
            return 1.0;
        double half = getPowHalf(x, n/2);
        if(n %2 == 0)
            return half*half;
        else
            return half*half*x;
    }
    public double myPowR(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return getPowHalf(x,N);
    }

    public double myPowI(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double product = x;
        for(long i=N; i>0; i /= 2){
            if(i % 2  == 1)
                result  = result * product;
            product = product*product;
        }

        return result;
    }
}
