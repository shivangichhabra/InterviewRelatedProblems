package LinkedList;

public class SwapNode {

    /*
    Input  a->b->c->d->null
    Output b->a->d->c->null
     */
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;

        return n;
    }

}
