package paixnidimnhmhs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * O skopos auths ths klashs einai na emfanizei tis kartes se plegma
 * @author Mixalhs-Papakwnstantinou
 */
public class ShowTheCardsAsAGrid extends ShowTheCards{
    /**
     * tha emfanizei tis kartes se plegma
     * @param frame to frame to idio
     */
    @Override
    public void Show(Frame frame)
    {   
        if(frame.mode!=2)
        {
            int dim=80;//9a einai to mege9os ths eikonas, analoga apo paizume normal,double...
            int times=0;//ama p.x paizume normal h double nikame se 2 omoies kartes ara times=2
            switch(frame.modeType)
            {
                case 0:
                {
                    frame.cardsPanel.setLayout(new GridLayout(4,6,0,10));
                    dim=120;
                    times=2;
                    break;
                }
                case 1:
                {
                    frame.cardsPanel.setLayout(new GridLayout(6,8,0,10));
                    times=2;
                    break;
                }
                case 2:
                {
                    frame.cardsPanel.setLayout(new GridLayout(6,8,0,10));
                    times=3;
                    break;
                }
                case 3:
                {
                    frame.cardsPanel.setLayout(new GridLayout(6,8,0,10));
                    times=4;
                    break;
                }                
            }

            //ftiaxnume mia lista me ari8mus kai meta tus bazume se tyxaies 8eseis
            int temp=frame.numOfCards/times;
            List<Integer> lista = new ArrayList<>();
            for(int i=1; i<=times; i++)
            {
                for(int j=1; j<=temp; j++)
                {
                    lista.add(j);
                }
            }
            Collections.shuffle(lista);

            //kanume resize thn eikona question mark wste na ti balume se ola ta kumpia
            Image img= new ImageIcon(getClass().getResource("/eikones/pisw.png")).getImage();
            ImageIcon cardImage = new ImageIcon(img.getScaledInstance(dim, dim, img.SCALE_SMOOTH));

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
                frame.cardsPanel.add(cardButton);
                Cards.cardsButtons.add(cardButton);
            }
            lista.clear();
            frame.revalidate();
            frame.repaint();
        }
        else
        {
            int dim=80;
            Image img= new ImageIcon(getClass().getResource("/eikones/pisw.png")).getImage();
            ImageIcon cardImage = new ImageIcon(img.getScaledInstance(dim, dim, img.SCALE_SMOOTH));
            frame.cardsPanel.setLayout(new GridLayout(2,0,0,8));
            
            JPanel firstPanel = new JPanel();
            firstPanel.setLayout(new GridLayout(3,8,0,10));
            int temp=24;
            List<Integer> lista = new ArrayList<>();
            for(int j=1; j<=temp; j++)
            {
                lista.add(j);
            }
            Collections.shuffle(lista);
            
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
                firstPanel.add(cardButton);
                Cards.cardsButtons.add(cardButton);
            }
            lista.clear();

            
            JPanel secondPanel = new JPanel();
            secondPanel.setLayout(new GridLayout(3,8,0,10));
            for(int j=1; j<=temp; j++)
            {
                lista.add(j);
            }
            Collections.shuffle(lista);
            
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
                secondPanel.add(cardButton);
                Cards.cardsButtons.add(cardButton);
            }
            lista.clear();
            
            frame.cardsPanel.add(firstPanel);
            frame.cardsPanel.add(secondPanel);
            
            frame.revalidate();
            frame.repaint();
        }
    }
}
