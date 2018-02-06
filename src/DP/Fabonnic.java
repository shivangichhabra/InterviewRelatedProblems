package DP;

public class Fabonnic {

    public int fabDP(int n){
        if(n==0 || n==1)
            return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }



    public static void main(String args[]){
        Fabonnic f = new Fabonnic();
        System.out.println(f.fabDP(46));
    }
}
