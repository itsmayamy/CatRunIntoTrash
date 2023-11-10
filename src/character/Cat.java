/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author acer
 */
public class Cat extends JPanel {
    public int x, y, catSize = 60, health = 180;
    public static int speed = 90;
    private int jumpHigh = 100;

    private BufferedImage img;

    public Cat(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void jump(JPanel game) {
        this.y -= speed;
        game.repaint();
        Timer timer = new Timer(450, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += speed;
                game.repaint();
            }

        });
        timer.setRepeats(false);
        timer.start();
    }

    public BufferedImage getImage() {
        if (img != null)
            return img;

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("img\\cat.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
