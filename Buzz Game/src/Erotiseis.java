/**
 *  PANAGIOTATOS GEORGIOS AEM 2627
 *  KAROLIDIS THEODOROS AEM 2572
 */
package buzz;

import java.util.ArrayList;

/**
 *
 * @author Karol
 */
import buzz.*;

/**
 *
 * @author Karol
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Karol
 */
public class Erotiseis {

    private final ArrayList<Erotisi> ErotiseisEllinika;
    private final ArrayList<Erotisi> ErotiseisAgglika;
    int counter ;
    String s1,s2,s3,s4,s5,s6,s7,s8 ;
        
    public Erotiseis() throws FileNotFoundException, IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
        ErotiseisEllinika = new ArrayList<>();
        ErotiseisAgglika = new ArrayList<>();
        
        BufferedReader in = new BufferedReader(new FileReader ("erotiseis.txt")); 
        int num = 0;
        String l;
        while ( (l = in.readLine()) != null )
        {
            
            counter = 1 ;
            StringTokenizer defaultTokenizer = new StringTokenizer(l,"_");
            while (defaultTokenizer.hasMoreTokens())
            {
                switch (counter) {
                    case 1:
                        s1 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 2:
                        s2 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 3:
                        s3 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 4:
                        s4 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 5:
                        s5 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 6:
                        s6 = defaultTokenizer.nextToken();
                        counter ++ ;
                        break;
                    case 7:
                        s7 = defaultTokenizer.nextToken();
                        counter ++;
                        break;
                    case 8:
                        s8 = defaultTokenizer.nextToken();
                        break;
                }
            }
            
            num++;
            Erotisi E = new Erotisi(s1,s2,s3,s4,s5,s6,s7,s8);
            if(num%2 == 1)
            {
                ErotiseisEllinika.add(E);
            }
            else
            {
                ErotiseisAgglika.add(E);
            }
                            
        }
    } 
    
     public ArrayList<Erotisi> getErotiseis(int k){
         if(k==0){
        return ErotiseisEllinika;
    }else {
             return ErotiseisAgglika;
         }
         
     }
}