package com.example.lib;

/**
 * Class that represents a game of chess
 */
public class Chess {
    Square[][] board = new Square[8][8];
}

/**
 * Abstract class that represents a chess piece
 */
abstract class Piece {
    Color color;
    Position position;
    Piece(Color setColor, Position setPosition) {
        color = setColor;
        position = setPosition;
    }
}

/**
 * Class that represents a pawn
 */
class Pawn extends Piece {
    Pawn(Color setColor, Position setPosition) {
        super(setColor, setPosition);
    }
    void move() {
        position.longitude++;
    }
}

/**
 * Class that represents a position on a chess board
 */
class Position {
    int latitude;
    int longitude;
}

/**
 * Class that represents a square on the chess board
 */
class Square {
    Position position;
    Piece piece;
    boolean occupied;
}

/**
 * Class that represents the color of a chess piece
 */
class Color {
    public static final Color BLACK = new Color();
    public static final Color WHITE = new Color();
}