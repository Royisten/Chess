package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource; //! Switch to "Dimesion" if ui not responding faster

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    final int FPS = 60;

    // *implement thread
    Thread gameThread;

    Board board = new Board();

    //?Piece
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();

    //?color 
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

    public GamePanel() {
        setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setPieces();
        copyPieces(pieces, simPieces);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPieces() {
        //?White
        //pawn
        pieces.add(new Pawn(WHITE,0,6));
        pieces.add(new Pawn(WHITE,1,6));
        pieces.add(new Pawn(WHITE,2,6));
        pieces.add(new Pawn(WHITE,3,6));
        pieces.add(new Pawn(WHITE,4,6));
        pieces.add(new Pawn(WHITE,5,6));
        pieces.add(new Pawn(WHITE,6,6));
        pieces.add(new Pawn(WHITE,7,6));
        //knight
        pieces.add(new Knight(WHITE,1,7));
        pieces.add(new Knight(WHITE,6,7));
        //rook
        pieces.add(new Rook(WHITE,0,7));
        pieces.add(new Rook(WHITE,7,7));
        //bishop
        pieces.add(new Bishop(WHITE,2,7));
        pieces.add(new Bishop(WHITE,5,7));
        //queen
        pieces.add(new Queen(WHITE,3,7));
        //king
        pieces.add(new King(WHITE,4,7));

        //?Black
        //pawn
        pieces.add(new Pawn(BLACK,0,1));
        pieces.add(new Pawn(BLACK,1,1));
        pieces.add(new Pawn(BLACK,2,1));
        pieces.add(new Pawn(BLACK,3,1));
        pieces.add(new Pawn(BLACK,4,1));
        pieces.add(new Pawn(BLACK,5,1));
        pieces.add(new Pawn(BLACK,6,1));
        pieces.add(new Pawn(BLACK,7,1));
        //knight
        pieces.add(new Knight(BLACK,1,0));
        pieces.add(new Knight(BLACK,6,0));
        //rook
        pieces.add(new Rook(BLACK,0,0));
        pieces.add(new Rook(BLACK,7,0));
        //bishop
        pieces.add(new Bishop(BLACK,2,0));
        pieces.add(new Bishop(BLACK,5,0));
        //queen
        pieces.add(new Queen(BLACK,3,0));
        //king
        pieces.add(new King(BLACK,4,0));

    }
    private void  copyPieces(ArrayList<Piece> source,ArrayList<Piece> target){
        target.clear();
        for (int i = 0; i < source.size(); i++) {
            target.add(source.get(i));
        }
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //?board
        board.draw(g2);
        //?pieces
        for (Piece p : simPieces) {
            p.draw(g2);
        }
    }
}
