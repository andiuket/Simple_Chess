package org.radiusitsolutions.piece;
import org.radiusitsolutions.main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pieces {
    public BufferedImage image;
    public int x, y;
    public int row, col, preRow, preCol;
    public int color;

    public Pieces(int color, int col, int row){
        this.color = color;
        this.col = col;
        this.row = row;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }

    public BufferedImage getImage(String imagePath){
        BufferedImage img = null;

        try{
            img = ImageIO.read(new File(imagePath + ".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return img;
    }

    public int getX(int col){
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row){
        return row * Board.SQUARE_SIZE;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }

}
