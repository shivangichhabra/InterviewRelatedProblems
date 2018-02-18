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

    public static void main(String args[]){
        ReverseBetween rb = new ReverseBetween();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next= new ListNode(5);
        ListNode temp = l;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println("\n------------------------");
        ListNode head = rb.reverseBetween(l, 1, 4);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
