package Tree;

public class InOrderSuccessorBST {

    //O(h) = height of tree
    public TreeNode getInOrderSuccess(TreeNode root, TreeNode node){
        if(node == null)
            return null;

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

    //this is better way
    public TreeNode getInOrderSuccessOtherWay(TreeNode root, TreeNode node){
        if(node == null)
            return null;

        if(node.right != null)
            return findRightMin(node.right);
        else{
            TreeNode n = node;
            TreeNode parent = n.parent;

            while(parent != null && parent.left != n){
                n = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }


    private TreeNode findRightMin(TreeNode node) {
        while(node.left != null)
            node = node.left;
        return node;
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
    }
}
