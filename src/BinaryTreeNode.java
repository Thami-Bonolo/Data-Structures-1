/**
 *
 * @author bonolo
 * Binary Tree Node class, AVL and Binary will inherit methods from it
 */
public class BinaryTreeNode {
    Data data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode root;
    int height;
    
    //Constructor
    public BinaryTreeNode(){
        root = null;
    }
    public BinaryTreeNode (Data data, BinaryTreeNode left, BinaryTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public void visit(BinaryTreeNode node){
        System.out.println(node.data);
    }
    
    public void preOrder(){
        preOrder(root);
    }
    
    public void preOrder(BinaryTreeNode node){
        if(node!=null){
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    //Method to get height of tree
    public int getHeight(){
        return getHeight(root);
    }
    
    private int getHeight(BinaryTreeNode node){
        if (node == null){
            return -1;
        }
        else{
            return 1 + Math.max(getHeight(node.left),getHeight(node.right));
        }
    }
}
