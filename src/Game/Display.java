/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author acer
 */
public class Display extends JFrame implements ActionListener {

    private Dimension size = new Dimension(1000, 600);

    public Display() {
        this.setting();
        this.getContentPane().add(new Game());
    }

    private void setting() {
        Game.display = this;

        this.setTitle("Littlecat game");
        this.setSize(900, 485);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(280, 100);
        this.setVisible(true);
    }

    private void removeContent() {
        this.getContentPane().removeAll();
        this.getContentPane().repaint();
    }

    public void endGame(long point) {
        removeContent();
        this.getContentPane().add(new Menu(point, this));
    }

    public static void main(String[] arg) {
        Display display = new Display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("restart")) {
            removeContent();
            Game game = new Game();
            this.getContentPane().add(game);
            game.requestFocus();
        }
    }
}
