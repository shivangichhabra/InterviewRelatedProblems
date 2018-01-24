package Tree;

/**
 * Created by Shivangi on 7/12/2017.
 */
public class LowestCommonAnestor {
    /**
     *
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. According to the
     * definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest
     * node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

                                        _______3______
                                       /              \
                                    ___5__          ___1__
                                   /      \        /      \
                                  6      _2       0       8
                                        /  \
                                       7   4
     * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4
     * is 5, since a node can be a descendant of itself according to the LCA definition.
     */
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

    public int lca(TreeNode A, int B, int C) {
        if(A != null  &checkIfValueExist(A,B) & checkIfValueExist(A,C)){
            TreeNode result = LeastCommonAncestor(A, B, C);
            return result == null ? -1 : result.val;
        }

        return -1;

    }


    public TreeNode LeastCommonAncestor(TreeNode A, int B, int C) {
        if(A == null)
            return null;

        if(A.val == B || A.val == C)
            return A;

        TreeNode left  = LeastCommonAncestor(A.left, B, C);
        TreeNode  right = LeastCommonAncestor(A.right, B, C);

        return left != null && right != null ? A : (left != null ?  left : right);
    }

    public boolean checkIfValueExist(TreeNode A, int V){
        if(A == null)
            return false;

        if(A.val == V)
            return true;

        return  checkIfValueExist(A.left, V) || checkIfValueExist(A.right, V);
    }
}
