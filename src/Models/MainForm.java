package Models;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class MainForm
            extends javax.swing.JFrame
            implements Runnable {

    private boolean left;
    private boolean right;
    private boolean restart;
    private boolean lose=false;
    boolean reiniciar = false;
    
    public MainForm() {
        initComponents();
        createBufferStrategy(2);
        Thread t = new Thread(this);
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {
     if(evt.getKeyCode() == KeyEvent.VK_LEFT) {
        left = true;
     }
     else if(evt.getKeyCode() == KeyEvent.VK_RIGHT) {
        right = true;
     } else if (evt.getKeyCode() == KeyEvent.VK_R){
        restart = true;
     }
    }

    private void formKeyReleased(java.awt.event.KeyEvent evt)
    {
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (evt.getKeyCode() == KeyEvent.VK_R) {
            restart = false;
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }


    public void run() {
        Graphics g;
        int tela = getWidth();
        Rectangles player = new Rectangles();
        player.setY(getHeight() - player.getAltura());
        Walls wall = new Walls();            
        while(true) {               
            g = getBufferStrategy().getDrawGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            player.desenhar(g);
            if (left) {
                player.setX(-2);
            }
            else {
                if (right) {
                    player.setX(2);
                }
                else {
                    player.setX(0);
                }
            }
            if(!lose)
            {
                wall.desenhar(g, tela, player.getLargura() + 20);
                wall.mover();
            }
            if(player.colisao(wall))
            {
                lose = true;
            }
            if(lose){
                g.drawString("Você perdeu!!", 100, 100);
                g.drawString("Aperte R para reiniciar.", 80, 80);
            }
            if(lose && restart)
            {                
                wall.cont = -1;
                lose=false;
                wall.isNew=true;
                wall.desenhar(g, tela, player.getLargura() + 20);
            }
            g.dispose();
            getBufferStrategy().show();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

