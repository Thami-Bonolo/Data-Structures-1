/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bonolo
 * Main file for BST
 */
public class PowerBSTApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ScanBST BST = new ScanBST("cleaned_data.csv");
        if(args.length == 0){
            BST.printAllDateTimes();
        }
        else{
        BST.printDateTime(args[0]);
        }
    }
    
}
