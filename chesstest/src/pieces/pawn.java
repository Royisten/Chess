package pieces;

import main.GamePanel;

public class pawn extends  Piece {

    public pawn(int color, int col, int row) {
        super(color, col, row);
        if (color==GamePanel.WHITE) {
            image.getImage("/piece/white_pawn");
        }else{
            image.getImage("/piece/black_pawn");
        }
    }
    
}
