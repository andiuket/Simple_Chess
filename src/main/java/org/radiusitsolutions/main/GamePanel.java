package org.radiusitsolutions.main;

import org.radiusitsolutions.piece.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    final int FPS = 60;
    Thread gameThread;
    Board board = new Board();
    Mouse mouse = new Mouse();
    Pieces activeP;

//    Colors
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    int currentColor = WHITE;

//    Pieces
    public static ArrayList<Pieces> pieces = new ArrayList<>();
    public static ArrayList<Pieces> simPieces = new ArrayList<>();


    public GamePanel(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.BLACK);
        addMouseMotionListener(mouse);
        addMouseListener(mouse);

        setPieces();
        copyPieces(pieces, simPieces);
    }

    public void lunchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPieces(){
//        White Color

        pieces.add(new Pawn(WHITE, 0,6));
        pieces.add(new Pawn(WHITE, 1,6));
        pieces.add(new Pawn(WHITE, 2,6));
        pieces.add(new Pawn(WHITE, 3,6));
        pieces.add(new Pawn(WHITE, 4,6));
        pieces.add(new Pawn(WHITE, 5,6));
        pieces.add(new Pawn(WHITE, 6,6));
        pieces.add(new Pawn(WHITE, 7,6));
        pieces.add(new Rook(WHITE, 0,7));
        pieces.add(new Rook(WHITE, 7,7));
        pieces.add(new Knight(WHITE, 1,7));
        pieces.add(new Knight(WHITE, 6,7));
        pieces.add(new Bishop(WHITE, 2,7));
        pieces.add(new Bishop(WHITE, 5,7));
        pieces.add(new King(WHITE, 4,7));
        pieces.add(new Queen(WHITE, 3,7));

//        Black Color

        pieces.add(new Pawn(BLACK, 0,1));
        pieces.add(new Pawn(BLACK, 1,1));
        pieces.add(new Pawn(BLACK, 2,1));
        pieces.add(new Pawn(BLACK, 3,1));
        pieces.add(new Pawn(BLACK, 4,1));
        pieces.add(new Pawn(BLACK, 5,1));
        pieces.add(new Pawn(BLACK, 6,1));
        pieces.add(new Pawn(BLACK, 7,1));
        pieces.add(new Rook(BLACK, 0,0));
        pieces.add(new Rook(BLACK, 7,0));
        pieces.add(new Knight(BLACK, 1,0));
        pieces.add(new Knight(BLACK, 6,0));
        pieces.add(new Bishop(BLACK, 2,0));
        pieces.add(new Bishop(BLACK, 5,0));
        pieces.add(new King(BLACK, 4,0));
        pieces.add(new Queen(BLACK, 3,0));



    }

    public void copyPieces(ArrayList<Pieces> source, ArrayList<Pieces> target){
        target.clear();
        for (Pieces value : source) {
            target.add(value);
        }
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
//        Mouse Button pressed
        if(mouse.pressed){
            if (activeP == null){
//                if the activeP is null, check if you can pick up a piece
                for(Pieces pieces1 : simPieces){
//                    if mouse is on an ally piece, pick it up as the activeP
                    if(pieces1.color == currentColor && pieces1.col == mouse.x/Board.SQUARE_SIZE &&
                    pieces1.row == mouse.y/Board.SQUARE_SIZE)
                    {
                        activeP = pieces1;
                    }
                }
            }
        }else {
//            if a player is holding a piece, simulate the move
            simulate();
        }
    }

    public void simulate(){
//        if a piece is being held update its position
        activeP.x = mouse.x - Board.HALF_SQUARE_SIZE;
        activeP.y = mouse.y - Board.HALF_SQUARE_SIZE;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        board.draw(g2);

        for(Pieces p : simPieces){
            p.draw(g2);
        }
    }
}
