package Tree;

import LinkedList.ListNode;

/**
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.
 */
public class NextRightPointer {

    // You may assume that it is a perfect binary tree
    public void connect(TreeNode root) {
        if(root == null)
            return;

        //root.next = null;
        if(root.left != null)
            root.left.next = root.right;

        if(root.right != null)
            root.right.next = root.next != null ? root.next.left : null;

        connect(root.left);
        connect(root.right);
    }

    // What if the given tree could be any binary tree?
    public void connectIntense(TreeNode root) {

        if(root==null) return;

        TreeNode cur = root;
        TreeNode prev =null;

        while(cur!=null){
            if(prev==null)
                prev = cur.left;
            else if(prev!=null && cur.left!=null) {
                prev.next = cur.left;
                prev =  prev.next;
            }

            if(prev==null)
                prev = cur.right;
            else if(prev!=null && cur.right!=null) {
                prev.next = cur.right;
                prev =  prev.next;
            }
            cur = cur.next;
        }
        connectIntense(root.left);
        connectIntense(root.right);
    }
}
