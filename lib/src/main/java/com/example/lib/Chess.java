package com.example.lib;

/**
 * Class that represents a game of chess
 */
public class Chess {
    Square[][] board = new Square[8][8];
    board[0][0] = new Square(new Piece(Color.BLACK, Type.ROOK));
}

/**
 * Class that represents a square on the chess board
 */
class Square {
    Piece piece;
    Square(Piece setPiece) {
        piece = setPiece;
    }
}

/**
 * Class that represents a chess piece
 */
class Piece {
    Color color;
    Type type;
    Piece(Color setColor, Type setType) {
        color = setColor;
        type = setType;
    }
}

/**
 * Class that represents the color of a chess piece
 */
class Color {
    public static final Color BLACK = new Color();
    public static final Color WHITE = new Color();
}

/**
 * Class that represents the type of a chess piece
 */
class Type {
    public static final Type PAWN = new Type();
    public static final Type KING = new Type();
    public static final Type QUEEN = new Type();
    public static final Type BISHOP = new Type();
    public static final Type KNIGHT = new Type();
    public static final Type ROOK = new Type();
}