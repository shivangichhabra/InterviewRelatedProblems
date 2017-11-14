package LinkedList;

/**
 * Created by Shivangi on 10/22/2017.
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head != null){
            ListNode odd  = head;
            ListNode even = head.next;
            ListNode evenHead = even;

            while(odd.next != null && even.next != null){
                odd.next = odd.next.next;
                odd = odd.next;

                even.next = even.next.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
