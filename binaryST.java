import java.util.*;

/*
 * Binary Tree Implementation
 * Functions Here
 * 1.CreateNewNode(int val);
 * 2.insert(Node, int);
 * 3.inorder(Node)
 * 4.preorder(Node)
 * 5.postorder(Node)
 * 6.isPresent(Node, int)
 * 7.getparentNode(Node, int)
 * 8.getSibling(Node, int)
 * 9.getInOrderParent(Node, int)
 * 10.getInOrderSuccessor(Node, int)
 * 11.getSuccessor(Node, int)
 * 12.getDiffEvenOddLevel(Node)
 * 13.getMaxValue(Node)
 * 14.getMinValue(Node)
 * 15.getTreeByPreInOrder(int[] preorder, int[] inorder)
 * 16.getTreeByPostInOrder(int[] postorder, int[] inorder)
 * 17.getTreeByPrePostOrder(int[] preorder, int[] postorder)
 * 18.Print2DUtil method
 * 19.DeleteNode(Node , int)
 *
 * */


public class binaryST {
    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;
        root = bst.insert(root, 8);
        root = bst.insert(root, 6);
        root = bst.insert(root, 10);
        root = bst.insert(root, 13);
        root = bst.insert(root, 9);
        root = bst.insert(root, 9);
        //root = bst.insert(root, 8);
        root = bst.insert(root, 14);
        root = bst.insert(root, 7);
        root = bst.insert(root, 7);
        root = bst.deleteNode(root, 20);

        //In-Order Printing
        bst.inorder(root);
        System.out.println();

        //Pre-Order Printing
        bst.preorder(root);
        System.out.println();

        //Post-Order printing
        bst.postorder(root);
        System.out.println();

        //Finding a value in a BST
        System.out.println(bst.isPresent(root, 10));

        //Finding Parent Node of a child
        Node parentNode = bst.getParentNode(root, 10);
        if(parentNode != null) {
            System.out.println(parentNode.data);
        }else {
            System.out.println("Parent Node does not exist.");
        }

        //Finding sibling of a given sibling
        Node mySibling = bst.getSibling(root, 13);
        if(mySibling != null) {
            System.out.println(mySibling.data);
        }else {
            System.out.println("No Sibling Present.");
        }

        //IN-ORDER Parent
        Node InOrderParent = bst.getInOrderParent(root, 9);
        if(InOrderParent != null) {
            System.out.println(InOrderParent.data);
        }else {
            System.out.println("Inorder-Parent not exist.");
        }

        //IN-ORDER SUCCESSOR
        Node inorderSuccessor = bst.getInorderSuccessor(root, 6);
        if(inorderSuccessor != null) {
            System.out.println(inorderSuccessor.data);
        }else {
            System.out.println("No InOrder-Succesor exist");
        }

        //Get difference even odd level
        System.out.println(bst.getDiffEvenOddLevel(root));

        //Get Max value in bst
        System.out.println(bst.getMaxValue(root));
        System.out.println(bst.getMinValue(root));

        //Constructing binary tree from PreOrder and In-Order sequence given T(n) = O(n)
        BST bst2 = new BST();
        int[] preorder = {8, 6, 7, 10, 9, 13, 14};
        int[] inorder = {6, 7, 8, 9, 10, 13, 14};
        Node root2 = bst2.getTreebyPreInOrder(preorder, inorder);
        bst2.postorder(root2);
        System.out.println();

        //O(n^2) Time Complexity Now
        Node root3 = bst2.getTreeByRecursivePreIn(preorder, inorder, 0, preorder.length - 1);
        bst2.postorder(root3);
        System.out.println();

        //Tree from Post-Order and In-Order
        int[] postorder = {7, 6 ,9, 14, 13, 10, 8};
        Node root4 = bst2.getTreeByRecursivePostIn(postorder, inorder, 0, inorder.length - 1);
        bst2.preorder(root4);
        System.out.println();

