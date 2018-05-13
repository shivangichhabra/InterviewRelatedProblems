package String;

import java.util.StringTokenizer;

/**
 * Created by Shivangi on 11/13/2017.
 */
public class RemoveArbitrarySpace {

    public String removeSpace(String s){
        char[] c = s.trim().toCharArray();
        boolean spaceFound = false;
        int i=0, j=0;
        while(i<s.length()){
            if(c[i] != ' '){
                if(c[i] == '.' || c[i] == ',' ||c[i] == '?' || c[i] == '!' && j-1 >= 0 && c[j-1] == ' ')
                    c[j-1] = c[i];
                else
                    c[j++] = c[i];

                spaceFound = false;
            } else if(c[i] == ' '){
                if(!spaceFound){
                    c[j++] = ' ';
                    spaceFound = true;
                }
            }
            i++;
        }

        //to handle remaining chars
        while(j<s.length()){
           c[j++] = ' ';
        }
        return String.valueOf(c).trim();
    }

    public static void main(String args[]){
        RemoveArbitrarySpace s = new RemoveArbitrarySpace();
        System.out.println(s.removeSpace("I am  Shivangi . Who are ! you ."));
    }
}
