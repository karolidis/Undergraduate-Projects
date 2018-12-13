package paixnidimnhmhs;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * O skopos auths ths klashs einai na emfanizei tis kartes se tuxaies 9eseis sthn o9onh
 * @author Mixalhs-Papakwnstantinou
 */
public class ShowTheCardsRandom extends ShowTheCards{
    
    /**
     * 9a emfanizei tis kartes se tuxaies 9eseis
     * @param frame to frame to idio
     */
    @Override
    public void Show(Frame frame)
    {
        Frame.cardsPanel.setLayout(null);
        
        int dim=50;//9a einai to mege9os ths eikonas, analoga apo paizume normal,double...
        int times=0;//ama p.x paizume normal h double nikame se 2 omoies kartes ara times=2
        switch(frame.modeType)
        {
            case 0:
            {
                dim=90;
                times=2;
                break;
            }
            case 1:
            {
                dim=65;
                times=2;
                break;
            }
            case 2:
            {
                dim=80;
                times=3;
                break;
            }
            case 3:
            {
                dim=65;
                times=4;
                break;
            }                
        }
        
        //ftiaxnume mia lista me ari8mus, kai afu pros9etume ta kumpia se random 9eseis den xreiazomaste na kanume randomize thn lista
        int temp=frame.numOfCards/times;
        List<Integer> lista = new ArrayList<>();
        for(int i=1; i<=times; i++)
        {
            for(int j=1; j<=temp; j++)
            {
                lista.add(j);
            }
        }
        
        //kanume resize thn eikona question mark wste na ti balume se ola ta kumpia
        Image img= new ImageIcon(getClass().getResource("/eikones/pisw.png")).getImage();
        ImageIcon cardImage = new ImageIcon(img.getScaledInstance(dim-15, dim-15, img.SCALE_SMOOTH));
        
        Random randomGenerator = new Random();
        temp=frame.numOfCards;
        for (int i=0; i<temp; i++)
        {
            JButton cardButton = new JButton();
            cardButton.setActionCommand(Integer.toString(lista.get(i))+"-"+Integer.toString(i));
            cardButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                { 
                    frame.cards.cardClicked(cardButton);
                }
            });
            cardButton.setIcon(cardImage);
            boolean collision=true;
            int x=randomGenerator.nextInt(991-dim);
            int y=randomGenerator.nextInt(600-dim);
            cardButton.setBounds(x, y, dim, dim);
            if(!Cards.cardsButtons.isEmpty())
            {
                while(collision)
                {
                    for( JButton but : Cards.cardsButtons ) {
                        if(cardButton.getBounds().intersects(but.getBounds()))
                        {
                            collision=true;
                            x=randomGenerator.nextInt(991-dim);
                            y=randomGenerator.nextInt(600-dim);
                            cardButton.setBounds(x, y, dim, dim);
                            break;
                        }
                        collision=false;
                    }
                }
            }
            Frame.cardsPanel.add(cardButton);
            Cards.cardsButtons.add(cardButton);
        }  
    }
}
