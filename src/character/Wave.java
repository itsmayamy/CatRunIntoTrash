/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author acer
 */
public class Wave {
    public int x,y,speed;
    Timer timerMove;
    
    public Wave(int x,int y,int speed,JPanel game){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.move(game);
    }
    public void move(JPanel game){
        this.timerMove = new Timer(speed,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x<0){
                    x = (int)(1000+(300+Math.random()*1000));
                }
                x -= 30;
                game.repaint();
            }
        });
        this.timerMove.start();
    }
    public BufferedImage getImage(){
        BufferedImage image=null;
        try{
            image=ImageIO.read(new File("img\\trash.png"));
            return image;
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }
}
