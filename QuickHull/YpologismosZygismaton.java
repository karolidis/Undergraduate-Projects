/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject1;

import java.util.Random;

/**
 *
 * @author Karol
 */
public class YpologismosZygismaton 
{
     
    public static int count = 0; //in this parameter will be saved the number of weighings.
    
    /**
    * This function compares tha weighs of two parts.If one part is heavier than the other one the 
    * function returns 1 or -1.If the weights of the two parts are equal the function returns 0.
    */
    int zygos()
    {
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(100);
        if (x<34)
        {
            return 1; 
        }
        else if (x < 67)
        {
            return 0; 
        }
        else
        {
            return -1; 
        }
        
    }
     
    /**
    * This function calculates the number of weighings.
    * If we have 3 or more diamonds we split them in three parts like: 
    * part1 = number of diamonds / 3
    * part2 = number of diamonds / 3
    * part3 = (number of diamonds / 3)+(number of diamonds % 3)
    * Then we do a weigh.In the weigh we compare part1 and part2.If one part is heavier than the other 
    * we call the function in recursion using as a parameter the part=part1=part2.If the weights of the 
    * two parts are equal we call the function in recursion using as a parameter the part=part3.
    * Because we split in three parts we have log3(n) complexity,which is equal to log(n) complexity.
    * If we have 2 diamonds we do one more weigh to find the fake diamond and we return the number of weighings.
    * If we have 1 diamond we return the number of weighings.
    */
    void counter(int ad) // ad --> number of diamonds
    {
       
        if (ad == 1) 
        {
            System.out.println();
            System.out.println("Number of weightings: " + count);
            System.exit(0);  
        }    
       
       
        if(ad == 2)
        {
            count++;
            System.out.println();
            System.out.println("Number of weightings: " + count);
            System.exit(0);
        }
       
        int ypoloipo = ad % 3 ;   
        int part1 = ad / 3 ;
        int part2 = ( ad / 3 ) + ypoloipo ;
                
        count++;
        
        int x = zygos();
                
        if(x == 1 || x== -1)
        {
            counter(part1);
        } 
        else
        {
            counter(part2);
        }
 
   }
}
