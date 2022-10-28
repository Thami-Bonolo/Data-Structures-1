
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bonolo
 * This program is used for part 5, to generate a substet of "cleaned_data.csv"
 */
public class DataSubset {
    File file = new File("cleaned_data.csv");
    
    public void DataSubset(int num) throws IOException{
        //generating a subset data with "num" of lines given
        File file2 = new File("subset_data.csv");
        if(!file2.exists()){
            file2.createNewFile();
        }
        try{
            FileWriter fw = new FileWriter(file2.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner data = new Scanner(file);
            
            while(data.hasNext() && num >=0){
                bw.write(data.next());
                bw.newLine();
                num--;
            }
            bw.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
