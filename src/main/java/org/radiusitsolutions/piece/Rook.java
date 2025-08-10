package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class Rook extends Pieces{
    public Rook(int color, int col, int row) {
        super(color, col, row);
        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-rook");
        }else {
            image = getImage("src/main/resources/piece/b-rook");
        }

    }
}
