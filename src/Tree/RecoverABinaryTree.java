package Tree;

import java.util.ArrayList;

/**
 Question

 Two elements of a binary search tree (BST) are swapped by mistake.
 Tell us the 2 values swapping which the tree will be restored.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 Solution for O(n) space -> recursive inorder and find the pair that is not in sorted order

 Solution for O(10 space ->Can be done using Inorder Traversal with recursion and without stack and find the pair again

 Solution approach:
 Lets look at the inorder traversal of the tree.
 In the ideal case, the inorder traversal should be sorted. But in this case, because of the swapping 2 cases might arise :
 1) A sequence like {1, 4, 3, 7, 9}, where the swapped pair are adjacent to each other. Only one inversion ( Inversion here means pair of integer A[i], A[i+1] where A[i] > A[i+1] ).
 2) A sequence like {1, 9, 4, 5, 3, 10} where the swapped pair are not adjacent. 2 inversions. We take the min and max of the inversion numbers and we know the number we need to swap to get the right answer.

 Now to figure this out, we need to do an inorder traversal. However, the traditional recursive inorder traversal has memory overhead of the depth of the tree.
 Using a stack has the same memory overhead.

 So, we need something which does not use recursion or stack and can still do the inorder traversal. This part is a bit tricky. Not all interviewers expect you to know this.
 Morris traversal helps us achieve what we are after. It works on the fact that we can modify the tree when traversing and then resetting the tree to its original state once we are done.

 The idea of Morris traversal is based on Threaded Binary tree ( http://en.wikipedia.org/wiki/Threaded_binary_tree ).

 In this traversal, we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.

 Initialize current as root
 While current is not NULL
 If current does not have left child
 a) Print current’s data
 b) Go to the right, i.e., current = current->right
 Else
 a) Make current as right child of the rightmost node in current’s left subtree
 b) Go to this left child, i.e., current = current->left
 Although the tree is modified through the traversal, it is reverted back to its original shape after the completion.
 */
public class RecoverABinaryTree {
    TreeNode first, second, prev;
    //first node to swap
    //second node to swap
    //prev node

    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        inorderTraverse(A);
        if(second == null){
            list.add(first.val);
            list.add(prev.val);
        } else if(first.val < second.val){
            list.add(first.val);
            list.add(second.val);
        } else {
            list.add(second.val);
            list.add(first.val);
        }

        return list;
    }

    public void inorderTraverse(TreeNode root){
        if(root == null)
            return;
        inorderTraverse(root.left);

        if(prev != null ){
            if(root.val < prev.val){
                if(first == null)
                    first = prev; //If first element has not been found, assign it to prevElement
                second = root;  //If first element is found, assign the second element to the root
            }
        }
        prev = root;

        inorderTraverse(root.right);
    }
}
