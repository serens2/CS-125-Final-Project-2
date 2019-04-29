package com.example.lib;

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
    public void move(Square from, Square to) {
        from.setPiece(this);
        to.setPiece(null);
    }
}
