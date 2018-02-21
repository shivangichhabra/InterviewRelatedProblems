package Tree;

/**
 * Created by Shivangi on 2/21/2018.
 */
public class ValidateBST {
    public int isValidBST(TreeNode A) {
        return isValidBST(A, null, null);
    }

    public int isValidBST(TreeNode A, Integer min, Integer max){
        if(A == null)
            return 1;

        if((min != null && A.val <= min)  || (max != null && A.val >= max))
            return 0;

        return isValidBST(A.left, min, A.val) & isValidBST(A.right, A.val, max);
    }
}
