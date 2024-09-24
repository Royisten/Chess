package pieces;

import main.GamePanel;

public class Pawn extends Piece {

    public Pawn(int color, int col, int row) {
        super(color, col, row);
        if (color == GamePanel.WHITE) {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/white_pawn");
        } else {
            image = getImage("/mnt/c/Users/Royisten Silva/OneDrive/Desktop/PHILL/chesstest/src/res/piece/black_pawn");
        }
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {
            //define movement based on color
            int moveValue;
            if (color == GamePanel.WHITE) {
                moveValue = -1;
            } else {
                moveValue = 1;
            }
            //? check if piece is hitting an another piece (ally/foe)
            hittingP = getHittingP(targetCol, targetRow);

            //? 1 Square movement
            if (targetCol == preCol && targetRow == preRow + moveValue && hittingP == null) {
                return true;
            }
            //? 2 square movement
            if (targetCol == preCol && targetRow == preRow + moveValue * 2 && hittingP == null && moved == false
                    && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                return true;
            }
            //?Diagonal movement & capture if a foe is on the diagonal path
            if (Math.abs(targetCol-preCol)==1 && targetRow==preRow + moveValue && hittingP!= null
                     && hittingP.color!=color) {
                return  true;
            }

        }
        return false;
    }

}
