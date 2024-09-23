package pieces;

import main.GamePanel;

public class Bishop extends Piece {

    public Bishop(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_bishop");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_bishop");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {
            //*row difference = col difference
            if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)) {
                if (isValidSquare(targetCol, targetRow) && pieceIsOnDiagonalPath(targetCol, targetRow) == false) {
                    return true;
                }
            }
        }
        return false;
    }
}
