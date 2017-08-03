package DP;

import java.util.*;

/**
 * Created by Shivangi on 8/2/2017.
 *
 * Given a number of dollars, n, and a list of dollar values for m distinct coins, C = {c1, c2, c3}, find and print the
 * number of different ways you can make change for  dollars if each coin is available in an infinite quantity.
 *
 * Input Format
 *
 * The first line contain two space-separated integers describing the respective values of n and m.
 * The second line contains m space-separated integers describing the respective values of c0, c1, c2.., where each
 * integer denotes the dollar value of a distinct coin available in an infinite quantity.
 *
 * Output Format
 *
 * Print a single integer denoting the number of ways we can make change for n dollars using an infinite supply of our
 * m types of coins.
 *
 * Sample Input 0
 * 4 3
 * 1 2 3
 *
 * Sample Output 0
 * 4
 */
public class CoinChange {
    public long getWay(int[] coins, int money){
        long[] dp = new long[money+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int j = coin; j<dp.length; j++){
                dp[j] += dp[j-coin];
            }
        }
        return dp[money];
    }

    public static void main(String args[]){
        CoinChange c = new CoinChange();
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int numOfCoins = sc.nextInt();
        int[] coins = new int[numOfCoins];
        for(int i=0; i<numOfCoins; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println(c.getWay(coins, money));
    }
}
