package Tree;

public class InOrderSuccessorBST {

    //O(h) = height of tree
    public TreeNode getInOrderSuccess(TreeNode root, TreeNode node){
        if(node.right != null)
            return findRightMin(node.right);

        TreeNode successor =  null;
        while(root != null){
            if(node.val < root.val){
                successor = root;
                root = root.left;
            } else if(node.val > root.val){
                root = root.right;
            } else
                break;
        }
        return successor;
    }

    private TreeNode findRightMin(TreeNode node) {
        while(node.left != null)
            node = node.left;
        return node;
    }
}
