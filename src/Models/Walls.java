package Models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Walls{   
    
    protected int x;
    protected int y;
    protected int largura;
    protected int altura = 20;
    protected int auxX;
    protected int auxLargura;
    protected int cont=-1;
    protected boolean isNew = true;
    
    
    Random r = new Random();
    
    public void desenhar(Graphics g, int tela, int tamPlayer) {        
        if(isNew == true)
        {            
            int larg;
            x=0;
            y=50;
            larg = r.nextInt(tela);
            while(larg>tela - 80)
            {
                larg = r.nextInt(tela);
            }        
            g.setColor(Color.BLACK);
            g.fillRect(x, y, larg, altura);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, larg, altura);
            auxX = x;
            auxLargura = larg;
            largura = tela - larg - tamPlayer + 20;
            x = x + larg + tamPlayer + 2;
            g.setColor(Color.BLACK);            
            g.fillRect(x, y, largura, altura);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, largura, altura);
            isNew = false;            
            g.setColor(Color.RED);
            g.drawString(Integer.toString(cont), 50, 50);
            cont++;
        }
        else
        {
            g.setColor(Color.BLACK);
            g.fillRect(auxX, y, auxLargura, altura);
            g.setColor(Color.BLACK);
            g.drawRect(auxX, y, auxLargura, altura);
            g.setColor(Color.BLACK);            
            g.fillRect(x, y, largura, altura);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, largura, altura);
            g.drawString(Integer.toString(cont), 50, 50);
            
        }
    }

    public void mover() {
        y++;
        if(y > 330)
           isNew = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
