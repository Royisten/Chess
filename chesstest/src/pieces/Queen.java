package pieces;

import main.GamePanel;
import main.Type;

public class Queen extends Piece {

    public Queen(int color, int col, int row) {
        super(color, col, row);
        type=Type.QUEEN;
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_queen");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_queen");
        }

    }
    
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {
            //*vertical & Horizontal movement 
            if (targetCol == preCol || targetRow == preRow) {
                if (isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow)==false) {
                    return true;
                }
            }
            //* Diagonal movement
            if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) {
                if (isValidSquare(targetCol, targetRow) && pieceIsOnDiagonalPath(targetCol, targetRow)==false) {
                    return true;
                }
            }
        }
        return false;
    }
}
