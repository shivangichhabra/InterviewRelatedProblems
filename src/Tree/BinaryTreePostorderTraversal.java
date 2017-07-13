package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shivangi on 7/9/2017.
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> recursiveTraversal(TreeNode root) {
        if (root == null)
            return new LinkedList<Integer>();
        List<Integer> result = new LinkedList<Integer>();
        result.addAll(recursiveTraversal(root.left));
        result.addAll(recursiveTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.peek();

            if(top.left == null && top.right == null){
                stack.pop();
                list.add(top.val);
            }

            if(top.right != null){
                stack.push(top.right);
                top.right = null;
            }


            if(top.left != null){
                stack.push(top.left);
                top.left = null;
            }
        }
        return list;
    }
}