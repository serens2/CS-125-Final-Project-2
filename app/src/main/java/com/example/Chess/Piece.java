package com.example.Chess;

/**
 * Class that represents a chess piece
 */
public class Piece {
    private String color;
    private String type;
    private boolean hasMoved;
    public Piece(String setColor, String setType) {
        color = setColor;
        type = setType;
    }
    public boolean move(Square from, Square to) {
        to.setPiece(this);
        from.setPiece(null);
        hasMoved = true;
        return true;
    }
    public String getColor() {
        return color;
    }
}
