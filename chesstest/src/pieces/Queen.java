package pieces;

import main.GamePanel;

public class Queen extends  Piece{
      public Queen(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_queen");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_queen");
        }
    }
}
