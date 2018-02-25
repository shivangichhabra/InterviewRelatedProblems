package Tree;

import java.util.ArrayList;

/**
 * Created by Shivangi on 2/25/2018.
 */
public class InorderTraversalOfCartesianTree {
    public int getMax(ArrayList<Integer> A, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxIndex = 0 ;
        for(int i=start+1; i<=end; i++){
            if(A.get(i) > max){
                max = A.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return buildTree(A, 0, A.size()-1);
    }

    public TreeNode buildTree(ArrayList<Integer> A, int start, int end){
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(A.get(start));

        int maxIndex = getMax(A, start, end);
        TreeNode root = new TreeNode(A.get(maxIndex));
        root.left = buildTree(A, start, maxIndex-1);
        root.right = buildTree(A, maxIndex+1, end);

        return root;
    }
}
