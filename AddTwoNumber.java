public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode node1, ListNode node2){
        ListNode node = null;
        int result = NumConverterFromLinkedList(node1, node2);
        int n = String.valueOf(result).length();
        while (n > 0){
            int digit = result%10;
            result /= 10;
            ListNode nodeNext = new ListNode(digit);
            node.next = nodeNext;
            n--;
        }
        return node;
    }

    public static int NumConverterFromLinkedList(ListNode node1, ListNode node2){
        String s = "", s2 = "";
        while (node1 != null){
            s += String.valueOf(node1.val);
            node1 = node1.next;
        }
        while (node2 != null){
            s2 += String.valueOf(node2.val);
            node2 = node2.next;
        }
        String st = "";
        for(int i = s.length() - 1; i >= 0; i++){
            st += s.charAt(i);
        }
        String st2 = "";
        for(int i = s2.length()-1; i >= 0; i++){
            st2 += s2.charAt(i);
        }
        return Integer.parseInt(st) + Integer.parseInt(st2);
    }

    public static void main(String[] args){

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
