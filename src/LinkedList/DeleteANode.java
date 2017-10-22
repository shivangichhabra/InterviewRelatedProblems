package LinkedList;

/**
 * Created by Shivangi on 10/22/2017.
 */
public class DeleteANode {
    public void deleteNode(ListNode node) {
        if(node != null && node.next != null)  {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        }
    }
}
