package blackjack1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//package blackjack1;
import blackjack1.Deck;
import blackjack1.Player;
import java.awt.Color;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class playField extends javax.swing.JFrame {
    Color colorBtn=new Color(204,204,204);
    private Deck deck=new Deck();
    private Player player=new Player("player");
    private Player dealer=new Player("dealer");
    private final String fileName = "rezultati.txt";
    /**
     * Creates new form playField
     */
    private boolean[] filledDealer=new boolean[6];//за да видим кои лейбъли имат карти и кои не, да знаем къде да слагаме следващата
    private boolean[] filledPlayer=new boolean[6];
    private int indCardsOpened;
    
    private void showScore(){
        LblPointsDealer.setText(String.valueOf(dealer.getScore()));
        LblPointsPlayer.setText(String.valueOf(player.getScore()));
    }
    
    private void WriteFile(String state) throws IOException{
        File file = new File("src/blackjack1/textfile/WinLose.txt");
        
        BufferedWriter writer =new BufferedWriter(new FileWriter(file, true));
        writer.write(state+'\n');
        writer.flush();
        writer.close();
    }
    
    private void EndGame() throws IOException{
        if(dealer.getScore()==player.getScore()){
            JOptionPane.showMessageDialog(null, "DRAW", "End of game", JOptionPane.INFORMATION_MESSAGE);
            WriteFile("draw");
        }
        else if(player.getScore()==21||dealer.getScore()>21||(player.getScore()>dealer.getScore()&&player.getScore()<21)){
            JOptionPane.showMessageDialog(null, "YOU WON:)", "End of game", JOptionPane.INFORMATION_MESSAGE);
            WriteFile("win");
        }
        else{
            JOptionPane.showMessageDialog(null, "YOU LOST:(", "End of game", JOptionPane.INFORMATION_MESSAGE);
            WriteFile("loss");
        }
        NewGame();
    }
    
    private void ifPlayer21Begin() throws IOException{
         dealer.addCard(deck.cards[indCardsOpened]);
         ImageIcon cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
         Dealer2.setIcon(cardIcon);
         showScore();
         EndGame();
    }
    
    private void setAllInvisible(){
        Dealer3.setIcon(null);
        Dealer4.setIcon(null);
        Dealer5.setIcon(null);
        Dealer6.setIcon(null);
        Player3.setIcon(null);
        Player4.setIcon(null);
        Player5.setIcon(null);
        Player6.setIcon(null);
    }
    
    private void NewGame() throws IOException{
        BtnHit.setEnabled(true);
        ImageIcon cardIcon=new ImageIcon(getClass().getResource("/blackjack1/cards/BACK.png"));
        Dealer2.setIcon(cardIcon);
        setAllInvisible();
        
        deck.shuffle();
        indCardsOpened=0;
        for(int i=0;i<6;i++){
            filledDealer[i]=false;
            filledPlayer[i]=false;
        }
        player.newGamePlayer();
        dealer.newGamePlayer();
        //slagame purvite 2 karti na igracha
        player.addCard(deck.cards[indCardsOpened]);
        cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
        Player1.setIcon(cardIcon);
        filledPlayer[0]=true;
        indCardsOpened++;
        
        player.addCard(deck.cards[indCardsOpened]);
        cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
        Player2.setIcon(cardIcon);
        filledPlayer[1]=true;
        indCardsOpened++;
        
        dealer.addCard(deck.cards[indCardsOpened]);
        cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
        Dealer1.setIcon(cardIcon);
        filledDealer[0]=true;
        indCardsOpened++;
        
        showScore();
        
        if(player.getScore()==21) ifPlayer21Begin();
    }
    public playField() throws IOException {
        initComponents();
        //set background
        Color color=new Color(51,153,0);
        getContentPane().setBackground(color);
        setSize(1000,600);
        setResizable(false);
        NewGame();
    }

    public void Initialize(){
       
        
    }
    private int cntWin=0;
    private int cntLoss=0;
    private int cntDraw=0;

    private void FileRead() throws FileNotFoundException, IOException{
        cntWin=0;
        cntLoss=0;
        cntDraw=0;
        File file = new File("src/blackjack1/textfile/WinLose.txt");
        BufferedReader reader=new BufferedReader(new FileReader(file));
        
        String line;
        
        while((line=reader.readLine())!=null){
            if(line.matches("(?i)win")){
                cntWin++;
            }
            else if(line.matches("(?i)loss")){
                cntLoss++;
            }
            else if(line.matches("(?i)draw")){
                cntDraw++;
            }
        }
        reader.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnHit = new javax.swing.JButton();
        BtnStay = new javax.swing.JButton();
        PnDealer = new javax.swing.JPanel();
        Dealer1 = new javax.swing.JLabel();
        Dealer2 = new javax.swing.JLabel();
        Dealer3 = new javax.swing.JLabel();
        Dealer4 = new javax.swing.JLabel();
        Dealer5 = new javax.swing.JLabel();
        Dealer6 = new javax.swing.JLabel();
        PnPlayer = new javax.swing.JPanel();
        Player1 = new javax.swing.JLabel();
        Player2 = new javax.swing.JLabel();
        Player3 = new javax.swing.JLabel();
        Player4 = new javax.swing.JLabel();
        Player5 = new javax.swing.JLabel();
        Player6 = new javax.swing.JLabel();
        LblPointsDealer = new javax.swing.JLabel();
        LblPointsPlayer = new javax.swing.JLabel();
        BtnHistory = new javax.swing.JButton();
        BtnNewGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("playField");
        setBackground(new java.awt.Color(51, 153, 0));

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        BtnHit.setFont(new java.awt.Font("Imprint MT Shadow", 1, 48)); // NOI18N
        BtnHit.setForeground(new java.awt.Color(51, 153, 0));
        BtnHit.setText("HIT");
        BtnHit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHitActionPerformed(evt);
            }
        });

        BtnStay.setFont(new java.awt.Font("Imprint MT Shadow", 1, 48)); // NOI18N
        BtnStay.setForeground(new java.awt.Color(51, 153, 0));
        BtnStay.setText("STAY");
        BtnStay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnStay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(BtnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(BtnStay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        PnDealer.setBackground(new java.awt.Color(51, 204, 0));
        PnDealer.setForeground(new java.awt.Color(51, 204, 0));
        PnDealer.setPreferredSize(new java.awt.Dimension(700, 200));

        Dealer1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Dealer1.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer1);

        Dealer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackjack1/cards/BACK.png"))); // NOI18N
        Dealer2.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer2);

        Dealer3.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer3);

        Dealer4.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer4);

        Dealer5.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer5);

        Dealer6.setPreferredSize(new java.awt.Dimension(120, 210));
        PnDealer.add(Dealer6);

        PnPlayer.setBackground(new java.awt.Color(51, 204, 0));
        PnPlayer.setPreferredSize(new java.awt.Dimension(700, 200));

        Player1.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player1);

        Player2.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player2);

        Player3.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player3);

        Player4.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player4);

        Player5.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player5);

        Player6.setPreferredSize(new java.awt.Dimension(120, 210));
        PnPlayer.add(Player6);

        LblPointsDealer.setBackground(new java.awt.Color(204, 204, 204));
        LblPointsDealer.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LblPointsDealer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblPointsDealer.setText("0");
        LblPointsDealer.setOpaque(true);

        LblPointsPlayer.setBackground(new java.awt.Color(204, 204, 204));
        LblPointsPlayer.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        LblPointsPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblPointsPlayer.setText("0");
        LblPointsPlayer.setOpaque(true);

        BtnHistory.setBackground(new java.awt.Color(204, 204, 204));
        BtnHistory.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
        BtnHistory.setText("History");
        BtnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHistoryActionPerformed(evt);
            }
        });

        BtnNewGame.setBackground(new java.awt.Color(204, 204, 204));
        BtnNewGame.setFont(new java.awt.Font("Goudy Old Style", 1, 24)); // NOI18N
        BtnNewGame.setText("New Game");
        BtnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnNewGame))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PnDealer, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                            .addComponent(PnPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(LblPointsDealer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(LblPointsPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(BtnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PnDealer, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PnPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LblPointsDealer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblPointsPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewGameActionPerformed
        try {
            NewGame();     // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(playField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnNewGameActionPerformed

    private void BtnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHistoryActionPerformed
        try {
            FileRead();
        } catch (IOException ex) {
            Logger.getLogger(playField.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg="You won "+cntWin+" times and lost "+cntLoss+" times and had draw "+cntDraw+" times.";
        JOptionPane.showMessageDialog(null, msg, "History", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnHistoryActionPerformed

    private void BtnHitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHitActionPerformed
        player.addCard(deck.cards[indCardsOpened]);
        ImageIcon cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
        indCardsOpened++;
        
        if(!filledPlayer[2]){
            Player3.setIcon(cardIcon);
            filledPlayer[2]=true;
        }
        else if(!filledPlayer[3]){
            Player4.setIcon(cardIcon);
            filledPlayer[3]=true;
        }
        else if(!filledPlayer[4]){
            Player5.setIcon(cardIcon);
            filledPlayer[4]=true;
        }
        else if(!filledPlayer[5]){
            Player6.setIcon(cardIcon);
            filledPlayer[5]=true;
        }
        showScore();
        if(player.getScore()>=21){ try {
            EndGame();
        } catch (IOException ex) {
            Logger.getLogger(playField.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_BtnHitActionPerformed

    private void BtnStayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnStayActionPerformed
        BtnHit.setEnabled(false);
        
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.cards[indCardsOpened]);
            ImageIcon cardIcon = new ImageIcon(getClass().getResource("/blackjack1/cards/" + deck.cards[indCardsOpened].CardImgName()));
            indCardsOpened++;
            if(!filledDealer[1]){
                Dealer2.setIcon(cardIcon);
                filledDealer[1]=true;
            }
            else if(!filledDealer[2]){
                Dealer3.setIcon(cardIcon);
                filledDealer[2]=true;
            }
            else if(!filledDealer[3]){
                Dealer4.setIcon(cardIcon);
                filledDealer[3]=true;
            }
            else if(!filledDealer[4]){
                Dealer5.setIcon(cardIcon);
                filledDealer[4]=true;
            }
            else if(!filledDealer[5]){
                Player6.setIcon(cardIcon);
                filledDealer[5]=true;
            }
            showScore();
        }
        try {
            EndGame();
        } catch (IOException ex) {
            Logger.getLogger(playField.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnStayActionPerformed

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
            java.util.logging.Logger.getLogger(playField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playField.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new playField().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(playField.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnHistory;
    private javax.swing.JButton BtnHit;
    private javax.swing.JButton BtnNewGame;
    private javax.swing.JButton BtnStay;
    private javax.swing.JLabel Dealer1;
    private javax.swing.JLabel Dealer2;
    private javax.swing.JLabel Dealer3;
    private javax.swing.JLabel Dealer4;
    private javax.swing.JLabel Dealer5;
    private javax.swing.JLabel Dealer6;
    private javax.swing.JLabel LblPointsDealer;
    private javax.swing.JLabel LblPointsPlayer;
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel Player3;
    private javax.swing.JLabel Player4;
    private javax.swing.JLabel Player5;
    private javax.swing.JLabel Player6;
    private javax.swing.JPanel PnDealer;
    private javax.swing.JPanel PnPlayer;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
