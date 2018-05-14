package String;

public class StringPermutations {

    public static void main(String args[]){
        String s = "ABC";
        StringPermutations sp = new StringPermutations();
        sp.printPermuations(s,0,s.length()-1);
    }

    public  void printPermuations(String s, int start, int end){
        if(start == end)
            System.out.println(s);
        else{
            for(int i=start; i<=end; i++){
                s = swap(s, start, i);
                printPermuations(s, start+1, end);
                s= swap(s, start, i);
            }
        }
    }

    public String swap(String s, int x, int y){
        char[] temp = s.toCharArray();
        char c = temp[x];
        temp[x] = temp[y];
        temp[y] = c;
        return String.valueOf(temp);
    }
}
