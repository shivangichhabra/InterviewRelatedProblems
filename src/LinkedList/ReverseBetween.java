package LinkedList;

/**
 * Created by Shivangi on 2/18/2018.
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for(int i=0; i<m-1; i++){
            prev = prev.next; // node between reverse process
        }

        ListNode start = prev.next; // start of reverse
        ListNode next = start.next; // node to be reversed

        for(int i=0; i<n-m; i++){
            start.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = start.next;
        }

        return dummy.next;
    }

}
