package Tree;

/**
 * Created by Shivangi on 7/12/2017.
 */
public class LowestCommonAnestor {
    
    public TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestorBinaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorBinaryTree(root.right, p, q);

        return left != null && right != null ? root : (left == null ? right : left);
    }

    public TreeNode lowestCommonAncestorBinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root.val > p.val && root.val > q.val) {
            //go left
            lowestCommonAncestorBinarySearchTree(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val) {
            //go right
            lowestCommonAncestorBinarySearchTree(root.right, p, q);
        }

        return root;
    }
}
