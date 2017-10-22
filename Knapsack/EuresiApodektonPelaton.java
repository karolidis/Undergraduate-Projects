/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject2;

import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class EuresiApodektonPelaton 
{
    /*
     * This function is called to find and print the accepted clients.
     */
    void ApodektoiPelates(ArrayList<Integer> cac,ArrayList<Double> ptp,int SPE)
    {
        int row = cac.size();
        int col = SPE ;
        
        double [][] T = new double [row][col+1];
        
        /*
         * The following for loop set as 0 the value of all cells of the first column of table T.   
         */
        for(int i = 0 ; i < row ; i++)
        {
            T[i][0] = 0 ;
        }
       
        /*
         * The following loop fills the table T using the knapsack algorithm.I wrote the code for knapsack algorithm watching this video "https://www.youtube.com/watch?v=8LusJS5-AGo" and studying my notes from the lectures.
         * For every row we act like this : If the number of columns is smaller than the customer's asking cores we fills the 
         * cells with value 0 if we are filling the row 0 or we fill the cells with value of the above cell(the cell in the previous row and in the same column)
         * if we are filling the next rows.If the number of columns is bigger than the customer's asking cores we fill the cells with value "val"(customer's asking cores * price that customer offers for a core)
         * if we are filling the row 0 or we fill the cells with the max value of {Value of the above cell , Value of the cell in previous row and in column = column - customer's asking cores} if we are filling the next rows.
         */
        for(int i = 0 ; i < row ; i++) 
        {
            for(int j = 1 ; j < col+1 ; j++) 
            {
                int wt = cac.get(i);
                double temp = ptp.get(i);
                double val = wt * temp ;
                
                if(j < wt)
                {
                    if(i == 0)
                    {
                        T[i][j] = 0 ;
                    }
                    else
                    {
                        T[i][j] = T[i-1][j] ;
                    }
                }
                else
                {
                    if(i == 0)
                    {
                        T[i][j] = val ;
                    }
                    else
                    {
                        T[i][j] = Math.max(T[i-1][j],T[i-1][j-wt]+val);
                    }
                }
                
            }
        }
        
        int [] selected = new int [row]; // using this table we will find the accepted clients.
        
        
        /*
         * The following for loop set as 0 the value of all cells of table selected.   
         */
        for(int i = 0 ; i < row ; i++)
        {
            selected[i] = 0 ;
        }
    
        /**
         * The following while loop is used to compare the content of table T cells in order to find the accepted clients.
         */
        while(col > 0)
        {
            if(T[row-1][col]>T[row-2][col])
            {
               selected[row-1]++ ;
               row = row -1 ;
               col = col - cac.get(row);
            }
            else
            {
                row = row - 1 ;
            }
            if(row == 1)
            {
               if(T[0][col] > 0)
               {
                    selected[0]++ ;
                    col = 0 ;
               }
               else
               {
                    col = 0 ;
               }
            }
        }
        
        int counter = 0 ; // int this parameter will be stored the number of the accepted clients.
                          // this will help us in the print procedure.  
        
        /*
         * The following for loop find the number of accepted clients.   
         */
        for(int i = 0 ; i < T.length ; i++)
        {
            if(selected[i] > 0)
            {
                counter++ ;
            }
        }
        
        System.out.printf("\nClients Accepted: ");
        
        /*
         * The following for loop prints the clients that will be accepted.   
         */
        for(int i = 0 ; i < T.length ; i++)
        {
            if(counter > 1)
            {
               if(selected[i] > 0)
                {
                    System.out.printf("%d,",i+1);
                    counter-- ;
                } 
            }
            else
            {
               if(selected[i] > 0)
                {
                    System.out.println(i+1);
                }  
            }
            
        }

        System.out.println("Total amount: " + T[T.length-1][SPE] + "\n");
    }
}
