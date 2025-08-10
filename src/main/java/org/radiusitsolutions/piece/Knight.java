package org.radiusitsolutions.piece;

import org.radiusitsolutions.main.GamePanel;

public class Knight extends Pieces{
    public Knight(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("src/main/resources/piece/w-knight");
        }else {
            image = getImage("src/main/resources/piece/b-knight");
        }
    }
}
