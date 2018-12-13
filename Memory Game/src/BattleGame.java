package paixnidimnhmhs;

import java.awt.Font;

/**
 * Auth h klash 9a xeirizetai to paixnidi pou paizeis me ena allo antipalo
 * @author Mixalhs-Papakwnstantinou
 */
public class BattleGame extends Game{
    
    /**
     * tha ksekinaei to battle paixnidi
     */
    
    public static int round=1;
    int cardsLeft=1;
    public static int player=1;
    
    @Override
    public void start(Frame frame)
    {   
        frame.botPanel.setVisible(true);        
        ShowTheCardsAsAGrid view = new ShowTheCardsAsAGrid();
        view.Show(frame);
        frame.playersPanel.setVisible(true);
        frame.movesLabel.setText("Round:");
        frame.countMovesLabel.setText("1");
        round=1;
        player=1;
        
        Frame.player4Label.setVisible(false);
        Frame.player4Type.setVisible(false);
        Frame.player4Correct.setVisible(false);
        Frame.player4Count.setVisible(false);
        
        Frame.player3Label.setVisible(false);
        Frame.player3Type.setVisible(false);
        Frame.player3Correct.setVisible(false);
        Frame.player3Count.setVisible(false);
        
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
            }
            i++;
        }
        
        changeFont();
        
        cardsLeft=frame.numOfCards;
    }
    
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
