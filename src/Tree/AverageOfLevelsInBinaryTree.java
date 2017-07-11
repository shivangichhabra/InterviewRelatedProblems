package Tree;

import java.util.*;

/**
 * Created by Shivangi on 7/10/2017.
 *
 * PROBLEM DESCRIPTION:
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
           3
          / \
         9  20
       /  \
      15   7

 * Output: [3, 14.5, 11]
 *
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            double sum = 0.0;
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(sum/n);
        }
        return result;
    }
}

