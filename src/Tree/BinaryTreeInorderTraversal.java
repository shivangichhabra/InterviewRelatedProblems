package Tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shivangi on 7/9/2017.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> recursiveTraversal(TreeNode root) {
        if (root == null)
            return new LinkedList<Integer>();

        List<Integer> result = new LinkedList<Integer>();
        result.addAll(recursiveTraversal(root.left));
        result.add(root.val);
        result.addAll(recursiveTraversal(root.right));
        return result;
    }

    public List<Integer> iterativeTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();

            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            } else {
                result.add(top.val);
                stack.pop();
                if (top.right != null)
                    stack.push(top.right);
            }

        }
        return result;
    }
}