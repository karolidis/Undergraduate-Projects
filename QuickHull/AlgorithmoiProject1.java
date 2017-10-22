/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject1;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Karol
 */
public class AlgorithmoiProject1 
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException 
    {    
 
        DiavasmaArxeiou file = new DiavasmaArxeiou();
        file.GetFileContent();
        
        QuickHullAlgorithm plegma = new QuickHullAlgorithm();
        
        ArrayList<Point> convexhull ; // in this ArrayList will be stored the coordinates of the points that make up the convexhull.
        
        convexhull = plegma.quickHull(file.GetTheseisNarkon(),file.GetArxikiKaiTelikiThesi());

        ArrayList<Point> monopati ; // in this ArrayList will be stored the coordinates of the points that make up the shortest path.
        
        YpologismosMonopatiou path = new YpologismosMonopatiou();
        
        monopati = path.EuresiMonopatiou(convexhull,file.GetArxikiKaiTelikiThesi());
        
        System.out.println("The shortest distance is " + path.MikroteroMegethosMonopatiou());
        
        System.out.print("The shortest path is: ");
        for (int i=0 ; i < monopati.size(); i++)
        {
            if(i == 0)
            {
                System.out.print("(" + monopati.get(i).x + "," + monopati.get(i).y + ")");
            }
            else
            {
                System.out.print("-->(" + monopati.get(i).x + "," + monopati.get(i).y + ")");
            }
        }
        
        YpologismosZygismaton zygismata = new YpologismosZygismaton();
        zygismata.counter(file.GetPlithosDiamantion());
        
    }
}
    
        

    

