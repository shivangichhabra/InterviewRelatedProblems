package Arrays;

public class ProductArrayExceptSelf {


    //with multiple pass
    private int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        //product of left of nums[i];
        for(int i=0, temp=1; i< nums.length; i++){
            output[i] = temp;
            temp *= nums[i];
        }

        //product of right of nums[i]
        for(int i=nums.length-1, temp=1; i>=0; i--){
            output[i] *= temp;
            temp *= nums[i];
        }
        return output;
    }

    //with single pass
    private int[] productExceptSelfSinglePass(int[] nums) {
        int[] output = new int[nums.length];
        for(int i=0; i<output.length; i++)
            output[i] = 1;

        int  left=1, right = 1;

        for(int i=0, j=nums.length-1; i<nums.length-1; i++, j--){
            left *= nums[i];
            output[i+1] *= left;
            right *= nums[j];
            output[j-1] *= right;

        }
        return output;
    }

    public static void main(String args[]){
        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        int[] a = {0,10,2,10};
        int[] output = p.productExceptSelf(a);
        for(int i : output){
            System.out.print(output[i] + " ");
        }

        System.out.println("\n----------------------------");
        int[] secondOutput = p.productExceptSelfSinglePass(a);
        for(int i : secondOutput){
            System.out.print(secondOutput[i] + " ");
        }
    }
}
