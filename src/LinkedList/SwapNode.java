package LinkedList;

import java.util.List;

public class SwapNode {

    /*
    Input  a->b->c->d->null
    Output b->a->d->c->null

    still has stackoverflow issues
     */
    public ListNode swapPairsR(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode n = head.next;
        head.next = swapPairsR(head.next.next);
        n.next = head;

        return n;
    }

    /*
    Better solution

    Input  a->b->c->d->null
    Output b->a->d->c->null
     */
    public ListNode swapPairsI(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode current = head;
        ListNode root = head.next;
        while (current != null && current.next != null){
            ListNode next = current.next;  // b = a.next
            ListNode temp = next.next;     // c = b.next
            current.next = temp;           // a.next = c;

            if(prev != null)
                prev.next = next;

            next.next = current;           // b.next = a;
            prev = current;                // null = a;
            current = temp;                // a = b.next/c;
        }

        return root;
    }

}
