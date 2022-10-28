
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonolo
 * This class reads "cleaned_data.csv" and inserts the data into the AVL Tree
 */
public class ScanAVL {
    File file;
    Data data;
    AVLTree avl = new AVLTree();
    String date;
    String power;
    String voltage;
    
    //Method to read file in a given directory
    public ScanAVL(String directory){
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
                avl.insert(new Data(date, power, voltage));
                /*if(num < 11){
                System.out.println("Insertion Count for node "+num + " = "+avl.getInsertionCount());
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
        avl.preOrder();
    }
    
    //This method searches for a given date and prints the data associated with it
    public void printDateTime(String dateTime){
        
        if(avl.find(dateTime) != null){
            System.out.println(avl.find(dateTime).data);
            System.out.println("Number of comparisons " + avl.opCount(dateTime));
            return;
        }
        System.out.println("Date/time not found");
        System.out.println("Number of comparisons " + avl.opCount(dateTime));
    }
}
