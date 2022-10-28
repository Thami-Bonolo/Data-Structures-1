
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonolo
 */
public class InsertSpeed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        AVLTree avl = new AVLTree();
        BinarySearchTree bst = new BinarySearchTree();
        File file = new File("Insertion_speed_results.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Number of Node, AVL Insertion Speed, BST Insertion Speed");
        bw.newLine();
        
        DataSubset results = new DataSubset();
        for(int i=1; i<=500; i++){
            results.DataSubset(i);
            ScanAVL avl1 = new ScanAVL("subset_data.csv");
            ScanBST bst1 = new ScanBST("subset_data.csv");
            avl.insert(new Data(avl1.date, avl1.power, avl1.voltage));
            bst.insert(new Data(bst1.date, bst1.power, bst1.voltage));
            bw.write(i + ", ");
            bw.write(avl.getInsertionCount()+", ");
            bw.write(bst.getInsertionCount() + ", ");
            bw.newLine();
        }
        bw.close();
    }
    
}
