public class FlattenBinaryTreeToLinkedList {
    public static void flattenMyBinaryTreeToLinkedList(Node node){
        if(node == null)
            return;
        System.out.print(node.data + " ");
        flattenMyBinaryTreeToLinkedList(node.left);
        flattenMyBinaryTreeToLinkedList(node.right);
        return;
    }

    public static void flatten(Node node){
        flatMyBinaryTree(node);
    }
    private static Node flatMyBinaryTree(Node node){
        if(node == null)
            return null;
        Node left = flatMyBinaryTree(node.left);
        Node right = flatMyBinaryTree(node.right);
        if(left == null)
            node.right = right;
        else {
            return node;
        }
        return node;
    }

    public static void main(String[] args){
        flattenMyBinaryTreeToLinkedList(null);                                              //Printing value of Linked List

    }
}


