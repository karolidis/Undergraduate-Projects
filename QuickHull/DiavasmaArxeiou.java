/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject1;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Karol
 * 
 */
public class DiavasmaArxeiou 
{
    ArrayList<Point> att = new ArrayList<Point>(); // in this ArrayList will be stored the coordinates of initial and final position.
    ArrayList<Point> tn = new ArrayList<Point>(); // in this ArrayList will be stored the coordinates of initial position,final position and all mines's coordinates.
    ArrayList<Integer> aa = new ArrayList<Integer>(); // in this ArrayList will be stored the numbers of file's content. 
   
    public int diamantia; // in this parameter is stored the number of diamonds.

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
        
        /**
         * The following while loop stores in ArrayList aa the numbers of file's content.
         */
        while (scanner.hasNextInt()) 
        {  
            aa.add(scanner.nextInt());    
        }
        
        diamantia=aa.get(4); //with this command we store in parameter 'diamantia' the number of the diamonds.
        aa.remove(4);
        
        /**
         * The following for loop stores in ArrayList att the coordinates of initial and final position.
         * It is also stores in ArrayList tn the coordinates of initial position,final position 
         * and all mines's coordinates.
         */
        for(int i=0 ; i < aa.size() ; i=i+2)
        {
            Point temp_point = new Point( aa.get(i) , aa.get(i+1));
            
            if(i <= 2)
            {
               att.add(temp_point); 
            }
              
            tn.add(temp_point);  
            
        }
        
    }
    
    /**
     *
     * @return This function returns the ArrayList att.
     */
    public ArrayList<Point> GetArxikiKaiTelikiThesi()
    {
        return att;
    }
    
    /**
     *
     * @return This function returns the ArrayList tn.
     */
    public ArrayList<Point> GetTheseisNarkon()
    {
        return tn;
    }

    /**
     *
     * @return This function returns the number of diamonds.
     */
    public int GetPlithosDiamantion()
    {
        return diamantia;
    }
    
}
