package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivangi on 8/21/2017.
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddress {

    /*
    Using 3 loops
     */
    public List<String> restoreIpAddressesOne(String s) {
        List<String> list = new ArrayList<String>();
        int len = s.length();
        for(int i=1; i<4 && i<len-2; i++){
            for(int j=i+1; j<i+4 && j<len-1; j++){
                for(int k=j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        list.add(s1+"."+s2+"."+s3+"."+s4);
                }
            }
        }

        return list;
    }

    public boolean isValid(String s){
        if(s.length() == 0 || s.length() > 3 || s.charAt(0) == '0' && s.length() > 1 || Integer.parseInt(s) > 255)
            return false;
        return true;
    }

    /*
    Using DFS
     */
    public List<String> restoreIpAddressesTwo(String s) {
        List<String> list = new ArrayList<String>();
        dfs(s, list, 0, "", 0);
        return list;
    }

    public void dfs(String ip, List<String> list, int idx, String restored, int count){
        if(count > 4) return;
        if(count == 4 && idx == ip.length())
            list.add(restored);

        for(int i=1; i<4; i++){
            if(idx+i > ip.length()) break;
            String s = ip.substring(idx, idx+i);

            if((s.startsWith("0") && s.length()>1) || (Integer.parseInt(s) > 255))
                continue;

            dfs(ip, list, idx+i, restored+s+(count==3 ? "":"."), count+1);
        }
    }

    public static void main(String args[]){
        RestoreIPAddress rip = new RestoreIPAddress();
        List<String> output1 = rip.restoreIpAddressesOne("010010");
        for(String s : output1)
            System.out.println(s);

        System.out.println("-------------------------------------------");

        List<String> output2 = rip.restoreIpAddressesTwo("010010");
        for(String s : output2)
            System.out.println(s);
    }
}
