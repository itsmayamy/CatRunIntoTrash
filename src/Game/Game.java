/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.*;
import javax.swing.*;
import character.*;
import event.Event;
import Element.Element;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author acer
 */
public class Game extends JPanel implements KeyListener {

    int speed = 10;
    int waveHeight = 60;
    int catSize = 90;
    int base = 400, xstart = 1000;
    long point = 0;
    long lastPress = 0;
    Cat cat = new Cat(100, base - 85);
    static Display display;

    Wave[] waveSet = makeWaveSet(4);

    public Game() {
        this.setBounds(0, 0, 1000, 600);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            this.drawBackground(g2);

            g2.setColor(Color.red);
            drawCatHealth(g2);

            g2.setFont(Element.getFont(30));
            g2.setColor(Color.white);
            g2.drawString("Point : " + point, 750, 40);

            g2.drawImage(cat.getImage(), cat.x, cat.y, catSize, catSize, this);

            for (Wave item : waveSet) {
                drawWave(item, g2);
            }
            this.point += 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawBackground(Graphics g2) throws IOException {
        g2.drawImage(ImageIO.read(new File("img\\bg2.png")), 0, 0, 1000, 550, null);
        g2.drawImage(ImageIO.read(new File("img\\bg.png")), 0, base - 200, 1000, 250, null);
    }

    private void drawCatHealth(Graphics2D g2) {
        try {
            g2.drawImage(ImageIO.read(new File("img\\heart.png")), 2, 10, 60, 50, null);
            g2.setStroke(new BasicStroke(18.0f));
            g2.setColor(new Color(241, 98, 69));
            g2.drawLine(60, 30, 60 + cat.health, 30);
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(6.0f));
            g2.drawRect(50, 20, 200, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Wave[] makeWaveSet(int waveNumber) {
        Wave[] waveSet = new Wave[waveNumber];
        int far = 500;
        for (int i = 0; i < waveNumber; i++) {
//            double waveLocation = 1000+Math.floor(Math.random()*1000);
            waveSet[i] = new Wave(xstart + far, base, speed, this);
            far += 500;
        }
        return waveSet;
    }

    private void drawWave(Wave wave, Graphics2D g2) {
        g2.drawImage(wave.getImage(), wave.x, (wave.y - waveHeight), 80, waveHeight + 40, null);
        if (Event.checkHit(cat, wave, catSize, waveHeight)) {
            g2.setColor(new Color(241, 98, 69));
            g2.drawRect(0, 0, 935, 444);
            cat.health -= 10;
            if (cat.health <= 0) {
                System.out.println("Game over");
                display.endGame(this.point);
                cat.health = new Cat(100, base - 85).health;
                this.point = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (System.currentTimeMillis() - lastPress > 600) {
            if (e.getKeyCode() == 38 || e.getKeyCode() == 32) {
                cat.jump(this);
                lastPress = System.currentTimeMillis();
//                this.repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
