package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shivangi on 2/25/2018.
 */
public class VerticalOrderTraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        nodeQ.offer(root);
        level.offer(0);

        int minHD = Integer.MAX_VALUE;
        int maxHD = Integer.MIN_VALUE;

        while(!nodeQ.isEmpty()){
            TreeNode temp = nodeQ.poll();
            int count = level.poll();

            if(count < minHD)
                minHD = count;
            if(count > maxHD)
                maxHD = count;

            if(map.containsKey(count)){
                map.get(count).add(temp.val);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(temp.val);
                map.put(count, list);
            }

            if(temp.left != null){
                nodeQ.offer(temp.left);
                level.offer((Integer)count-1);
            }

            if(temp.right != null){
                nodeQ.offer(temp.right);
                level.offer((Integer)count+1);
            }
        }

        for(int i=minHD; i<=maxHD; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
