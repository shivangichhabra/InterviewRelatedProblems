package String;

import java.util.Scanner;

/**
 * Created by Shivangi on 8/7/2017.
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
