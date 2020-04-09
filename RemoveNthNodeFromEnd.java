/*
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
 */


public class RemoveNthNodeFromEnd {
    public static ListNode removeNthfromEnd(ListNode head, int n){
        if(head == null || head.next == null)
            return null;
        if((head.next.next == null && n == 1))
            return null;
        ListNode prev = head;
        ListNode next = head;
        while (n > 0) {
            next = next.next;
            n--;
        }
        while (next.next != null){
            prev = prev.next;
            next = next.next;
        }
        next = prev.next;
        prev.next = next;
        return head;
    }

    public static void main(String[] args){
        removeNthfromEnd(null, 0);
    }
}

