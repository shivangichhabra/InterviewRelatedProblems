package Tree;

import java.util.ArrayList;

/**
 iven a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 Example :

 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    // To check if one path exists
    public int hasPathSum(TreeNode A, int B) {
        if(A == null)
            return 0;

        if(A.left == null && A.right == null && A.val == B)
            return 1;

        return (hasPathSum(A.left, B - A.val)| hasPathSum(A.right, B - A.val));
    }

    // To get all the paths
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sublist = new ArrayList<Integer>();
        dfs(A, B, list, sublist);
        return list;
    }

    public void dfs(TreeNode A, int B, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> sublist){
        if(A == null) return;

        sublist.add(A.val);
        if(A.left == null && A.right == null && A.val == B){
            list.add(new ArrayList<Integer>(sublist));
            sublist.remove(sublist.size()-1);
            return;
        }


        if(A.left != null)
            dfs(A.left, B-A.val, list, sublist);

        if(A.right != null)
            dfs(A.right, B-A.val, list, sublist);

        sublist.remove(sublist.size()-1);
    }
}
