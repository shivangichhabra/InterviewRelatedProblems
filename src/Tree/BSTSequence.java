package Tree;

import java.util.LinkedList;
import java.util.List;

public class BSTSequence {

    List<List<TreeNode>> allSeq = new LinkedList<>();

    public List<List<TreeNode>> BST(TreeNode root){
        LinkedList<TreeNode> visited = new LinkedList<>();
        LinkedList<TreeNode> possible = new LinkedList<>();

        bstHelper(root, visited, possible);
        return allSeq;
    }

    public void bstHelper(TreeNode node, LinkedList<TreeNode> visited, LinkedList<TreeNode> possible){
        visited.add(node);
        if(node.left != null)
            possible.add(node.left);

        if(node.right != null)
            possible.add(node.right);

        if(possible.isEmpty())
            allSeq.add(visited);


        for(TreeNode n : possible){
            LinkedList<TreeNode> _visited = (LinkedList<TreeNode>) visited.clone();
            LinkedList<TreeNode> _possible = (LinkedList<TreeNode>) possible.clone();
            _possible.remove(n);
            bstHelper(n, _visited, _possible);
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.left.left = new TreeNode(3);

        BSTSequence sequence = new BSTSequence();
        List<List<TreeNode>> allSeq = sequence.BST(root);
        for(List<TreeNode> list : allSeq){
            for( TreeNode n : list){
                System.out.print(n.val + "  ");
            }
            System.out.println("");
        }
    }
}