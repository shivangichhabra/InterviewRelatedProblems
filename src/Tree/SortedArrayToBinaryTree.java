package Tree;

import java.util.List;

/**
 * Created by Shivangi on 2/24/2018.
 */
public class SortedArrayToBinaryTree {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if(a == null || a.size() == 0)
            return null;

        TreeNode root = sortedArrayToBST(a, 0, a.size()-1);
        return root;

    }

    public TreeNode sortedArrayToBST(final List<Integer> a, int start, int end) {
        if(start > end)
            return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left  = sortedArrayToBST(a, start, mid-1);
        node.right = sortedArrayToBST(a, mid+1, end);

        return node;
    }
}
