package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource; //! Switch to "Dimesion" if ui not responding faster

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;

    // *implement thread
    Thread gameThread;

    public GamePanel() {
        setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //* GameLoop
        // Calculate the interval between frames in nanoseconds
        // FPS stands for "Frames Per Second". This controls how fast the game should
        // run.
        double drawInterval = 1000000000 / FPS;// 1 second = 1 billion nanoseconds
        double delta = 0;// Will store the time difference between frames

        // Get the current time in nanoseconds to track frame timing
        long lastTime = System.nanoTime();
        long currentTime;

        // Main game loop, which continues to run while the game thread is active
        while (gameThread != null) {
            // Get the current time in nanoseconds
            currentTime = System.nanoTime();

            // Calculate the time passed since the last frame and normalize by the draw interval
            // This helps track how much of a frame has passed, even if it's less than a full frame
            delta += (currentTime - lastTime) / drawInterval;
            // Update the last time marker to the current time for the next loop iteration
            lastTime = currentTime;

            // If enough time has passed to display a new frame (i.e., delta >= 1)
            if (delta >= 1) {
                // Call the update method to update game logic
                update();
                // Call the repaint method to refresh the screen and render the updated visuals
                repaint();
                // Decrease delta by 1 to account for the processed frame
                delta--;
            }
        }

    }

    // !the above method calls the update and paintComponent 60 times per second
    private void update() {

    }

    private void PaintComponenet(Graphics g) {
        super.PaintComponenet(g);
    }
}
