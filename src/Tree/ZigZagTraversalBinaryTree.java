package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shivangi on 2/24/2018.
 */
public class ZigZagTraversalBinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int size = 0;

        while(!queue.isEmpty()){
            size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                System.out.println(queue.size() + "  " + size);

                TreeNode node = queue.poll();
                if(level % 2 == 0)
                    list.add(node.val);
                else
                    list.add(0,node.val);

                if(node.left != null)
                    queue.offer(node.left);

                if(node.right != null)
                    queue.offer(node.right);
            }
            level++;
            result.add(list);
        }
        return result;
    }
}