        //Printing 2D tree
        //bst2.print2DUtil(root, 0);

        //Construct binary tree from postOrder and preOrder
        int[] preOrder = {8, 6, 7, 10, 9, 13, 14};
        int[] postOrder = {7, 6, 9, 14, 13, 10, 8};
        Node root5 = bst2.getTreeByPrePost(preOrder, postOrder, 0, preOrder.length - 1);
        bst2.preorder(root5);
        System.out.println();

        Node nd = bst.deleteNode(root, 9);
        //System.out.println(nd.data);
        bst.inorder(root);
        System.out.println();

        System.out.println(bst.isLeaf(root));
        System.out.println(bst.getHeight(root));

        System.out.println(bst.isBST(root5));

    }
}

class BST{

    //isLeaf()

    public int isBST(Node root) {
        if(ifBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return 1;
        }else {
            return 0;
        }
    }

    private static boolean ifBST(Node root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }else if(root.data < minValue || root.data > maxValue) {
            return false;
        }
        return ifBST(root.left, minValue, root.data) && ifBST(root.right, root.data, maxValue);
    }


    public boolean isLeaf(Node root) {
        if(root.right == null && root.left == null || root == null) {
            return true;
        }
        return false;
    }

    public int getMax(int x, int y) {
        return x > y ? x: y;
    }

    public int getHeight(Node root) {
        if(root == null || isLeaf(root)) {
            return 0;
        }
        return getMax(getHeight(root.left) , getHeight(root.right) + 1);
    }

    //Node root = new Node();
    public Node createNewNode(int val) {
        Node root = new Node();
        root.data = val;
        root.left = null;
        root.right = null;
        return root;
    }
    public Node insert(Node root, int val) {
        if(root == null) {
            return createNewNode(val);
        }
        if(val < root.data) {
            root.left = insert(root.left, val);
        }else if(val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Get minimum element in binary search tree
    public static Node minimumElement(Node root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }

    public Node deleteNode(Node root, int value) {
        if (root == null)
            return null;
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Node temp = root;
                // Finding minimum element from right
                Node minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }

    //IN-ORDER PRINTING
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //PRE ORDER PRINTING
    public void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //POST-ORDER PRINTING
    public void postorder(Node root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public boolean isPresent(Node root, int val) {
        if(root == null) {
            return false;
        }

        while(root != null) {
            if(val < root.data) {
                root = root.left;
            }else if(val > root.data) {
                root = root.right;
            }else {
                return true;
            }
        }
        return false;
    }

    //Getting Parent Node
    public Node getParentNode(Node root, int val) {
        if(root == null) {
            return null;
        }else if(root.data == val) {
            return null;
        }else {
            while(root != null) {
                if(root.data < val && root.right != null) {
                    //root = root.right;
                    if((root.right).data == val) {
                        return root;
                    }
                    root = root.right;
                }else if(root.data > val && root.left != null) {
                    if((root.left).data == val) {
                        return root;
                    }
                    root = root.left;
                }
                else {
                    return null;
                }
            }
            return null;
        }
    }

    //Getting Sibling
    public Node getSibling(Node root, int val) {
        if(root == null) {
            return null;
        }else if(root.data == val) {
            return null;
        }else {
            while(root != null) {
                if(root.data < val && root.right != null) {
                    if((root.right).data == val) {
                        return root.left;
                    }
                    root = root.right;
                }else if((root).data > val && root.left != null) {
                    if((root.left).data == val) {
                        return root.right;
                    }
                    root = root.left;
                }else {
                    return null;
                }
            }
            return null;
        }
    }

    //Getting inOrderParent
    public Node getInOrderParent(Node root, int val) {
        if(root == null) {
            return null;
        }

        Node inorderParent = null;

        while(root != null) {
            if(val < root.data) {
                inorderParent = root;
                root = root.left;
            }else if(val > root.data) {
                root = root.right;
            }else {
                break;
            }
        }

        return root != null ? inorderParent : null;
    }

    //Getting inorderSuccessor
    public Node getInorderSuccessor(Node root, int val) {
        if(root == null) {
            return null;
        }
        Node inorderSuccessor = null;

        while(root != null) {
            if(val < root.data) {
                inorderSuccessor = root;
                root = root.left;
            }else if(val > root.data) {
                root = root.right;
            }else {
                if(root.right != null) {
                    inorderSuccessor = getSuccessor(root);
                }
                break;
            }
        }

        return root != null ? inorderSuccessor : null;
    }

    private Node getSuccessor(Node root) {
        if(root == null) {
            return null;
        }

        Node temp = root.right;
        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    //Getting difference of even odd level
    public int getDiffEvenOddLevel(Node root) {
        if(root == null) {
            return 0;
        }
        return root.data - getDiffEvenOddLevel(root.left) - getDiffEvenOddLevel(root.right);
    }

    //Getting maximum value in tree
    public int getMaxValue(Node root) {
        if(root == null) {
            System.out.println("Tree is Empty.");
            return -1;
        }

        while(root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    //Getting minimum value in tree
    public int getMinValue(Node root) {
        if(root == null) {
            System.out.println("Tree is Empty.");
            return -1;
        }
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public Node getTreebyPreInOrder(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private Node helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> map) {
        if(pLeft > pRight || iLeft > iRight) {
            return null;
        }
        int i = map.get(preorder[pLeft]);
        Node temp = new Node();
        temp.data = preorder[pLeft];
        temp.left = helper(preorder, pLeft +1, pLeft + i - iLeft, inorder, iLeft, i - 1, map);
        temp.right = helper(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight, map);

        return temp;
    }

    static int aIndex = 0;
    public Node getTreeByRecursivePreIn(int[] preorder, int[] inorder, int i, int j) {
        if(i > j) {
            return null;
        }

        Node temp = new Node();
        temp.data = preorder[aIndex];aIndex++;

        if(i == j) {
            return temp;
        }
        int indexInOrder = find(inorder, i, j, temp.data);

        temp.left = getTreeByRecursivePreIn(preorder, inorder, i, indexInOrder - 1);
        temp.right = getTreeByRecursivePreIn(preorder, inorder, indexInOrder + 1, j);
        return temp;
    }

    private int find(int[] inorder, int i, int j, int value) {
        int x = 0;
        for(int k = i; k <= j; k++) {
            if(inorder[k] == value) {
                x = k;
                break;
            }
        }
        return x;
    }

    static int aindex = 0;
    public Node getTreeByRecursivePostIn(int[] postorder, int[] inorder, int i, int j) {
        if(i > j) {
            return null;
        }

        Node temp = new Node();
        temp.data = postorder[inorder.length - 1 - aindex];aindex++;

        if(i == j) {
            return temp;
        }
        int indexInOrder = find(inorder, i, j, temp.data);

        temp.right = getTreeByRecursivePostIn(postorder, inorder, indexInOrder + 1, j);
        temp.left = getTreeByRecursivePostIn(postorder, inorder, i, indexInOrder - 1);
        return temp;
    }

    static int COUNT = 10;
    public void print2DUtil(Node root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    static int cnt = 0;
    public Node getTreeByPrePost(int[] preorder, int[] postorder, int iS, int jE) {
        if(iS > jE || cnt >= preorder.length) {
            return null;
        }
        Node temp = new Node();
        temp.data = preorder[cnt];
        cnt++;
        if(iS == jE || cnt >= preorder.length) {
            return temp;
        }
        int i;
        for(i = iS; i <= jE; i++) {
            if(postorder[i] == preorder[cnt]) {
                break;
            }
        }
        if(i <= jE) {
            temp.left = getTreeByPrePost(preorder, postorder, iS, i);
            temp.right = getTreeByPrePost(preorder, postorder, i+1, jE);
        }

        return temp;
    }

}

class Node{
    int data;
    Node left;
    Node right;
}


















