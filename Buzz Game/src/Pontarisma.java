/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import javax.swing.KeyStroke;

/**
 *
 * 
 */
public class Pontarisma extends javax.swing.JFrame {

    /**
     * Creates new form Pontarisma
     */
    int pontarisma,pontarisma2;
    boolean u,u1,u2,u3,u4;
    private int vathmoi, IDerotisis, IDapant, rounds = 0,p,p1;
    ;
     private ArrayList<Integer> EmfanismenesApant;

    private ArrayList<Erotisi> erotiseis = new ArrayList<>();
    String apant, epilogi, que;

    public Pontarisma(Erotiseis E) throws IOException {
        initComponents();
        EnableButtonsHotKeys();
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         this.jLabel1.setText(NewJFrame.nam1);
        this.jLabel2.setText(NewJFrame.nam2);
        erotiseis = E.getErotiseis(NewJFrame.lang);
       
        Round();
    }
     private void pl(){
        if (NewJFrame.paixt==1){
            this.Ap2.setEnabled(false);
            this.Bp2.setEnabled(false);
            this.Cp2.setEnabled(false);
            this.Dp2.setEnabled(false);
            
        }
        
    }
     
     private void image(){
              String k= erotiseis.get(IDerotisis).getPhoto(IDerotisis);
     
       
        if( !(k.contains("no")) ){
           
           
             ImageIcon iic =new ImageIcon(getClass().getResource("/Buzz/images/"+k+".jpg"));
             jLabel3.setIcon(iic);
             jLabel3.setVisible(true);
        }
         
     }
      public void EnableButtonsHotKeys()
    {
        InputMap im1 = Ap1.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am1 = Ap1.getActionMap();
        im1.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "clickMe");
        am1.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton JButton1 = (JButton) e.getSource();
                JButton1.doClick();
            }
        });
        
        InputMap im2 = Bp1.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am2 = Bp1.getActionMap();
        im2.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "clickMe");
        am2.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton2 = (JButton) e.getSource();
                jButton2.doClick();
            }
        });
        
        InputMap im3 = Cp1.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am3 = Cp1.getActionMap();
        im3.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "clickMe");
        am3.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton3 = (JButton) e.getSource();
                jButton3.doClick();
            }
        });
        
        InputMap im4 = Dp1.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am4 = Dp1.getActionMap();
        im4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "clickMe");
        am4.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton4 = (JButton) e.getSource();
                jButton4.doClick();
            }
        });
        
        InputMap im5 = Ap2.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am5 = Ap2.getActionMap();
        im5.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, 0), "clickMe");
        am5.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton5 = (JButton) e.getSource();
                jButton5.doClick();
            }
        });
        
        InputMap im6 = Bp2.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am6 = Bp2.getActionMap();
        im6.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "clickMe");
        am6.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton6 = (JButton) e.getSource();
                jButton6.doClick();
            }
        });
        
        InputMap im7 = Cp2.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am7 = Cp2.getActionMap();
        im7.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0), "clickMe");
        am7.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton7 = (JButton) e.getSource();
                jButton7.doClick();
            }
        });
        
        InputMap im8 = Dp2.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am8 = Dp2.getActionMap();
        im8.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "clickMe");
        am8.put("clickMe", new AbstractAction() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JButton jButton8 = (JButton) e.getSource();
                jButton8.doClick();
            }
        });
            
    }

    private void Round() throws IOException {
        jLabel3.setVisible(false);
        pl();
        p=NewJFrame.paixt;
        p1=NewJFrame.paixt;
          if(NewJFrame.paixt==2){
            this.Ap2.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
        }
        this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
        Random rand = new Random();
        IDerotisis = rand.nextInt(erotiseis.size());

        /**
         * with this for loop we manage to use every Erotisi's class object only
         * one time and in random queue.
         */
        for (int i = 0; i < NewJFrame.EIDs.size(); i++) {
            if (IDerotisis == NewJFrame.EIDs.get(i)) {
                IDerotisis = rand.nextInt(erotiseis.size());
                i = -1;
            }
        }

        NewJFrame.EIDs.add(IDerotisis);

        Erotisi e = erotiseis.get(IDerotisis);

        this.Print.setText("\nΚατηγορία : " + e.getKatigoria() + "\nΤι ποντάρισμα θέλετε να κάνετε;\n");

        this.Ap1.setText(250 + " πόντους");
        this.Bp1.setText(500 + " πόντους");
        this.Cp1.setText(750 + " πόντους");
        this.Dp1.setText(1000 + " πόντους");
        this.Ap2.setText(250 + " πόντους");
        this.Bp2.setText(500 + " πόντους");
        this.Cp2.setText(750 + " πόντους");
        this.Dp2.setText(1000 + " πόντους");

        u = true;
        u1=true;
        u2=true;
        u3=true;
        u4=true;

        /**
         * this while loop is used as an error check.if the player give an
         * answer out of bounds we print him iteratively a message till he gives
         * a correct answer.
         */
        /**
         * with these if statements we set the bet's amount.
         */
        int counter = 0;
        EmfanismenesApant = new ArrayList<>();

        /**
         * with this while loop we manage to print every time the answers with
         * in a different row.
         */
        que = e.getTitlosErotisis();
        this.ansA.setVisible(false);
        this.ansB.setVisible(false);
        this.ansC.setVisible(false);
        this.ansD.setVisible(false);
        while (counter < 4) {

            IDapant = rand.nextInt(4);
            /**
             * with this for loop we manage to select for printing every answer
             * only one time and in a random queue.
             */
            for (int g = 0; g < EmfanismenesApant.size(); g++) {
                if (IDapant == EmfanismenesApant.get(g)) {
                    IDapant = rand.nextInt(4);
                    g = -1;
                }
            }

            EmfanismenesApant.add(IDapant);

            String sa = e.getSostiApantisi();

            /**
             * with these if statements we print the answers and we find in
             * which selection is the right answer.
             */
            if (counter == 0) {
                this.ansA.setText(e.returnAp(IDapant));
                if (e.returnAp(IDapant).equals(sa)) {
                    apant = "a";
                }
            } else if (counter == 1) {
                this.ansB.setText(e.returnAp(IDapant));
                if (e.returnAp(IDapant).equals(sa)) {
                    apant = "b";
                }
            } else if (counter == 2) {
                this.ansC.setText(e.returnAp(IDapant));
                if (e.returnAp(IDapant).equals(sa)) {
                    apant = "c";
                }
            } else {
                this.ansD.setText(e.returnAp(IDapant));
                if (e.returnAp(IDapant).equals(sa)) {
                    apant = "d";
                }
            }

            counter++;
        }

        /**
         * this while loop is used as an error check.if the player give an
         * answer out of bounds we print him iteratively a message till he gives
         * a correct answer.
         */
        /**
         * with this if statement we check if the player's answer is correct.If
         * the answer is correct we add the bet's amount to total player's
         * points and we print the suitable message.If the answer is wrong we
         * decrease the total player's points by bet's amount and we print the
         * suitable message.
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cp1 = new javax.swing.JButton();
        Cp2 = new javax.swing.JButton();
        Dp1 = new javax.swing.JButton();
        Print2 = new javax.swing.JScrollPane();
        Print = new javax.swing.JEditorPane();
        Dp2 = new javax.swing.JButton();
        ansB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ansC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ansD = new javax.swing.JLabel();
        Ap1 = new javax.swing.JButton();
        ansA = new javax.swing.JLabel();
        Ap2 = new javax.swing.JButton();
        Bp1 = new javax.swing.JButton();
        Bp2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cp1.setText("C");
        Cp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cp1ActionPerformed(evt);
            }
        });

        Cp2.setText("C");
        Cp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cp2ActionPerformed(evt);
            }
        });

        Dp1.setText("D");
        Dp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dp1ActionPerformed(evt);
            }
        });

        Print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Print.setEnabled(false);
        Print2.setViewportView(Print);

        Dp2.setText("D");
        Dp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dp2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Παίχτης 1");

        jLabel2.setText("Παίχτης 2");

        Ap1.setText("A");
        Ap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ap1ActionPerformed(evt);
            }
        });

        Ap2.setText("A");
        Ap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ap2ActionPerformed(evt);
            }
        });

        Bp1.setText("B");
        Bp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bp1ActionPerformed(evt);
            }
        });

        Bp2.setText("B");
        Bp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bp2ActionPerformed(evt);
            }
        });

        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(Print2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cp1)
                            .addComponent(Dp1)
                            .addComponent(Ap1)
                            .addComponent(Bp1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ansC, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(ansD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ansB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ansA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dp2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Cp2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Bp2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Ap2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Print2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ansD, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ap1)
                                    .addComponent(Ap2)))
                            .addComponent(ansA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Bp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cp2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Bp1)
                                        .addGap(20, 20, 20)
                                        .addComponent(Cp1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(ansC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(ansB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Dp1)
                            .addComponent(Dp2))))
                .addGap(142, 142, 142))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cp1ActionPerformed
        // TODO add your handling code here:

        this.Bp1.setEnabled(false);
        this.Ap1.setEnabled(false);
        this.Dp1.setEnabled(false);
        if(u1==true){
            p1=p1-1;
            u1=false;
            pontarisma = 750;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
            pl();
            image();
        } else if(p1==0 && u3==true){
            p=p-1;
            u3=false;
            epilogi = "c";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi = NewJFrame.pontoi + pontarisma;

            } else {
                NewJFrame.pontoi = NewJFrame.pontoi - pontarisma;

            }
            rounds++;
            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Cp1ActionPerformed

    private void Cp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cp2ActionPerformed
        // TODO add your handling code here:

        this.Bp2.setEnabled(false);
        this.Ap2.setEnabled(false);
        this.Dp2.setEnabled(false);
        if(u2==true){
            p1=p1-1;
            u2=false;
            pontarisma2 = 750;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
        } else if(p1==0 && u4==true) {
            p=p-1;
            u4=false;
            epilogi = "c";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 + pontarisma2;

            } else {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 - pontarisma2;
            }

            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Cp2ActionPerformed

    private void Dp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dp1ActionPerformed
        // TODO add your handling code here:

        this.Bp1.setEnabled(false);
        this.Ap1.setEnabled(false);
        this.Cp1.setEnabled(false);
        if(u1==true){
            p1=p1-1;
            u1=false;
            pontarisma = 1000;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
            pl();
            image();
        }  else if(p1==0 && u3==true){
            p=p-1;
            u3=false;
            epilogi = "d";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi = NewJFrame.pontoi + pontarisma;

            } else {
                NewJFrame.pontoi = NewJFrame.pontoi - pontarisma;
            }
            rounds++;
            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Dp1ActionPerformed

    private void Dp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dp2ActionPerformed
        // TODO add your handling code here:

        this.Bp2.setEnabled(false);
        this.Ap2.setEnabled(false);
        this.Cp2.setEnabled(false);
        if(u2==true){
            p1=p1-1;
            u2=false;
            pontarisma2 = 1000;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
        }else if(p1==0 && u4==true) {
            p=p-1;
            u4=false;
            epilogi = "d";
            u3=false;
            if (epilogi.equals(apant)) {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 + pontarisma2;

            } else {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 - pontarisma2;
            }

            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Dp2ActionPerformed

    private void Ap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ap1ActionPerformed
        // TODO add your handling code here:

        this.Bp1.setEnabled(false);
        this.Dp1.setEnabled(false);
        this.Cp1.setEnabled(false);
        if(u1==true){
            p1=p1-1;
            u1=false;
            pontarisma = 250;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
            pl();
            image();

        }  else if(p1==0 && u3==true){
            p=p-1;
            u3=false;
            epilogi = "a";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi = NewJFrame.pontoi + pontarisma;

            } else {
                NewJFrame.pontoi = NewJFrame.pontoi - pontarisma;
            }
            rounds++;
            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Ap1ActionPerformed

    private void Ap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ap2ActionPerformed
        // TODO add your handling code here:

        this.Bp2.setEnabled(false);
        this.Dp2.setEnabled(false);
        this.Cp2.setEnabled(false);
        if(u2==true){
            p1=p1-1;
            u2=false;
            pontarisma2 = 250;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
        } else if(p1==0 && u4==true) {
            p=p-1;
            u4=false;
            epilogi = "a";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 + pontarisma2;

            } else {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 - pontarisma2;
            }

            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Ap2ActionPerformed

    private void Bp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bp1ActionPerformed
        // TODO add your handling code here:

        this.Dp1.setEnabled(false);
        this.Ap1.setEnabled(false);
        this.Cp1.setEnabled(false);
        if(u1==true){
            p1=p1-1;
            u1=false;
            pontarisma = 500;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
            pl();
            image();
        }  else if(p1==0 && u3==true){
            p=p-1;
            u3=false;
            epilogi = "b";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi = NewJFrame.pontoi + pontarisma;

            } else {
                NewJFrame.pontoi = NewJFrame.pontoi - pontarisma;
            }
            rounds++;
            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Bp1ActionPerformed

    private void Bp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bp2ActionPerformed
        // TODO add your handling code here:

        this.Dp2.setEnabled(false);
        this.Ap2.setEnabled(false);
        this.Cp2.setEnabled(false);
        if(u2==true){
            p1=p1-1;
            u2=false;
            pontarisma2 = 500;
        }
        if (u == true && p1==0) {

            u = false;
            this.Print.setText(que);
            this.Ap1.setText("A");
            this.Bp1.setText("B");
            this.Cp1.setText("C");
            this.Dp1.setText("D");
            this.Ap2.setText("A");
            this.Bp2.setText("B");
            this.Cp2.setText("C");
            this.Dp2.setText("D");
            this.ansA.setVisible(true);
            this.ansB.setVisible(true);
            this.ansC.setVisible(true);
            this.ansD.setVisible(true);
            this.Ap1.setEnabled(true);
            this.Bp1.setEnabled(true);
            this.Ap2.setEnabled(true);
            this.Cp1.setEnabled(true);
            this.Dp1.setEnabled(true);
            this.Bp2.setEnabled(true);
            this.Cp2.setEnabled(true);
            this.Dp2.setEnabled(true);
        } else if(p1==0 && u4==true) {
            p=p-1;
            u4=false;
            epilogi = "b";

            if (epilogi.equals(apant)) {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 + pontarisma2;

            } else {
                NewJFrame.pontoi2 = NewJFrame.pontoi2 - pontarisma2;
            }

            if (rounds < 4 && p==0) {
                try {
                    Round();
                } catch (IOException ex) {
                    Logger.getLogger(SostiApantisi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(p==0) {
                try {
                    Buzz.Try();
                } catch (IOException ex) {
                    Logger.getLogger(Pontarisma.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        }

    }//GEN-LAST:event_Bp2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pontarisma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pontarisma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pontarisma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pontarisma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ap1;
    private javax.swing.JButton Ap2;
    private javax.swing.JButton Bp1;
    private javax.swing.JButton Bp2;
    private javax.swing.JButton Cp1;
    private javax.swing.JButton Cp2;
    private javax.swing.JButton Dp1;
    private javax.swing.JButton Dp2;
    private javax.swing.JEditorPane Print;
    private javax.swing.JScrollPane Print2;
    private javax.swing.JLabel ansA;
    private javax.swing.JLabel ansB;
    private javax.swing.JLabel ansC;
    private javax.swing.JLabel ansD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
