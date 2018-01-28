package LinkedList;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head  == null)
            return null;

        ListNode temp = new ListNode(0);
        temp.next = head;


        ListNode first = temp;
        ListNode second = temp;

        for(int i=1; i<=n+1; i++){
            if(first == null)
                return null;
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return temp.next;

    }
}
