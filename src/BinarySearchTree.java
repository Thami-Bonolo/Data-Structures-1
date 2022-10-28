/**
 *
 * @author bonolo
 */
public class BinarySearchTree extends BinaryTreeNode {
    int insertionCount;
    
    public BinarySearchTree(){
        root = null;
    }
    
    //Method to insert a new node into the BST
    public void insert(Data data){
        //If the tree is empty, insert at root
        insertionCount = 0;
        if(root == null){
            root = new BinaryTreeNode (data, null, null);
        }
        else{
            //call a method that will recur down the tree searching for an empty node
            insert(data, root);
        }
    }
    //This method recurs down the BST searching for an empty node
    public void insert(Data data, BinaryTreeNode node){
        insertionCount++;
        if(data.date.compareTo(node.data.date) < 0){
            if(node.left == null){
                node.left = new BinaryTreeNode (data, null, null);
            }
            else{
                insert(data,node.left);
            }
        }
        else{
            if(node.right == null){
                node.right = new BinaryTreeNode (data, null, null);
            }
            else{
                insert(data, node.right);
            }
        }
    }
    
    public BinaryTreeNode find(String date){
        //Tree is empty or has data
        if (root == null){
            return null;
        }
        else{
            return find(date, root);
        }
    }
    
    //Method searches a given date in the BST
    public BinaryTreeNode find(String date, BinaryTreeNode node){
        //base case, if node is found then return
        if (date.compareTo(node.data.date) == 0){
            return node;
        }
        //else recur down the tree to search for node
        else if(date.compareTo(node.data.date) < 0){
            return (node.left == null) ? null : find(date, node.left);
        }
        else{
            return (node.right == null) ? null : find(date, node.right);
        }
    }
    
    //to operation counts or how many times the BST performs comparisons on data.
    public int opCount(String date){
        if(root == null){
            return 0;
        }
        else{
            return opCount(date, root);
        }
    }
    
    //A modified "find" method, which is now used to count operations
    public int opCount(String date, BinaryTreeNode node){
        if(date.compareTo(node.data.date) == 0){
            return 1;
        }
        else if(date.compareTo(node.data.date) < 0){
            if (node.left == null){
                return 1;
            }
            else{
                return 1 + opCount(date, node.left);
            }
        }
        else{
            if (node.right == null){
                return 1;
            }
            else{
                return 1 + opCount(date, node.right);
            }
        }
    }
    
    public int getInsertionCount(){
        return insertionCount;
    }
}
