/*
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
 */

public class MergeTwoSortedList {

    public static ListNode mergeTwoSortedLinkedList(ListNode first, ListNode second){
        if(first == null)
            return second;
        if(second == null)
            return first;
        ListNode node = null;
        while (first.next != null && second.next != null){
            if(first.val < second.val){
                ListNode temp = new ListNode(first.val);
                node.next = temp;
                node = node.next;
                first = first.next;
            }else{
                ListNode temp = new ListNode(second.val);
                node.next = temp;
                node = node.next;
                second = second.next;
            }
        }
        while (first.next != null){
            ListNode temp = new ListNode(first.val);
            node.next = temp;
            node = node.next;
        }
        while (second.next != null){
            ListNode temp = new ListNode(second.val);
            node.next = temp;
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args){
        mergeTwoSortedLinkedList(null, null);
    }
}
