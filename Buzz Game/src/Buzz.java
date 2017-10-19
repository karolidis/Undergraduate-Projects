/**
 *  PANAGIOTATOS GEORGIOS AEM 2627
 *  KAROLIDIS THEODOROS AEM 2572
 */
package buzz;

import static buzz.NewJFrame.Girous;
import static buzz.NewJFrame.P;
import static buzz.NewJFrame.gr;
import static buzz.NewJFrame.pontoi;
import static buzz.NewJFrame.pontoi2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To begin playing, you have first to choose language, after that how many players and then New game
 * @author Karol
 */
public class Buzz {

    public static Thread t1;
    public static int gyroi = 0;
    private ArrayList<Player> paixt = new ArrayList<>();
   
    static NewJFrame form ;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        form = new NewJFrame();
        form.setVisible(true);
        

        /**
         *
         */
    }

    public static void Pontaris() throws IOException {
        gyroi++;

        Pontarisma form1;
        form1 = new Pontarisma( NewJFrame.E );

        form.setVisible(false);
        form1.setVisible(true);

        if (gyroi > 2) {
            NewJFrame.pontoi = 0;
            form.dispose();
        }

    }

    public static void SostiApant() throws IOException {

        gyroi++;
        SostiApantisi form1;

        form1 = new SostiApantisi( NewJFrame.E);

        form.setVisible(false);
        form1.setVisible(true);

        if (gyroi > 2) {
            NewJFrame.pontoi = 0;
            form.dispose();
        }

    }

    public static void StopTi() throws IOException {

        StopTime form1;

        form1 = new StopTime( NewJFrame.E);

        form.setVisible(false);
        form1.setVisible(true);

        t1 = new Thread(form1);
        t1.start();
        if (gyroi > 2) {
            NewJFrame.pontoi = 0;
            form.dispose();
        }
    }

    public static void GrigoriAp() throws IOException {

        gyroi++;
        GrigoriApant form1;

        form1 = new GrigoriApant( NewJFrame.E);

        form.setVisible(false);
        form1.setVisible(true);

        if (gyroi > 2) {
            NewJFrame.pontoi = 0;
            form.dispose();
        }
    }

    public static void Thermomet() {

        gyroi++;
        Thermometro form1;
        form1 = new Thermometro( NewJFrame.E);

        form.setVisible(false);
        form1.setVisible(true);

        if (gyroi > 2) {
            NewJFrame.pontoi = 0;
            form.dispose();
        }
    }
    public static void Try() throws IOException{
        
        if (gr<3){
         if(Girous.get(NewJFrame.gr)==0){
            try {
                Buzz.SostiApant();
                gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else  if(Girous.get(NewJFrame.gr)==1){
            try {
                Buzz.Pontaris();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else  if(Girous.get(NewJFrame.gr)==2){
            try {
                Buzz.StopTi();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else  if(Girous.get(NewJFrame.gr)==3){
            Buzz.Thermomet();
             gr++;
        } else if (Girous.get(NewJFrame.gr)==4) {
            try {
                Buzz.GrigoriAp();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }else {
            
            
            FileWriter fw = new FileWriter("statistics.txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);

    out.print("\n");

            String name1="player1";
             String name2="player2";
             name1= NewJFrame.nam1;
             name2=NewJFrame.nam2;
            
           
           if(NewJFrame.paixt==1){
               out.println(name1+"_"+pontoi);
               
               
           }else {
               out.println(name1+"_"+pontoi);
               out.println(name2+"_"+pontoi2);
               
           }
          
          
               
           out.close();
         
            
            
            Buzz.form.setVisible(true);
        }
         
        
    }

    public static void time() {

    }

}
