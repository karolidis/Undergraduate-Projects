package paixnidimnhmhs;

import java.awt.GridLayout;
import javax.swing.JOptionPane;

/**
 * ayth h klash xeirizetai to paixnidi pu paizeis monos
 * @author Mixalhs-Papakwnstantinou
 */
public class SinglePlayerGame extends Game {
    
    public static int moves=0;
    int cardsLeft=1;
    /**
     * 9a ksekinaei to single player paixnidi
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
        frame.playersPanel.setVisible(false);
        
        frame.movesLabel.setText("Moves:");
        frame.countMovesLabel.setText("0");
        moves=0;
        
        cardsLeft=frame.numOfCards;
    }
    
    /**
     * mia oloklhrh kinhsh pragmatopoih9hke, dld an paizume normal h double mia oloklhrh kinhsh einai 2 anoigmata kartwn
     */
    public void moveMade(boolean same)
    {
        moves++;
        Frame.countMovesLabel.setText(Integer.toString(moves));
        if(same)
        {
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
            
            if(cardsLeft==0) //to paixnidi teleiwse, munhma kai epistrofh sto menu
            {
                Frame.cardsPanel.setLayout(new GridLayout(1,0,0,0));
                Frame.botPanel.setVisible(false);
                Frame.cardsPanel.removeAll();
                Frame.cardsPanel.add(Frame.menuPanel);
                Frame.menuPanel.setVisible(true);
                Frame.cards.clearLists();
                JOptionPane.showMessageDialog(null,"You won with "+moves+" moves.");
            }
        }
    }
}