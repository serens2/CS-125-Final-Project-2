package com.example.finalprojectattempt;

/**
 * Class that represents a game of chess
 */
public class Chess {
    Square[][] board;
    public Chess() {
        board = new Square[][]{
                {
                        //first row of the board
                        new Square(new Piece("white", "rook")),
                        new Square(new Piece("white", "knight")),
                        new Square(new Piece("white", "bishop")),
                        new Square(new Piece("white", "queen")),
                        new Square(new Piece("white", "king")),
                        new Square(new Piece("white", "bishop")),
                        new Square(new Piece("white", "knight")),
                        new Square(new Piece("white", "rook"))
                }, {
                //second row of the board
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn")),
                new Square(new Piece("white", "pawn"))
        }, {
                //third row of the board
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null)
        }, {
                //fourth row of the board
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null)
        }, {
                //fifth row of the board
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null)
        }, {
                //sixth row of the board
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null),
                new Square(null)
        }, {
                //seventh row of the board
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn")),
                new Square(new Piece("black", "pawn"))
        }, {
                //eighth row of the board
                new Square(new Piece("black", "rook")),
                new Square(new Piece("black", "knight")),
                new Square(new Piece("black", "bishop")),
                new Square(new Piece("black", "queen")),
                new Square(new Piece("black", "king")),
                new Square(new Piece("black", "bishop")),
                new Square(new Piece("black", "knight")),
                new Square(new Piece("black", "rook"))
        }
        };
    }
    public void move(Piece piece, Square from, Square to) {
        piece.move(from, to);
    }
}