/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject2;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */

public class EuresiElaxistouPlithousVM 
{
    private int int_max = 2147483647;
    
    
    /*
     * This function is called to find and print the exact number of every category of cores that every customer needs.
     */
    void ElaxistosArithmosPyrinon(int cof[], int m , ArrayList<Integer> cac) // cof = categories of cores cac = customer's asking cores
    {    
        /*
         * The following for loop is use to find and print the exact numbers of cores for every customer's need.
         */
        for(int i=0 ; i < cac.size() ; i++)
        {
            int V = cac.get(i);  // V = customer's asking cores
            int [][] Table = new int [m][V+1];
             
            /*
            * The following for loop set as 0 the value of all cells of the first column of Table.
            */
            for(int k = 0 ; k < m ; k++)
            {
                Table[k][0] = 0 ;
            }
            
            /*
            * The following for loop fills the Table using the Coin-Change algorithm.I wrote this algorithm using my notes from the lectures.
            * For every row we act like this : If the number of columns is smaller than the customer's asking cores we fills the
            * cells with value "int_max" if we are filling the row 0 or we fill the cells with value of the above cell(the cell in the previous row and in the same column)
            * if we are filling the next rows.If the number of columns is bigger than the customer's asking cores we fill the cells with value "int_max" or with the value "columns / customer's asking cores"
            * if we are filling the row 0 or we fill the cells with the min value of {Value of the above cell , Value of the cell in the same row and in column = column - customer's asking cores +1 } if we are filling the next rows.
            */
            for(int j = 0 ; j < m ; j++)
            {
                for(int k = 1 ; k < V+1 ; k++)
                {
                    if(k < cof[j] )
                    {
                        if(j == 0)
                        {
                           Table[j][k] = int_max ;  
                        }
                        else
                        {
                           Table[j][k] = Table[j-1][k];
                        }
                    }
                    else
                    {
                        if(j == 0)
                        {
                            if(k%cof[0] == 0)
                            {
                                Table[j][k] = k / cof[0] ;  
                            }
                            else
                            {
                                Table[j][k] = int_max ;
                            }
                        }
                        else
                        {
                            Table[j][k] = Math.min(Table[j-1][k],Table[j][k-cof[j]]+1);
                        }
                    }
                } 
            }
            
            int [] Counter = new int [m]; // using this table we will find the number of cores that satisfy the needs of every customer  
             
            /*
             * The following for loop set as 0 the value of all cells of table Counters.   
             */
            for(int k = 0 ; k < m ; k++)
            {
                Counter[k] = 0 ;
            }    
            
            int x = m ;
            
            /**
             * The following while loop is used to compare the content of Table cells in order to find the exact number of every category of cores 
             * that will be necessary to satisfy the customer's need.
             */
            while(V > 0)
            {
                if(Table[x-1][V]<Table[x-2][V])
                {
                   Counter[x-1]++ ;
                   V = V - cof[x-1];
                }
                else
                {
                    x = x - 1 ;
                }
                if(x == 1)
                {
                    Counter[0]++ ;
                    V=0;
                }
            }        
            
            System.out.println("Client " + (i+1) + ": " + Counter[0] + " 1-core, " + Counter[1] + " 2-core, " + Counter[2] + " 7-core and " + Counter[3] + " 11-core VMs");
       
        }
    }       
}
