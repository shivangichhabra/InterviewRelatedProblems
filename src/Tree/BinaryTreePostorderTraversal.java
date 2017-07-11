package Tree;

import java.util.LinkedList;
import java.util.List;

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
}