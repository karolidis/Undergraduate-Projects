/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paixnidimnhmhs;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Mixalhs-Papakwnstantinou
 */
public class Cards {
    
    public static List<JButton> cardsButtons = new ArrayList<JButton>();
    public static List<JButton> ShownCardsButtons = new ArrayList<JButton>();
    public static List<JButton> elephantMemory = new ArrayList<JButton>();
    public static List<JButton> KangouroMemory = new ArrayList<JButton>();
    
    /**
    *ena kumpi path9hke
    *@param button to kumpi
    */
    public void cardClicked(JButton button){
        //an to kumpi pu molis path9hke htan apo prin anoixto na mh ginei kamoia pra3h
        if(Frame.multi.TypeOfCurrentPlayer().contains("Human") && ButtonClickedIsAlreadyShown(button.getActionCommand()))
            return;
        
        //o elefantas ta 9umatai ola, an den exei 3anaanoixtei to kumpi, pros9ese to sth lista ths mnhmhs tu elefant
        boolean exists=false;
        for( JButton but : elephantMemory )
        {
            if(but==button)
            {
                exists=true;
                break;
            }
        }
        if(!exists)
            elephantMemory.add(button);
        
        //to Kangouro 9umatai ta misa. Opote bgazume ena random ari9mo 0 h 1. an 1 apo9ykeyse thn karta pu anoixthke sth mnhmh su alliws mi kaneis tipota
        //kai me auto ton tropo katafernume na exume 50% pi9anothta na apo9hkeysei th karta sth mnhmh tu
        Random randomGenerator = new Random();
        int randomTrueOrFalse=randomGenerator.nextInt(2);
        if(randomTrueOrFalse==1)
        {
            exists=false;
            for( JButton but : KangouroMemory )
            {
                if(but==button)
                {
                    exists=true;
                    break;
                }
            }
            if(!exists)
                KangouroMemory.add(button);
        }       
        
        //thetume tu kumpiu pu molis path9hke thn eikona pu tu antistoixei
        setButtonImage(button, new ImageIcon(getClass().getResource("/eikones/Pic"+getCardPicture(button.getActionCommand())+".png")).getImage());   
        
        switch(ShownCardsButtons.size())
        {
            case 0: //oles krummenes
            {
                ShownCardsButtons.add(button);
                break;
            }
            case 1: //mia emfanhs ston xrhsth
            {
                ShownCardsButtons.add(button);
                if(Frame.modeType==0 || Frame.modeType==1 )
                {
                    if(Frame.mode==0)
                        Frame.single.moveMade(checkShownButtons());
                    else
                        Frame.multi.moveMade(checkShownButtons());
                }
                break;
            }
            case 2: //duo anoixtes kai path9hke mia trith. An paizume to normal h to double paixnidi blepume an oi 2 kartes pu htan anoixtes htan idies kai pratume analogos
            {
                if(Frame.modeType==0 || Frame.modeType==1 )
                {
                   hideCoverShownCards(checkShownButtons());
                }
                else if(Frame.modeType==2)
                {
                    if(Frame.mode==0)
                        Frame.single.moveMade(checkShownButtons());
                    else
                        Frame.multi.moveMade(checkShownButtons());
                }
                ShownCardsButtons.add(button);
                break;
            }
            case 3: //treis anoixtes kai path9hke mia tetarth. An paizume to trio paixnidi blepume an oi 3 kartes pu htan anoixtes htan idies kai pratume analogos
            {
                if(Frame.modeType==2)
                {
                    hideCoverShownCards(checkShownButtons());
                }
                else if(Frame.modeType==3)
                {
                    if(Frame.mode==0)
                        Frame.single.moveMade(checkShownButtons());
                    else
                        Frame.multi.moveMade(checkShownButtons());
                }
                ShownCardsButtons.add(button);
                break;
            }
            case 4: //tesseris anoixtes kai path9hke mia pempth. An paizume to quarteto paixnidi blepume an oi 4 kartes pu htan anoixtes htan idies kai pratume analogos
            {
                if(Frame.modeType==3)
                {
                    hideCoverShownCards(checkShownButtons());
                }
                ShownCardsButtons.add(button);
                break;
            }
        }
    }
    
    /**
    *9etume se ena kumpi, ena ikonidio
    *@param button to kumpi
    *@param img h eikona
    */
    public void setButtonImage(JButton button, Image img)
    { 
        int dim=0;
        if(!Frame.random)
        {
            dim=80;
            if(Frame.modeType==0)
                dim=120; 
        }
        else
        {
            dim=50;
            switch(Frame.modeType)
            {
                case 0:
                {
                    dim=75;
                    break;
                }
                case 2:
                {
                    dim=65;
                    break;
                }             
            }
        }
        
        ImageIcon cardImage = new ImageIcon(img.getScaledInstance(dim, dim, img.SCALE_SMOOTH));
        button.setIcon(cardImage);
    }
    
    /**
    *pernume ton ari9mo ths eikonas enos kumpiu
    *@param command h eikona
    */
    public int getCardPicture(String command)
    {
        String[] temp= command.split("-");
        return Integer.parseInt(temp[0]);
    }
    
    /**
    *ka9arismos listas otan feugume mesu kapiu tropu apo to paixnidi
    */
    public void clearLists()
    {
        ShownCardsButtons.clear();
        cardsButtons.clear();
        KangouroMemory.clear();
        elephantMemory.clear();
    }
    
    /**
    *elenxume an ola ta kumpia pu einai emfaneis oi eikones ston xrhsth einai idia
    */
    public boolean checkShownButtons()
    {
        int command=0;
        for( JButton but : ShownCardsButtons ) { 
            if(command==0)
                command=getCardPicture(but.getActionCommand());
            else if(command!=getCardPicture(but.getActionCommand()))
                return false;
        }
        return true;
    }
    
    /**
    *kanume tis pra3eis pu analogun stis kartes
    * @param same an oi kartes einai idies h oxi
    */
    public void hideCoverShownCards(boolean same)
    {
        if(same)
        {
            //an ola ta kumpia pu einai emfaneis oi eikones ston xrhsth einai idia krupse ta kumpia
            for( JButton but : ShownCardsButtons ) {
                but.setVisible(false);
            }
        }
        else
        {
            //aliws se ka9e kumpi pu exei emfanh thn eikona ston xrhsth, 9ese to ikonidio me to erwthmatiko
            for( JButton but : ShownCardsButtons ) {
                setButtonImage(but, new ImageIcon(getClass().getResource("/eikones/pisw.png")).getImage());
            }
            
            if(Frame.swap)
            {
               List<String> TempList = new ArrayList<String>();
               for( JButton but : ShownCardsButtons ) {
                   TempList.add(but.getActionCommand());
               }
               int i=1;
               for( JButton but : ShownCardsButtons ) {
                   but.setActionCommand(TempList.get(i));
                   i--;
               }
            }
        }
        
        ShownCardsButtons.clear();
    }
    
    /**
    *elenxos an ena kumpi htan hdh shown
    * @param command h action command tu kumpiu
    */
    public boolean ButtonClickedIsAlreadyShown(String command)
    {
        for( JButton but : ShownCardsButtons ) {
            if(command.equals(but.getActionCommand()))
                return true;
        }
        return false;
    }
}
