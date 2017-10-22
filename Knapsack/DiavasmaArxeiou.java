/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Karol
 */
public class DiavasmaArxeiou 
{ 
    private ArrayList<Integer> zpap = new ArrayList<Integer>(); // in this ArrayList will be stored the asking cores per customer.
    private ArrayList<Double> ptp = new ArrayList<Double>(); // in this ArrayList will be stored the price that every customer offers for a core.
    private ArrayList<Double> aa = new ArrayList<Double>(); // in this ArrayList will be stored the numbers of file's content. 
   
    private int dpe; // in this parameter is stored the number of all the available cores.
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * This function is used to split in such a way the file contents in three ArrayLists, 
     * which will be useful for the continuation of the program.
     */
    public void GetFileContent() throws FileNotFoundException, IOException
    {
        Scanner scanner = new Scanner(new File("file.txt"));
        scanner.useLocale(Locale.US);
        
        /**
         * The following while loop stores in ArrayList aa the numbers of file's content.
         */
        while (scanner.hasNextDouble()) 
        {  
            aa.add(scanner.nextDouble()); 
        }
        
        double ac = aa.get(0);
        dpe = (int) ac ; //with this command we store in parameter 'dp' the number of all the available cores.
        aa.remove(0);
        
        /*
         * The following for loop stores in ArrayList zpap the asking cores per customer.
         * It is also stores in ArrayList ptp the price that every customer offers for a core.  
         */

        
        for(int i=0 ; i < aa.size() ; i=i+2)
        {
            double temporary = aa.get(i);
            int temp = (int) temporary;
            zpap.add(temp);
            ptp.add(aa.get(i+1));
        }
    }
    
    /**
     *
     * @return This function returns the ArrayList zpap.
     */
    public ArrayList<Integer> GetZitoumenoiPyrinesAnaPelati()
    {
        return zpap;
    }
    
    /**
     *
     * @return This function returns the ArrayList ptp.
     */
    public ArrayList<Double> GetProsferomenesTimesPelaton()
    {
        return ptp;
    }
    
    /**
     *
     * @return This function returns the number of all the available cores.
     */
    public int GetPlithosDiathesimonPyrinon()
    {
        return dpe;
    }                                       
}
