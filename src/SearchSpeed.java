
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bonolo
 * Main class for our speed comparison program for part 5
 */
public class SearchSpeed {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        File file = new File("Search_speed_results.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Size of data, AVLTree Speed, BST Speed");
        bw.newLine();
        
        DataSubset results = new DataSubset();
        for(int i=1; i<=500; i++){
            results.DataSubset(i);
            ScanAVL avl = new ScanAVL("subset_data.csv");
            ScanBST bst = new ScanBST("subset_data.csv");
            String date = avl.date;
            bw.write(i + ",");
            bw.write(avl.avl.opCount(date) + ",");
            bw.write(bst.BST.opCount(date) + ",");
            bw.newLine();
        }
        bw.close();
    }
    
}
