package pieces;

import main.GamePanel;

public class King extends Piece {

    public King(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_king");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_king");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow)) {
            if (Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
                Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) {
                return true;
            }

        }
        return false;
    }
}
