/*
 * AEM --> 2572
 * Name --> Thodoris Karolidis
 * AuthMail --> karolidis@csd.auth.gr 
 */
package algorithmoiproject2;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class AlgorithmoiProject2 
{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        
        DiavasmaArxeiou file = new DiavasmaArxeiou();
        file.GetFileContent();
        
        EuresiElaxistouPlithousVM epVM = new EuresiElaxistouPlithousVM();   
      
        int kVM[] =  {1, 2, 7, 11}; // in this table is stored the categories of cores that the company offers.
        int m = kVM.length;
        
        epVM.ElaxistosArithmosPyrinon(kVM, m , file.GetZitoumenoiPyrinesAnaPelati()); 
        
        EuresiApodektonPelaton eap = new EuresiApodektonPelaton();
        
        eap.ApodektoiPelates(file.GetZitoumenoiPyrinesAnaPelati() , file.GetProsferomenesTimesPelaton(), file.GetPlithosDiathesimonPyrinon() ) ;
        
        
    }    

   
}
