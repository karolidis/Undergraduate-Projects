/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * 
 */
package buzz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NewJFrame extends javax.swing.JFrame {

    public static String nam1 = "player1", nam2 = "player2";
    public static int paixt, lang,gr=0;
    public static double pontoi, pontoi2;
    public static ArrayList<Integer> EIDs;
   public static ArrayList<Integer> Girous;
   public static ArrayList<Integer> EmfanizmenoiGiroi;
   public static Erotiseis E ;
   public static Players P ;
  
    int k = 0;

    int gyroi;

  

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() throws IOException {
        initComponents();
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.langA.setVisible(false);
        this.langE.setVisible(false);
        this.paixtes.setVisible(false);
        this.pla1.setVisible(false);
        this.pla2.setVisible(false);

        this.langA.setEnabled(true);
        this.langA.setVisible(true);
        this.langA.setText("English");
        this.langE.setEnabled(true);
        this.langE.setVisible(true);
        this.langE.setText("Ελληνικά");
        this.NewGame.setVisible(false);
        this.jTextField1.setVisible(false);
        this.jTextField2.setVisible(false);
        
        P = new Players();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        NewGame = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        langA = new javax.swing.JButton();
        langE = new javax.swing.JButton();
        paixtes = new javax.swing.JLabel();
        pla1 = new javax.swing.JButton();
        pla2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buzz");
        setResizable(false);

        NewGame.setText("Νέο Παιχνίδι - New game ");
        NewGame.setEnabled(false);
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        exit.setText("Έξοδος - Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        langA.setText("English");
        langA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langAActionPerformed(evt);
            }
        });

        langE.setText("Ελληνικά");
        langE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                langEActionPerformed(evt);
            }
        });

        paixtes.setText("Παίχτες- players");

        pla1.setText("1");
        pla1.setEnabled(false);
        pla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pla1ActionPerformed(evt);
            }
        });

        pla2.setText("2");
        pla2.setEnabled(false);
        pla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pla2ActionPerformed(evt);
            }
        });

        jButton5.setText("Οδηγίες - Instructions");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.setText("player1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("player2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Στατιστικά - Statistics");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(langA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paixtes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pla1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pla2)
                        .addGap(7, 7, 7))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(langA, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(langE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paixtes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pla1)
                    .addComponent(pla2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(NewGame))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        nam2=this.jTextField2.getText();
        nam1=this.jTextField1.getText();
        gr=0;
        try {
            E = new Erotiseis();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        EIDs = new ArrayList<>();
        int k,counter=0;
        Random rand = new Random();
        Girous = new ArrayList<>();
        if(paixt==1){
          while (counter < 3) {
          

            k = rand.nextInt(3);
            /**
             * with this for loop we manage to select for printing every answer
             * only one time and in a random queue.
             */
            for (int g = 0; g < Girous.size(); g++) {
                if (k == Girous.get(g)) {
                    k = rand.nextInt(3);
                    g = -1;
                }
            }
            Girous.add(k);
            counter++;
            }
        }else{ 
            while (counter < 3) {
          

            k = rand.nextInt(5);
            /**
             * with this for loop we manage to select for printing every answer
             * only one time and in a random queue.
             */
            for (int g = 0; g < Girous.size(); g++) {
                if (k == Girous.get(g)) {
                    k = rand.nextInt(5);
                    g = -1;
                }
            }
            Girous.add(k);
            counter++;
            }
            
        }
        if(Girous.get(0)==0){
            try {
                Buzz.SostiApant();
                gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else  if(Girous.get(0)==1){
            try {
                Buzz.Pontaris();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else  if(Girous.get(0)==2){
            try {
                Buzz.StopTi();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else  if(Girous.get(0)==3){
            Buzz.Thermomet();
             gr++;
        } else  {
            try {
                Buzz.GrigoriAp();
                 gr++;
            } catch (IOException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_NewGameActionPerformed

    private void langAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langAActionPerformed
        // TODO add your handling code here:
        this.paixtes.setVisible(true);
        this.pla1.setVisible(true);
        this.pla2.setVisible(true);
        if (this.pla1.isEnabled() == false && this.pla2.isEnabled()==false) {
            this.pla1.setEnabled(true);
            this.pla2.setEnabled(true);
        }
        this.langA.setEnabled(false);
        this.langE.setEnabled(true);

        lang = 1;
    }//GEN-LAST:event_langAActionPerformed

    private void langEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_langEActionPerformed
        // TODO add your handling code here:
        this.paixtes.setVisible(true);
        this.pla1.setVisible(true);
        this.pla2.setVisible(true);
        if (this.pla1.isEnabled() == false && this.pla2.isEnabled()==false) {
            this.pla1.setEnabled(true);
            this.pla2.setEnabled(true);
        }
        this.langA.setEnabled(true);
        this.langE.setEnabled(false);
        lang = 0;
    }//GEN-LAST:event_langEActionPerformed

    private void pla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pla1ActionPerformed
        // TODO add your handling code here:

        this.pla1.setEnabled(false);
        this.pla2.setEnabled(true);
        this.NewGame.setEnabled(true);
        this.NewGame.setVisible(true);
        this.jTextField1.setVisible(true);
        this.jTextField2.setVisible(false);
        paixt = 1;
    }//GEN-LAST:event_pla1ActionPerformed

    private void pla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pla2ActionPerformed
        // TODO add your handling code here:

        this.pla2.setEnabled(false);
  this.jTextField1.setVisible(true);
        this.jTextField2.setVisible(true);
        this.pla1.setEnabled(true);
        this.NewGame.setEnabled(true);
        this.NewGame.setVisible(true);
        paixt = 2;
    }//GEN-LAST:event_pla2ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        if (nam1.startsWith(" ") || nam2.equals("")) {
            nam1 = "player1";
        }
        if (nam2.startsWith(" ") || nam2.equals("")) {
            nam2 = "player2";
        }
        
        
        
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(lang == 1)
        {
            JOptionPane.showMessageDialog(this.rootPane,
                "Player 1 Keys : Key Ζ,for answer A \n" +
                "                             Key Χ,for answer B \n" +
                "                             Key C,for answer C \n" +
                "                             Key V,for answer D \n\n" +
                "Player 2 Keys : Key U,for answer A \n" +
                "                             Key I,for answer B \n" +
                "                             Key O,for answer C \n" +
                "                             Key P,for answer D \n\n" +
                "1 Player Mode : The player selects the answer either by clicking with the mouse or using the 'Player 1 Keys' keys \n" +
                "2 Player Mode : Players choose their answers exclusively using keys.Player 1 uses the 'Player 1 Keys' and player 2 uses the 'Player 2 Keys'\n\n" ,
                "Instructions",
                JOptionPane.INFORMATION_MESSAGE);

        }
        else
        {
            JOptionPane.showMessageDialog(this.rootPane,
                "Πλήκτρα Παίχτη 1 : Πλήκτρο Ζ,για την απαντηση Α \n" +
                "                                     Πλήκτρο Χ,για την απαντηση Β \n" +
                "                                     Πλήκτρο C,για την απαντηση Γ \n" +
                "                                     Πλήκτρο V,για την απαντηση Δ \n\n" +
                "Πλήκτρα Παίχτη 2 : Πλήκτρο U,για την απαντηση Α \n" +
                "                                     Πλήκτρο I,για την απαντηση Β \n" +
                "                                     Πλήκτρο O,για την απαντηση Γ \n" +
                "                                     Πλήκτρο P,για την απαντηση Δ \n\n" +
                "Παιχνίδι με 1 παίχτη : Ο παίχτης επιλέγει την απάντηση που θέλει είτε κάνοντας κλικ με το ποντίκι είτε χρησιμοποιώντας τα πλήκτρα του 'Παίχτη 1'\n" +
                "Παιχνίδι με 2 παίχτες : Οι παίχτες επιλέγουν τις απαντήσεις τους αποκλειστικά χρησιμοποιώντας τα πλήκτρα.Ο παίχτης 1 χρησιμοποιεί τα πλήκτρα του 'Παίχτη 1' και o παίχτης 2 χρησιμοποιεί τα πλήκτρα του 'Παίχτη 2'\n\n" ,
                "Οδηγίες",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        nam2=this.jTextField2.getText();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Players p = null;
        try {
            p = new Players();
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
           ArrayList<Player> play = new ArrayList<Player>();
           play=p.getPlayers();
           for(int b=0;b<play.size();b++){
               System.out.println(play.get(b).getOnoma()+" "+ play.get(b).getPontoi());
           }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        nam1=this.jTextField1.getText();
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewGame;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton langA;
    private javax.swing.JButton langE;
    private javax.swing.JLabel paixtes;
    private javax.swing.JButton pla1;
    private javax.swing.JButton pla2;
    // End of variables declaration//GEN-END:variables
}