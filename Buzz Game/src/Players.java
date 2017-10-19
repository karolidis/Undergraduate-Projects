/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Κωνσταντινος
 */
public class Players {
    
    int counter ;
    private String s1,s2,s3;
    private final ArrayList<Player> Paixtes;
    
    Players() throws FileNotFoundException, IOException
    {
        
        Paixtes = new ArrayList<>();
        
        BufferedReader in = new BufferedReader(new FileReader ("statistics.txt")); 
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
                }
            } 
            
            Player P = new Player(s1,s2,s3);
            Paixtes.add(P);
            
        }
       
}
    
    public ArrayList<Player> getPlayers(){
     return Paixtes;
         
     }

}
