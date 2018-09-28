package Models;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangles {

    protected int x = 0;
    protected int y = 0;
    private int largura = 60;
    private int altura = 30;
    public boolean lose = false;
    
    public void desenhar(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, largura, altura);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, largura, altura);        
    }

    public boolean colisao(Walls wall)
    {
        if(wall.y + wall.altura >= this.y && this.y + this.altura >= wall.y) {
            if(this.x + this.largura > wall.x || this.x < wall.auxX + wall.auxLargura)
            {
                wall.setY(400);
                return true;
            }
        }
        return false;
    }
    
    public void fimdejogo(){
        this.lose = false;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x + this.x;
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
