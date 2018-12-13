package paixnidimnhmhs;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Timer;

/**
 * ayth h klash xeirizetai to paixnidi pu paizeis me antipalous
 * @author Mixalhs-Papakwnstantinou
 */
public class MultiPlayerGame extends Game{
    
    public static int round=1;
    int cardsLeft=1;
    public static int player=1;
    /**
     * tha ksekinai to multi player paixnidi
     * @param frame to frame to idio
     */
    @Override
    public void start(Frame frame)
    {
        if(Frame.random)
        {
            ShowTheCardsRandom view = new ShowTheCardsRandom();
            view.Show(frame);
        }
        else
        {
            ShowTheCardsAsAGrid view = new ShowTheCardsAsAGrid();
            view.Show(frame);
        }
        frame.botPanel.setVisible(true);
        frame.playersPanel.setVisible(true);
        frame.movesLabel.setText("Round:");
        frame.countMovesLabel.setText("1");
        round=1;
        player=1;
        
        Frame.player4Label.setVisible(Frame.Players.size()>3);
        Frame.player4Type.setVisible(Frame.Players.size()>3);
        Frame.player4Correct.setVisible(Frame.Players.size()>3);
        Frame.player4Count.setVisible(Frame.Players.size()>3);
        
        Frame.player3Label.setVisible(Frame.Players.size()>2);
        Frame.player3Type.setVisible(Frame.Players.size()>2);
        Frame.player3Correct.setVisible(Frame.Players.size()>2);
        Frame.player3Count.setVisible(Frame.Players.size()>2);
        
        int i=1;
        for( String player : Frame.Players ) { 
            switch(i)
            {
                case 1:
                {
                    Frame.player1Type.setText(player);
                    break;
                }
                case 2:
                {
                    Frame.player2Type.setText(player);
                    break;
                }
                case 3:
                {
                    Frame.player3Type.setText(player);
                    break;
                }
                case 4:
                {
                    Frame.player4Type.setText(player);
                    break;
                }
            }
            i++;
        }
        
        changeFont();
        
        cardsLeft=frame.numOfCards;
    }
    
