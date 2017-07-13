package Tree;

/**
 * Created by Shivangi on 7/12/2017.
 */
public class DeleteANodeFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }


    public TreeNode findMin(TreeNode node){
        while(node.left != null)
            node = node.left;
        return node;
    }
}
