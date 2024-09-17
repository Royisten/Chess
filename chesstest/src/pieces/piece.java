package pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Board;

public class Piece {

    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;

    public Piece(int color, int col, int row) {
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }
    public BufferedImage getImage(String imagePath){
      BufferedImage image= null;
      try {
           // Use ImageIO.read with a File instead of getResourceAsStream for absolute paths
           image = ImageIO.read(new java.io.File(imagePath + ".png"));
      } catch (IOException e) {
        System.out.println("Could not load image from: " + imagePath);
        e.printStackTrace();
      }
      return  image;
      
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }
    public int getCol(int x){
      return  (x+Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public int getRow(int x){
      return  (y+Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
    }
    public void updatePosition(){
      x=getX(col);
      y=getY(row);
      preCol= getCol(x);
      preRow = getRow(x);
      
    }
    
    public void resetPosition() {
      col=preCol;
      row=preRow;
      x=getX(col);
      y=getY(row);
    }

   
    public boolean  canMove(int targetCol , int targetRow){
        return false;
    }
    public  boolean  isWithinBoard(int targetCol , int targetRow){
      return  targetCol >= 0 && targetCol<=7 && targetRow >= 0 && targetRow<=7;
    }
    public  void draw (Graphics2D g2){
      g2.drawImage(image, x, y,Board.SQUARE_SIZE,Board.SQUARE_SIZE,null);
    }

    
}