    /**
     * mia oloklhrh kinhsh pragmatopoih9hke, dld an paizume normal h double mia oloklhrh kinhsh einai 2 anoigmata kartwn
     * @param same oi kartes einai idies h oxi
     */
    public void moveMade(boolean same)
    {
        System.out.println("move made"+same);
        if(same)
        {
            switch(player)
            {
                case 1:
                {
                    Frame.player1Count.setText(Integer.toString(Integer.parseInt(Frame.player1Count.getText())+1));
                    break;
                }
                case 2:
                {
                    Frame.player2Count.setText(Integer.toString(Integer.parseInt(Frame.player2Count.getText())+1));
                    break;
                }
                case 3:
                {
                    Frame.player3Count.setText(Integer.toString(Integer.parseInt(Frame.player3Count.getText())+1));
                    break;
                }
                case 4:
                {
                    Frame.player4Count.setText(Integer.toString(Integer.parseInt(Frame.player4Count.getText())+1));
                    break;
                }
            }
            
            //aferume tis kartes pu bre9hkan
            switch(Frame.modeType)
            {
                case 0:
                case 1:
                {
                    cardsLeft-=2;
                    break;
                }
                case 2:
                {
                    cardsLeft-=3;
                    break;
                }
                case 3:
                {
                    cardsLeft-=4;
                    break;
                }
            }
            
            for( JButton but : Frame.cards.ShownCardsButtons )
            {
                for( JButton but2 : Frame.cards.cardsButtons )
                {
                    if(but==but2)
                    {
                        Frame.cards.cardsButtons.remove(but2);
                        //remove from computers memmory
                        for( JButton but3 : Frame.cards.KangouroMemory )
                        {
                            if(but3==but2)
                            {
                                Frame.cards.KangouroMemory.remove(but3);
                                break;
                            }
                        }
                        for( JButton but4 : Frame.cards.elephantMemory )
                        {
                            if(but4==but2)
                            {
                                Frame.cards.elephantMemory.remove(but4);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
                System.out.println("move made2"+same);
        
        if(cardsLeft==0) //to paixnidi teleiwse, munhma kai epistrofh sto menu
        {
            Frame.cardsPanel.setLayout(new GridLayout(1,0,0,0));
            Frame.botPanel.setVisible(false);
            Frame.cardsPanel.removeAll();
            Frame.cardsPanel.add(Frame.menuPanel);
            Frame.menuPanel.setVisible(true);
            Frame.cards.clearLists();
            Frame.Players.clear();
            
            int playerWon=1;
            int playerWonCorrectCount=Integer.parseInt(Frame.player1Count.getText());
            if(Integer.parseInt(Frame.player2Count.getText())>playerWonCorrectCount)
            {
                playerWon=2;
                playerWonCorrectCount=Integer.parseInt(Frame.player2Count.getText());
            }
            if(Integer.parseInt(Frame.player3Count.getText())>playerWonCorrectCount)
            {
                playerWon=2;
                playerWonCorrectCount=Integer.parseInt(Frame.player3Count.getText());
            }
            if(Integer.parseInt(Frame.player3Count.getText())>playerWonCorrectCount)
            {
                playerWon=2;
                playerWonCorrectCount=Integer.parseInt(Frame.player3Count.getText());
            }
            
            JOptionPane.showMessageDialog(null,"Player "+playerWon+" won with "+playerWonCorrectCount+ " corrects at round "+round+".");
        }
        else
        {
                    System.out.println("move made3"+same);
            //to paixnidi den teleiwse, pame sto epomeno paikth, perimenume kinhsh an9rupu h kalume emeis ta computer na kanun kinhsh
            if(!same || Frame.playAgain)
            {
                if(player==Frame.Players.size())
                {
                    round++;
                    player=1;
                }
                else
                    player++;
                
                if(!TypeOfCurrentPlayer().contains("Human"))
                {
                    //o computer paikths kanei kinhsh
                    int times=2;
                    switch(Frame.modeType)
                    {
                        case 2:
                        {
                            times=3;
                            break;
                        }
                        case 3:
                        {
                            times=4;
                            break;
                        }                
                    }
                    for (int i=1; i<times+1; i++)
                    {
                        Timer timer=new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                computerMove(TypeOfCurrentPlayer());
                            }
                        }, i*1000);
                    }
                }

                changeFont();
            }
            Frame.countMovesLabel.setText(Integer.toString(round));
        }
    }
    
    /**
     * kalume thn analogh sunarthsh, analoga me thn mnhmh tu upologisth
     * @param typeOfMemory o tupos ths mnhmhs
     */
    private void computerMove(String typeOfMemory)
    {        
        //
        if(typeOfMemory.contains("Goldenfish"))
        {           
            clickButton(findARandomCard());
        }
        else if(typeOfMemory.contains("Kangouro"))
        {
            KangouroElephantMove(Frame.cards.KangouroMemory);
        }
        else if(typeOfMemory.contains("Elephant"))
        {
            KangouroElephantMove(Frame.cards.elephantMemory);
        }     
    }
    
    /**
     * edw kanei kinhsh to kangouro h o elephantas
     * @param List einai h lista twn kumpiwn pu exun anoixtei, k 9umate eite ws kangouro eite ws elephantas
     */
    private void KangouroElephantMove(List<JButton> List)
    {
        int times=2;
        switch(Frame.modeType)
        {
            case 2:
            {
                times=3;
                break;
            }
            case 3:
            {
                times=4;
                break;
            }                
        }
        
        int shownCount=Frame.cards.ShownCardsButtons.size();
        if(shownCount==times)
        {
            shownCount=0;
        }
        System.out.println("Showncount"+shownCount);
        
        //den uparxun anoixtes kartes
        if(shownCount==0)
        {
            //an p.x xreiazontai na anoixtun 2 kartes kai uparxun 2 kumpia sth lista, me tis ides eikones, to Kangouro brhke 2 kartes opote tis anoigei
            //dhladh elenxume an ka9e kumpi ths listas tu kangouroexei "times" omoies kartes, tote tis anoigei
            int currentButtonMatches=0;
            boolean flag=true;
            for( JButton but : List )
            {
                currentButtonMatches=0;
                for( JButton but2 : List)
                {
                    String[] temp= but.getActionCommand().split("-");
                    String[] temp2= but2.getActionCommand().split("-");
                    if(temp[0].equals(temp2[0]))
                        currentButtonMatches++;
                }
                if(currentButtonMatches==times)
                {
                    flag=false;
                    Frame.cards.cardClicked(but);
                    break;
                }
            }
            System.out.println(flag+"leon");
            if(flag)//h lista den exei omoies kartes, opote anoigume kati sthn tuxh
            {
                clickButton(findARandomCard());
            }
        }
        else{ //uparxun anoixtes kartes, elenxume an auth h karta uparxei alla den einai to idio kumpi
            boolean flag=true;
            for( JButton but : Frame.cards.ShownCardsButtons )
            {
                for( JButton but2 : List )
                {
                    if(!but.getActionCommand().equals(but2.getActionCommand()))
                    {
                        String[] temp= but.getActionCommand().split("-");
                        String[] temp2= but2.getActionCommand().split("-");
                        if(temp[0].equals(temp2[0]))
                        {
                            flag=false;
                            Frame.cards.cardClicked(but2);
                            break;
                        }
                    }
                }
            }
            System.out.println(flag);
            if(flag)//h lista den exei omoies kartes, opote anoigume kati sthn tuxh
            {
                clickButton(findARandomCard());
            }
        }
    }
    
     /**
     * patame ena kumpi analoga me ton ari9mo pu dinete sto buttonNum
     * @param buttonNum o ari9mos tu kumpiu
     */
    private void clickButton(int buttonNum)
    {
        for( JButton but : Frame.cards.cardsButtons )
        {
            String[] temp= but.getActionCommand().split("-");
            if(Integer.parseInt(temp[1])==buttonNum)
            {
                Frame.cards.cardClicked(but);
                break;
            }
        }
    }
    
     /**
     * briskume mia tuxai karta
     */
    private int findARandomCard()
    {
        //
        Random randomGenerator = new Random();
        boolean flag=false;
        int randomButton=0;
        do{
            flag=false;
            randomButton=randomGenerator.nextInt(Frame.numOfCards+1);
            //an to random kumpi pu epilexthke einai open bres allo random kumpi
            for( JButton but : Frame.cards.ShownCardsButtons )
            {
                String[] temp= but.getActionCommand().split("-");
                if(Integer.parseInt(temp[1])==randomButton)
                {
                    flag=true;
                    break;
                }
            }
            //an to random kumpi pu epilexthke einai found, bres allo random kumpi
            if(!flag)
            {
                flag=true;
                for( JButton but : Frame.cards.cardsButtons )
                {
                    String[] temp= but.getActionCommand().split("-");
                    if(Integer.parseInt(temp[1])==randomButton)
                        flag=false;
                }
            }  
        }while(flag);
        return randomButton;
    }
    
    /**
     * epistrefei ton tupo tu paikth
     */
    public String TypeOfCurrentPlayer()
    {
        switch(player)
        {
            case 1:
            {
                return Frame.player1Type.getText();
            }
            case 2:
            {
                return Frame.player2Type.getText();
            }
            case 3:
            {
                return Frame.player3Type.getText();
            }
            case 4:
            {
                return Frame.player4Type.getText();
            }
        }
        return "Human";
    }
    
    /**
     * allazei ta se boold h pain ta labels, gia na deixnume poios paizeis twra
     */
    private void changeFont()
    {
        if(player==1)
        {
            Frame.player1Label.setFont(new Font("default", Font.BOLD, 14));
            Frame.player1Type.setFont(new Font("default", Font.BOLD, 14));
            Frame.player1Correct.setFont(new Font("default", Font.BOLD, 14));
            Frame.player1Count.setFont(new Font("default", Font.BOLD, 14));
        }
        else
        {
            Frame.player1Label.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player1Type.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player1Correct.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player1Count.setFont(new Font("default", Font.PLAIN, 14));
        }
        
        if(player==2)
        {
            Frame.player2Label.setFont(new Font("default", Font.BOLD, 14));
            Frame.player2Type.setFont(new Font("default", Font.BOLD, 14));
            Frame.player2Correct.setFont(new Font("default", Font.BOLD, 14));
            Frame.player2Count.setFont(new Font("default", Font.BOLD, 14));
        }
        else
        {
            Frame.player2Label.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player2Type.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player2Correct.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player2Count.setFont(new Font("default", Font.PLAIN, 14));
        }
        
        if(player==3)
        {
            Frame.player3Label.setFont(new Font("default", Font.BOLD, 14));
            Frame.player3Type.setFont(new Font("default", Font.BOLD, 14));
            Frame.player3Correct.setFont(new Font("default", Font.BOLD, 14));
            Frame.player3Count.setFont(new Font("default", Font.BOLD, 14));
        }
        else
        {
            Frame.player3Label.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player3Type.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player3Correct.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player3Count.setFont(new Font("default", Font.PLAIN, 14));
        }
        
        if(player==4)
        {
            Frame.player4Label.setFont(new Font("default", Font.BOLD, 14));
            Frame.player4Type.setFont(new Font("default", Font.BOLD, 14));
            Frame.player4Correct.setFont(new Font("default", Font.BOLD, 14));
            Frame.player4Count.setFont(new Font("default", Font.BOLD, 14));
        }
        else
        {
            Frame.player4Label.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player4Type.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player4Correct.setFont(new Font("default", Font.PLAIN, 14));
            Frame.player4Count.setFont(new Font("default", Font.PLAIN, 14));
        }
    }
}
