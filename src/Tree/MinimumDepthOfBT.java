package Tree;

public class MinimumDepthOfBT {
    public int minDepth(TreeNode A) {
        if(A == null)
            return 0;

        if(A.left == null && A.right == null)
            return 1;

        if(A.left == null)
            return minDepth(A.right)+1;

        if(A.right == null)
            return minDepth(A.left)+1;

        return Math.min(minDepth(A.left), minDepth(A.right)) + 1;

    }
}
