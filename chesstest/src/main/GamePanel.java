package main;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource; //FIXME ; Switch to "Dimesion" if ui not responding faster

public class GamePanel extends JPanel{
    public static final int WIDTH = 1100;  
    public static final int HEIGHT = 800;  
  
    public GamePanel (){
        setPreferredSize(new DimensionUIResource(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
    }
}
