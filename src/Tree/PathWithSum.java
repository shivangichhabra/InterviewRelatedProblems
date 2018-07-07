package Tree;

public class PathWithSum {

    public int getSum(TreeNode root, int targetSum){
        if(root == null)
            return 0;

        int count = getPathCount(root, targetSum, 0);

        count += getSum(root.left, targetSum);
        count += getSum(root.right, targetSum);

        return count;
    }

    public int getPathCount(TreeNode node, int target, int currentSum){
        if(node == null)
            return 0;

        int totaPaths = 0;
        currentSum += node.val;
        if(currentSum == target)
            totaPaths++;

        totaPaths += getPathCount(node.left, target, currentSum);
        totaPaths += getPathCount(node.right, target, currentSum);

        return totaPaths;
    }
}
