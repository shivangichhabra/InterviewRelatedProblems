package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivangi on 2/25/2018.
 */
public class TwoSumBinaryTree {

    /*
    O(n) solution
     */
    public int t2SumN(TreeNode A, int B) {
        if(A == null)
            return 0;
        List<Integer> list = new ArrayList<Integer>();
        inOrder(A, list);
        for(int i=0, j=list.size()-1; i<j;){
            if(list.get(i) +list.get(j) == B)
                return 1;

            if(list.get(i) +list.get(j) > B)
                j--;
            else
                i++;
        }

        return 0;
    }

    public void inOrder(TreeNode root, List<Integer> list){
        if(root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    /*
    O(log(n)) solution
     */
    public boolean t2SumLogN(TreeNode A, int B) {
        if(A == null)
            return false;
        return t2SumLogN(A,A,B);
    }

    public boolean t2SumLogN(TreeNode root, TreeNode curr, int  val){
        if(curr == null)
            return false;
        return search(root, curr, val-curr.val) ||
                t2SumLogN(root, curr.left, val) ||
                t2SumLogN(root, curr.right, val);
    }

    public boolean search(TreeNode root, TreeNode curr, int val){
        if(root == null || curr == null)
            return false;

        if(root.val == val && root != curr)
            return true;

        if(root.val < val)
            return search(root.right, curr, val);
        else
            return search(root.left, curr, val);
    }
}
