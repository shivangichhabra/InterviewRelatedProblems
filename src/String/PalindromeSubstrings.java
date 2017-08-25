package String;

import java.util.Scanner;

/**
 * Created by Shivangi on 8/7/2017.
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they
 * consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromeSubstrings {

    int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        for(int i=0; i<s.length(); i++){
            palindromString(s, i, i);
            palindromString(s, i, i+1);
        }
        return count;
    }

    public void palindromString(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }

    public static void main(String args[]){
        PalindromeSubstrings ps = new PalindromeSubstrings();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(ps.countSubstrings(s));
    }
}
