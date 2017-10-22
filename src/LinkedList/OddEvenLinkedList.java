package LinkedList;

/**
 * Created by Shivangi on 10/22/2017.
 */
public class OddEvenLinkedList {



    public ListNode oddEvenList(ListNode head) {
        if(head != null){
            ListNode oddHead = head;
            ListNode evenHead = head.next;
            ListNode temp = evenHead;

            while(evenHead != null && evenHead.next != null){
                oddHead.next = oddHead.next.next;
                evenHead.next = evenHead.next.next;
                oddHead = oddHead.next;
                evenHead = evenHead.next;
            }
            oddHead.next = temp;
        }
        return head;

    }
}
