/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author acer
 */
public class Environment {
    public int x,y,startx,speed;
    private Timer timeMove;
    
    public Environment(int x,int y,JPanel page,int speed){
        this.x = x;
        this.y = y;
        this.startx = x;
        this.speed = speed;
        this.move(page);
    }
    
    public void move(JPanel page){
        this.timeMove = new Timer(10,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x+400 < 0){
                    x = startx;
                }
                x -= speed;
                page.repaint();
            }
        });
        this.timeMove.start();
    }
    
    public void stop(){
        this.timeMove.stop();
    }
    
}
