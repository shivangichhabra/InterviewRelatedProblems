package String;

/**
 * Created by Shivangi on 8/25/2017.
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class DeleteOperationOnTwoStrings {

    /*
    Find longest common subsequence and delete that length from each string.
     */
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0; //initialize;
        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                dp[i][j] = (s1.charAt(i-1) == s2.charAt(j-1)) ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int val = dp[s1.length()][s2.length()];
        return s1.length()-val + s2.length()-val;
    }

    public static void main(String args[]){
        DeleteOperationOnTwoStrings ds = new DeleteOperationOnTwoStrings();
        String s1 = "sea";
        String s2 = "ate";

        System.out.println(ds.minDistance(s1,s2));
    }
}
