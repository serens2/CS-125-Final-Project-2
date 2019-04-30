package com.example.finalprojectattempt;

/**
 * Class that represents a chess piece
 */
public class Piece {
    private String color;
    private String type;
    public Piece(String setColor, String setType) {
        color = setColor;
        type = setType;
    }
    public boolean move(Square from, Square to) {
        to.setPiece(this);
        from.setPiece(null);
        return true;
    }
    public String getColor() {
        return color;
    }
}
