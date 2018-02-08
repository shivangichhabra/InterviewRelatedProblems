package Tree;

import java.util.HashSet;
import java.util.Set;

public class SecondSmallestElementInBT {

    public void dfs(TreeNode node, Set<Integer> set){
        if(node != null){
            set.add(node.val);
            dfs(node.left, set);
            dfs(node.right, set);
        }
    }

    /*
    O(n) but space
     */
    public int getSecondSmallestElement(TreeNode root){
        Set<Integer> set = new HashSet<>();
        dfs(root, set);

        int top = root.val;
        long bottom = Long.MAX_VALUE;

        for(int i : set)
            if(i > top  && i < bottom)
                bottom = i;

        return bottom < Long.MAX_VALUE ? (int) bottom : -1;

    }


    /*
    O(n) but no space
     */
    int top = 0;
    long ans = Long.MAX_VALUE;

    public void dfs(TreeNode node){
        if(node != null){
            if(node.val > top && node.val < ans)
                ans = node.val;
            else if(node.val == top)
                dfs(node.left);
            dfs(node.right);
        }
    }

    public int findSecondMinimumValueBetter(TreeNode root){
        top = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans : -1;

    }
}
