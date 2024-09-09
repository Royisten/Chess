package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // used JFrame from Swinfg to create a window!
        JFrame window = new JFrame("Simple Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        // added the panel
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //calls this method when the window is created
        gp.launchGame();
    }
}
