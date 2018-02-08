package Tree;

public class KthSmallestElementBST {
    int count = 0;
    int ans = Integer.MAX_VALUE;

    public int kthsmallest(TreeNode A, int B) {
        if(A == null)
            return 0;

        kthsmallest(A.left, B);
        count++;
        if(count == B)
            ans = A.val;

        kthsmallest(A.right, B);
        return ans;

    }
}
