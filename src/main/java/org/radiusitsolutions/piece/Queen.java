package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class Queen extends Pieces{
    public Queen(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-queen");
        }else {
            image = getImage("src/main/resources/piece/b-queen");
        }
    }
}
