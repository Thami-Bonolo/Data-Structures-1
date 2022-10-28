/**
 *
 * @author bonolo
 */
public class AVLTree extends BinaryTreeNode {
    int insertionCount;
    public AVLTree(){
        root = null;
    }
    
    //Method to get the height of the tree
    public int height(BinaryTreeNode node){
        if(node != null){
           return node.height;
        }
        return -1;
    }
    
    //Method that returns the difference in height btw left and right subtree
    public int balanceFactor(BinaryTreeNode node){
        return height(node.right) - height(node.left);
    }
    
    //Method that updates height
    public void fixHeight(BinaryTreeNode node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
    
    //Method to right rotate the subtree rooted with p
    public BinaryTreeNode rotateRight(BinaryTreeNode p){
        BinaryTreeNode q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }
    
    //Method to left rotate the subtree rooted with q
    public BinaryTreeNode rotateLeft(BinaryTreeNode q){
        BinaryTreeNode p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }
    
    //Method to balance the subtree rooted with p
    public BinaryTreeNode balance(BinaryTreeNode p){
        fixHeight(p);
        insertionCount++;
        if (balanceFactor (p) == 2){
            if(balanceFactor(p.right)<0){
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (balanceFactor(p) == -2){
            if(balanceFactor(p.left)>0){
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }
    
    //Recursive method to insert a node into
    //the subtree and returns a new root of the subtree
    public void insert(Data data){
        insertionCount = 0;
        root = insert (data, root);
    }
    
    private BinaryTreeNode insert(Data data, BinaryTreeNode node){
        
        if (node == null){
            //if the tree is empty, insert at root
            return new BinaryTreeNode(data, null, null);
        }
        insertionCount++;
        //if the tree is not empty then recurs down
        if(data.date.compareTo(node.data.date) < 0){
            node.left = insert(data, node.left);
        }
        else{
            node.right = insert(data, node.right);
        }
        return balance(node);
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