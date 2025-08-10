package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class King extends Pieces{
    public King(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-king");
        }else {
            image = getImage("src/main/resources/piece/b-king");
        }
    }
}
