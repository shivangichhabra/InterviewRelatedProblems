package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shivangi on 7/11/2017.
 *
 * Level Order Traversal To print
 * Input
 *          1
 *         / \
 *        2   3
 *       /\
 *      4 5
 *
 * Output
 *  1 ! 2,3 ! 4,5
 */
public class LevelOrderTraversal {

    public List<List<TreeNode>> getLevelData(TreeNode root){
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>();
        if(root == null)
            return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<TreeNode> level = new ArrayList<>(queue.size());
            levels.add(level);

            for(TreeNode n : new ArrayList<>(queue)){
                level.add(n);
                if(n.left != null)
                    queue.add(n.left);

                if(n.right != null)
                    queue.add(n.right);

                queue.poll();
            }
        }
        return levels;
    }

    public void printGivenLevel(TreeNode root){
        List<List<TreeNode>> levels = getLevelData(root);
        for(List<TreeNode> level : levels){
            int size = level.size();
            for(TreeNode node : level){
                if(size > 1){
                    System.out.print(node.val + ",");
                    size--;
                }
                else
                    System.out.print(node.val);
            }
            System.out.print(" ! ");
        }
    }
}
