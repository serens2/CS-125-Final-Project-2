package com.example.Chess;

/**
 * Class that represents a square on a chess board
 */
public class Square {
    private Piece piece;
    public Square(Piece setPiece) {
        piece = setPiece;
    }
    Piece getPiece() {
        return piece;
    }
    void setPiece(Piece setPiece) {
        piece = setPiece;
    }
}