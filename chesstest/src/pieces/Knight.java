package pieces;

import main.GamePanel;

public class Knight extends Piece {
    
     public Knight(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_knight");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_knight");
        }
    }
     @Override
    public boolean  canMove(int targetCol ,int targetRow){
        if (isWithinBoard(targetCol, targetRow)) {
            //?knight movement ratio 1:2 ,2:1
            if (Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 2) {
                if (isValidSquare(targetCol, targetRow)) {
                    return  true;
                }
            }
        }
        return  false;  
    }
}
