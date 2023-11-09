/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import Element.EleButton;
import Element.EleLabel;
/**
 *
 * @author acer
 */
public class Menu extends JPanel {
    public long point;
    
    public Menu(){
        
    }
    
    public Menu(long point,ActionListener main){
        try{
            this.point = point;
            this.setBackground(new Color(241,98,69));
            this.setBounds(0, 0, 1000, 600);
            this.setFocusable(true);
            this.setLayout(null);
            
            EleLabel status = new EleLabel("You Died!",40,400,150,200,100);
            status.setForeground(Color.WHITE);
            
            EleLabel showPoint = new EleLabel("Total :"+this.point,30,400,200,200,100);
            status.setForeground(Color.WHITE);
            
            EleButton restart = new EleButton("restart",15,340,300,200,50);
            restart.addActionListener(main);
            
            this.add(showPoint);
            this.add(status);
            this.add(restart);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
