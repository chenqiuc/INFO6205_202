package edu.neu.coe.info6205.GAUI;

import edu.neu.coe.info6205.GA.Chromosome;
import edu.neu.coe.info6205.GA.GA4Game;
import edu.neu.coe.info6205.GA.GAUtil;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Graphics;

public class GameOfLife extends javax.swing.JFrame {


    final int wid = 160, hei = 160;
    boolean[][] currentMove = new boolean[hei][wid], nextMove = new boolean[hei][wid];
    boolean play;
    Image offScrImg;
    Graphics offScrGraph;

    public void setCurrentMove(int[][] board) {
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < 32; j++) {
                currentMove[i + 64][j + 64] = board[i][j] == 1;
            }
        }
    }

    public GameOfLife() {
        initComponents();
        jButton2.setVisible(false);
        offScrImg = createImage(jPanel1.getWidth(), jPanel1.getHeight());
        offScrGraph = offScrImg.getGraphics();
        Timer time = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                if(play){
                    for(int i = 0; i < hei; i++){
                        for(int j = 0; j < wid; j++){
                            nextMove[i][j] = decide(i,j);
                        }
                    }
                    for(int i = 0; i < hei; i++){
                        for(int j = 0; j < wid; j++){
                            currentMove[i][j] = nextMove[i][j];
                        }
                    }
                    repain();
                }
            }
        };
        jButton2.setVisible(false);
        time.scheduleAtFixedRate(task, 0, 100);
        repain();
    }

    private boolean decide(int i, int j){
        int neighbors = 0;
        if(j > 0){
            if(currentMove[i][j-1]) neighbors++;
            if(i>0) if(currentMove[i-1][j-1]) neighbors++;
            if(i<hei-1) if(currentMove[i+1][j-1]) neighbors++;
        }
        if(j < wid-1){
            if(currentMove[i][j+1]) neighbors++;
            if(i>0) if(currentMove[i-1][j+1]) neighbors++;
            if(i<hei-1) if(currentMove[i+1][j+1]) neighbors++;
        }
        if(i>0) if(currentMove[i-1][j]) neighbors++;
        if(i<hei-1) if(currentMove[i+1][j]) neighbors++;
        if(neighbors == 3) return true;
        if(currentMove[i][j] && neighbors == 2) return true;
        return false;
    }

    private void repain(){
        offScrGraph.setColor(jPanel1.getBackground());
        offScrGraph.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        for(int i = 0 ; i < hei ; i++){
            for(int j = 0 ; j < wid; j++){
                if(currentMove[i][j]){
                    offScrGraph.setColor(Color.YELLOW);
                    int x = j * jPanel1.getWidth()/wid;
                    int y = i * jPanel1.getHeight()/hei;
                    offScrGraph.fillRect(x, y, jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for(int i = 1; i < hei;i++){
            int y = i * jPanel1.getHeight()/hei;
            offScrGraph.drawLine(0, y, jPanel1.getWidth(), y);
        }
        for(int j = 1; j < wid;j++){
            int x = j * jPanel1.getWidth()/wid;
            offScrGraph.drawLine(x, 0, x, jPanel1.getHeight());
        }
        jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 293, Short.MAX_VALUE)
        );

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>


    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {
        offScrImg = createImage(jPanel1.getWidth(), jPanel1.getHeight());
        offScrGraph = offScrImg.getGraphics();
        repain();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        play = !play;
        if(play) jButton1.setText("Pause");
        else jButton1.setText("Play");
        repain();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
//        GAUtil test = new GAUtil();
//        GA4Game game = new GA4Game(System.currentTimeMillis());
//
//        Chromosome genotype = game.calculate();
//        String phenotype = genotype.getPattern();
//
//        int[][] board = test.transform(phenotype);
//
//        System.out.println("reason: " + genotype.getScore().getReason());
//        System.out.println("growthRate: " + genotype.getScore().getGrowthRate());
//        setCurrentMove(board);
//        repain();
    }


    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOfLife.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOfLife().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
}
