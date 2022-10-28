/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonolo
 * Main File for AVLTree
 */
public class PowerAVLApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ScanAVL avl = new ScanAVL("cleaned_data.csv");
        if(args.length == 0){
            avl.printAllDateTimes();
        }
        else{
        avl.printDateTime(args[0]);
        }
    }
    
}
