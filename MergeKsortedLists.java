/*
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
*/

public class MergeKsortedLists {

    public static ListNode mergeKLists(ListNode[] lists){
        ListNode node = null;
        for(int i = 0; i < lists.length; i++){
            ListNode curent = lists[i];
            if(curent == null)
                continue;
            while (node.next != null && curent.next != null){
                if(node.val < curent.val){
                    ListNode temp = new ListNode(node.val);
                    node.next = temp;
                    node = node.next;
                }else{
                    ListNode temp = new ListNode(curent.val);
                    node.next = temp;
                    node = node.next;
                    curent = curent.next;
                }
            }
            while (node.next != null){
                ListNode temp = new ListNode(node.val);
                node.next = temp;
                node = node.next;
            }
            while (curent.next != null){
                ListNode temp = new ListNode(curent.val);
                node.next = temp;
                node = node.next;
                curent = curent.next;
            }
        }
        return node;
    }

    public static void main(String[] args){
        ListNode[] lists = {null, null};
        mergeKLists(lists);
    }
}
