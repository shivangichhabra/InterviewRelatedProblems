import java.util.PriorityQueue;

public class Solution {
    public int[] convert(String[] inputs){

        int ans[] = new int[inputs.length];
        for(int i=0; i<inputs.length; i++){
            int curr = 0;
            for(int j=0; j<inputs[i].length(); j++){
                curr = curr*26 + (inputs[i].charAt(j)-'A'+1);
            }
            ans[i] = curr;
        }
        return ans;
    }

    public int[] titleToNumber(String[] s) {
        int[] ans = new int[s.length];
        for(int j =0; j<s.length; j++) {
            int count = 0;
            for (int i = 0; i < s[j].length(); i++) {
                count = count * 26 + ((s[j].charAt(i) - 'A') + 1);
            }
            ans[j] = count;
        }
        return ans;
    }

    public void shiftRight(int[] buffer, int bufferLength, int N){
        for(int i=bufferLength+N-1; i>=N; i--){
            buffer[i] = buffer[i-N];
        }
    }


    public void orderProductsByPriority(String[] productCodes){ //string
        int lastHigh = 0;
        for(int i=0; i<productCodes.length; i++) {
            if (getPriority(productCodes[i]) == 1) {
                lastHigh++;
                if (i > lastHigh) {
                    String temp = productCodes[i];
                    productCodes[i] = productCodes[lastHigh];
                    productCodes[lastHigh] = temp;
                }
            }
        }

        for(int i=lastHigh; i<productCodes.length; i++){
           if(lastHigh < i){
                if(getPriority(productCodes[i]) == 2){
                    lastHigh++;
                    String temp = productCodes[i];
                    productCodes[i] = productCodes[lastHigh];
                    productCodes[lastHigh] = temp;
                }
            }
        }

        for(String s : productCodes){
            System.out.println(s);
        }
    }

    private int getPriority(String productCode){
        if(productCode.charAt(0) == 'A')
            return 1;
        else if(productCode.charAt(0) == 'B')
            return 2;
        else
            return 3;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String[] input= {"A1", "B2", "D3", "A4", "B5", "C6"};
        s.orderProductsByPriority(input);
    }
}
