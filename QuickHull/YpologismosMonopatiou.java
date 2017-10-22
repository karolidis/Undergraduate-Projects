/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject1;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class YpologismosMonopatiou 
{
    private ArrayList<Point> monopati1 = new ArrayList<Point>() ; // in this ArrayList will be stored the coordinates of the points that make up the monopati1.
    private ArrayList<Point> monopati2 = new ArrayList<Point>() ; // in this ArrayList will be stored the coordinates of the points that make up the monopati2.
    private double mm1=0; // size of monopati1
    private double mm2=0; // size of monopati2
     
    /**
    *
    * @return This function returns an ArrayList,which includes the coordinates of the points that make up
    *         the shortest path.
    */
    ArrayList<Point> EuresiMonopatiou(ArrayList<Point> mines, ArrayList<Point> att)  
    {
        
        Point te  = new Point(att.get(0).x,att.get(0).y); // coordinates of initial position
        Point tt  = new Point(att.get(1).x,att.get(1).y); // coordinates of final position
 
        boolean flag=true;
        int metritis=0; // in this parameter we will store the number of points that make up the 'monopati2' without including the final position.

        /**
         * The following for loop calculates the 'monopati1'.
         * It is also calculates the number of points that make up the 'monopati2' without including the 
         * final position
         */
        for(int i=0 ; i<mines.size() ; i++)
        {
            Point temp_point  = new Point(mines.get(i).x, mines.get(i).y);
       
            if(temp_point.x == te.x && temp_point.y == te.y )
            {
                flag = false;
               
            }
           
            if(flag == true)
            {
                metritis++;
            }
            else
            {
                monopati1.add(temp_point);
            }
            
        }
        
        /**
         * The following for loop calculates the 'monopati2' without including the final position.
         */
        for (int t=metritis; t>=0; t--)
        {
            Point temp_point  = new Point(mines.get(t).x, mines.get(t).y);
            monopati2.add(temp_point);
       
        }
        monopati2.add(tt); // with this command we add the final position to the 'monopati2'.

        /**
        * The following for loop calculates the size of 'monopati1'.
        */
        for (int i=1 ; i< monopati1.size() ; i++  )
        {
            double apostasi= Math.sqrt(Math.pow ((monopati1.get(i).x-monopati1.get(i-1).x), 2) + Math.pow( monopati1.get(i).y - monopati1.get(i-1).y, 2)) ;
            mm1 = mm1 +apostasi;
        }
              
        /**
        * The following for loop calculates the size of 'monopati2'.
        */
        for (int i=1 ; i< monopati2.size() ; i++  )
        {
            double apostasi= Math.sqrt(Math.pow ((monopati2.get(i).x-monopati2.get(i-1).x), 2) + Math.pow( monopati2.get(i).y - monopati2.get(i-1).y, 2)) ;  
            mm2 = mm2 + apostasi;
        }
         
        if ( mm1 < mm2 )
        {
            return monopati1;
        }
        else 
        {
            return monopati2;
        }
        
    }

    /**
     *
     * @return This function return the size of the shortest path. 
    */
    public double MikroteroMegethosMonopatiou()
    {
        if ( mm1 < mm2 )
        {
            return mm1;
        }
        else 
        {
            return mm2;
        }
    }
   
}
