package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class Bishop extends Pieces{
    public Bishop(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-bishop");
        }else {
            image = getImage("src/main/resources/piece/b-bishop");
        }
    }
}
