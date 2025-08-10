package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class Pawn extends Pieces{

    public Pawn(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-pawn");
        }else {
            image = getImage("src/main/resources/piece/b-pawn");
        }
    }
}
