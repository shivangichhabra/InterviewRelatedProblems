package Tree;

public class KthSmallestElementBST {
    int count = 0;
    int ans = Integer.MAX_VALUE;
    public int getKthSmallestElement(TreeNode root, int k){
       traverse(root, k);
       return ans;
    }

    public void traverse(TreeNode root, int k){
        if(root == null)
            return;

        traverse(root.left, k);
        count--;
        if(count == k)
            ans = root.val;

        traverse(root.right, k);
    }
}
