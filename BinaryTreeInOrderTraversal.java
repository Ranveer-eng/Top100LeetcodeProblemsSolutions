import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> inOrderRecursive(TreeNode root){
        if(root == null)
            return list;
        inOrderRecursive(root.left);
        //System.out.println(root.val);
        list.add(root.val);
        inOrderRecursive(root.right);
        return list;
    }

    public static List<Integer> inOrderIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        if(root == null)
            return list;
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args){
        inOrderRecursive(null);
        inOrderIterative(null);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
