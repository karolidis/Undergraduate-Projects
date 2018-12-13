              /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psifiakesepikoinonies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Karol
 */
public class PsifiakesEpikoinonies 
{  
    /**
     * @param args the command line arguments
     */
    
    static int[] DD(int div[],ArrayList<Integer> DOP, int rem[])
    {
        int cur=0;
        while(true)
        {
            for(int i=0;i<DOP.size();i++)
                rem[cur+i]=(rem[cur+i]^DOP.get(i));
           
            while(rem[cur]==0 && cur!=rem.length-1)
                cur++;
   
            if((rem.length-cur)<DOP.size())
                break;
        }
        return rem;
    }
    
    static void chance(Double E,int [] Table ,int counter,int limit)
    {
        Random randomGenerator = new Random();
        Double x = randomGenerator.nextDouble() * limit ;

        if (x < E)
        {
           if(Table[counter] == 1)
           {
               Table[counter] = 0 ;
           }
           else
           {
               Table[counter] = 1 ;
           }
        }    
    }
    
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        
        //Pairno ton plithos ton bits apo ta opoia tha apoteleitai o arithmos
        System.out.print("Doste ton arithmo ton bits apo ta opoia tha apoteleitai o dyadikos arithmos : ");        
        int nob = keyboard.nextInt(); // nob = number of bits 
        
        //Pairno ton arithmo P kai xorizo ta psifia tou
        System.out.print("Doste ton dyadiko arithmo P (to proto kai to teleutaio bit tou arithmou P prepei na einai 1) : ");
        
        int P = keyboard.nextInt();
    
        ArrayList<Integer> DOP = new ArrayList<Integer>(); // DOP = Digits Of P 
                                            
        while(P>0)
        {
            DOP.add(P % 10);
            P /= 10 ;
        }
        
        //Pairno to Bit Error Rate
        System.out.print("Doste to Bit Error Rate : ");
        keyboard.useLocale(Locale.US);
        Double E = keyboard.nextDouble();  
        
        //vrisko posa dekadika psifia exei to BER.auto me voithaei sto na efarmoso sosta tin pithanotita na allakse kapoio apo ta bits.
        String[] splitter = E.toString().split("\\.");
        splitter[1].length();   // Ta dekadika psifia tou arithmou E
        int x=1 ;
        for(int i=0 ; i<splitter[1].length() ;i++)
        {
            x = x * 10;
        }
        E = E * x ;
        
        System.out.print("Doste to plythos ton mynimaton pou thelete na staloun : ");
        int size = keyboard.nextInt();

        int counter1 = 0 ; //ston counter1 apothykeuontai ta mynimata pou fthanoun me sfalma ston apodekti
        int counter2 = 0 ; //ston counter2 apothykeuontai ta mynimata pou anixneuontai os esfalmena apo to CRC
        int counter3 ; //ston counter3 apothykeuontai ta mynimata pou fthanoun me sfalma ston apodekti kai den anixneuontai apo to CRC
        for ( int k = 0 ; k < size ; k++)
        {
            // Dimiourgo enan tyxaio dyadiko arithmo 
            int[] Array1 = new int[nob]; //edo apothikeuontai ta bits tou dyadikou arithmou
        
            Random rg = new Random();  
        
            for(int i = 0 ; i < nob ; i++)
            {
                int temp = rg.nextInt(2) ;
            
                Array1[i] = temp ;
            }
        
            //Dimiourgia pinaka opou tha apothykeutei o dyadikos arithmos akolouthoumenos apo (stoixeiaP-1) midenika
            int length = nob + DOP.size() - 1 ;
        
            int[] Array2 = new int[length]; // // edo apothykeuontai ta bits tou dyadikou arithmou + ta midenika
        
            for(int i = 0 ; i < nob ; i++)
            {            
                Array2[i] = Array1[i] ;
            }
            for(int i = nob ; i < length ; i++)
            {            
                Array2[i] = 0 ;
            }
        
            //Dimiourgia tis akolouthias F (Dimiourgia pinaka ston opoio apothikeuetai to ypoloipo tis diairesis "2nM με τον P")    
            int[] rem1 = new int[length];
            for(int j=0; j<Array1.length; j++)
            {
                rem1[j] = Array1[j];
            }
            rem1=DD(Array1, DOP, rem1);  

            // Dimiourgia tou mynimatos pou thelei na stelei o dektis
            int[] crc1 = new int[length];
            int[] crc2 = new int[length];
        
            for(int i=0;i<Array2.length;i++)  //prosthetei dyadika xoris kratoumeno ton dyadiko arithmos me to ypoloipo
            {
                crc1[i]=(Array2[i]^rem1[i]);
                crc2[i]=(Array2[i]^rem1[i]);
            }        
        
            //Dimiourgia tou mynimatos pou tha lavei o dektis
            for(int i = 0 ; i < crc2.length ; i++)
            {
                chance(E , crc2 , i, x);
            }         
            
            //Ypologismos tou plythous ton mynimaton pou fthanoun me sfalma ston apodekti
            if((Arrays.equals(crc1, crc2)) == false)
            {
                counter1++ ;
            }
         
            //Elegxos prokeimenou to CRC na entopisei an to mynima pou elave o dektis einai sosto i esfalmeno
            int[] rem2 = new int[length]; // edo apothykeutai to ypoloipo tis diairesis "CRC pou lamvanei o dektis / dyadikos arithmos P"
            for(int j=0; j<crc2.length; j++)
            {
                rem2[j] = crc2[j];
            }
            rem2=DD(crc2, DOP, rem2);
        
            boolean flag = true ;
            
            for(int i=0; i< rem2.length; i++)
            {
                //Ypologismos tou plythous ton mynimaton pou anixneuontai os esfalmena apo to CRC
                if(rem2[i]!=0)
                {
                    counter2++;
                    flag = false;
                    break;
                }
            }
             
        }
        
        //Ypologismos tou plythous ton mynimaton pou fthanoun me sfalma ston apodekti kai den anixneuontai apo to CRC
        counter3 = counter1 - counter2 ;
        
        //Ypologismos pososton
        float pos1 = ( (float)counter1 / (float)size ) * 100 ;
        float pos2 = ( (float)counter2 / (float)counter1 ) * 100 ;
        float pos3 = ( (float)counter3 / (float)counter1 ) * 100 ;
       
        System.out.println();
        System.out.println("To pososto ton mynimaton pou ftanoun me sfalma ston apodekti einai: " + pos1 + "% (" + counter1 + " apo ta " + size + " mynimata)");
        System.out.println("To pososto ton mynimaton pou anixneuontai os esfalmena apo to CRC einai: " + pos2 + "% (" + counter2 + " apo ta " + counter1 + " mynimata)");
        System.out.println("To pososto ton mynimaton pou ftanoun me sfalma ston apodekti kai den anixneuontai apo to CRC einai: " + pos3 + "% (" + counter3 + " apo ta " + counter1 + " mynimata)");
        
    }
      
}
