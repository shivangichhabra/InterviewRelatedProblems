package String;

/*
To some string S, we will perform some replacement operations that replace groups of letters with new ones
(not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.
The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.
If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then
because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee",
as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing
because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement:
for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
 */
import java.util.Arrays;
public class FindAndReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(S == null  || S.length() == 0)
            return "";

        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for(int i=0; i<indexes.length; i++){
            int idx = indexes[i];
            if(S.substring(idx, idx+sources[i].length()).equals(sources[i])){
                match[idx] = i;
            }
        }

        StringBuilder output = new StringBuilder();
        int x = 0;
        while(x < N){
            if(match[x] >= 0){
                output.append(targets[match[x]]);
                x += sources[match[x]].length();
            } else {
                output.append(S.charAt(x++));
            }
        }
        return output.toString();
    }
}
