
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author bonolo
 * This class reads "cleaned_data.csv" and inserts the data into the BST
 */
public class ScanBST {
    File file;
    Data data;
    BinarySearchTree BST = new BinarySearchTree();
    String date, power, voltage;
    
    //reads file in a given directory
    public ScanBST(String directory){
        file = new File(directory);
        try{
            Scanner datas = new Scanner(file);
            datas.next();
            int num = 1;
            while(datas.hasNext()){
                String data2 = datas.next();
                Scanner data3 = new Scanner(data2);
                data3.useDelimiter(",");
                date = data3.next();
                power = data3.next();
                data3.next();
                voltage = data3.next();
                BST.insert(new Data(date, power, voltage));
                /*if(num > 489){
                System.out.println("Insertion Count for node "+num + " = "+BST.getInsertionCount());
                }*/
                num++;
            }
            datas.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    //this methos travers through the BST and prints all the node in Pre Order.
    public void printAllDateTimes(){
        BST.preOrder();
    }
    
    //This method searches for a given date and prints the data associated with it
    public void printDateTime(String dateTime){
        
        if(BST.find(dateTime) != null){
            System.out.println(BST.find(dateTime).data);
            System.out.println("Number of comparisons " + BST.opCount(dateTime));
            return;
        }
        System.out.println("Date/time not found");
        System.out.println("Number of comparisons " + BST.opCount(dateTime));
    }
}
