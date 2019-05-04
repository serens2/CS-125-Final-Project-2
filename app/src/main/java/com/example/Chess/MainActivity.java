package com.example.Chess;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private int WP1 = R.drawable.white_pawn1;
    private int WP2 = R.drawable.white_pawn2;
    private int WP3 = R.drawable.white_pawn3;
    private int WP4 = R.drawable.white_pawn4;
    private int WP5 = R.drawable.white_pawn5;
    private int WP6 = R.drawable.white_pawn6;
    private int WP7 = R.drawable.white_pawn7;
    private int WP8 = R.drawable.white_pawn8;
    private int BP1= R.drawable.black_pawn1;
    private int BP2 = R.drawable.black_pawn2;
    private int BP3 = R.drawable.black_pawn3;
    private int BP4 = R.drawable.black_pawn4;
    private int BP5 = R.drawable.black_pawn5;
    private int BP6 = R.drawable.black_pawn6;
    private int BP7 = R.drawable.black_pawn7;
    private int BP8 = R.drawable.black_pawn8;
    private int WR1 = R.drawable.white_rook1;
    private int WR2 = R.drawable.white_rook2;
    private int BR1 = R.drawable.black_rook1;
    private int BR2 = R.drawable.black_rook2;
    private int WB1 = R.drawable.white_bishop1;
    private int WB2 = R.drawable.white_bishop2;
    private int BB1 = R.drawable.black_bishop1;
    private int BB2 = R.drawable.black_bishop2;
    private int WKn1 = R.drawable.white_knight1;
    private int WKn2 = R.drawable.white_knight2;
    private int BKn1 = R.drawable.black_knight1;
    private int BKn2 = R.drawable.black_knight2;
    private int WQ = R.drawable.white_queen;
    private int BQ = R.drawable.black_queen;
    private int WK = R.drawable.white_king;
    private int BK = R.drawable.black_king;
    private ImageView previousSquare;
    private int previousSquareId;
    private boolean whiteToMove = true;
    private TextView turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        final ImageView A1 = findViewById(R.id.A1);
        final ImageView A2 = findViewById(R.id.A2);
        final ImageView A3 = findViewById(R.id.A3);
        final ImageView A4 = findViewById(R.id.A4);
        final ImageView A5 = findViewById(R.id.A5);
        final ImageView A6 = findViewById(R.id.A6);
        final ImageView A7 = findViewById(R.id.A7);
        final ImageView A8 = findViewById(R.id.A8);

        final ImageView B1 = findViewById(R.id.B1);
        final ImageView B2 = findViewById(R.id.B2);
        final ImageView B3 = findViewById(R.id.B3);
        final ImageView B4 = findViewById(R.id.B4);
        final ImageView B5 = findViewById(R.id.B5);
        final ImageView B6 = findViewById(R.id.B6);
        final ImageView B7 = findViewById(R.id.B7);
        final ImageView B8 = findViewById(R.id.B8);

        final ImageView C1 = findViewById(R.id.C1);
        final ImageView C2 = findViewById(R.id.C2);
        final ImageView C3 = findViewById(R.id.C3);
        final ImageView C4 = findViewById(R.id.C4);
        final ImageView C5 = findViewById(R.id.C5);
        final ImageView C6 = findViewById(R.id.C6);
        final ImageView C7 = findViewById(R.id.C7);
        final ImageView C8 = findViewById(R.id.C8);

        final ImageView D1 = findViewById(R.id.D1);
        final ImageView D2 = findViewById(R.id.D2);
        final ImageView D3 = findViewById(R.id.D3);
        final ImageView D4 = findViewById(R.id.D4);
        final ImageView D5 = findViewById(R.id.D5);
        final ImageView D6 = findViewById(R.id.D6);
        final ImageView D7 = findViewById(R.id.D7);
        final ImageView D8 = findViewById(R.id.D8);

        final ImageView E1 = findViewById(R.id.E1);
        final ImageView E2 = findViewById(R.id.E2);
        final ImageView E3 = findViewById(R.id.E3);
        final ImageView E4 = findViewById(R.id.E4);
        final ImageView E5 = findViewById(R.id.E5);
        final ImageView E6 = findViewById(R.id.E6);
        final ImageView E7 = findViewById(R.id.E7);
        final ImageView E8 = findViewById(R.id.E8);

        final ImageView F1 = findViewById(R.id.F1);
        final ImageView F2 = findViewById(R.id.F2);
        final ImageView F3 = findViewById(R.id.F3);
        final ImageView F4 = findViewById(R.id.F4);
        final ImageView F5 = findViewById(R.id.F5);
        final ImageView F6 = findViewById(R.id.F6);
        final ImageView F7 = findViewById(R.id.F7);
        final ImageView F8 = findViewById(R.id.F8);

        final ImageView G1 = findViewById(R.id.G1);
        final ImageView G2 = findViewById(R.id.G2);
        final ImageView G3 = findViewById(R.id.G3);
        final ImageView G4 = findViewById(R.id.G4);
        final ImageView G5 = findViewById(R.id.G5);
        final ImageView G6 = findViewById(R.id.G6);
        final ImageView G7 = findViewById(R.id.G7);
        final ImageView G8 = findViewById(R.id.G8);

        final ImageView H1 = findViewById(R.id.H1);
        final ImageView H2 = findViewById(R.id.H2);
        final ImageView H3 = findViewById(R.id.H3);
        final ImageView H4 = findViewById(R.id.H4);
        final ImageView H5 = findViewById(R.id.H5);
        final ImageView H6 = findViewById(R.id.H6);
        final ImageView H7 = findViewById(R.id.H7);
        final ImageView H8 = findViewById(R.id.H8);

        H1.setTag(R.drawable.white_rook1);
        H2.setTag(R.drawable.white_knight1);
        H3.setTag(R.drawable.white_bishop1);
        H4.setTag(R.drawable.white_queen);
        H5.setTag(R.drawable.white_king);
        H6.setTag(R.drawable.white_bishop2);
        H7.setTag(R.drawable.white_knight2);
        H8.setTag(R.drawable.white_rook2);

        G1.setTag(R.drawable.white_pawn1);
        G2.setTag(R.drawable.white_pawn2);
        G3.setTag(R.drawable.white_pawn3);
        G4.setTag(R.drawable.white_pawn4);
        G5.setTag(R.drawable.white_pawn5);
        G6.setTag(R.drawable.white_pawn6);
        G7.setTag(R.drawable.white_pawn7);
        G8.setTag(R.drawable.white_pawn8);

        F1.setTag(R.drawable.transparent);
        F2.setTag(R.drawable.transparent);
        F3.setTag(R.drawable.transparent);
        F4.setTag(R.drawable.transparent);
        F5.setTag(R.drawable.transparent);
        F6.setTag(R.drawable.transparent);
        F7.setTag(R.drawable.transparent);
        F8.setTag(R.drawable.transparent);

        E1.setTag(R.drawable.transparent);
        E2.setTag(R.drawable.transparent);
        E3.setTag(R.drawable.transparent);
        E4.setTag(R.drawable.transparent);
        E5.setTag(R.drawable.transparent);
        E6.setTag(R.drawable.transparent);
        E7.setTag(R.drawable.transparent);
        E8.setTag(R.drawable.transparent);

        D1.setTag(R.drawable.transparent);
        D2.setTag(R.drawable.transparent);
        D3.setTag(R.drawable.transparent);
        D4.setTag(R.drawable.transparent);
        D5.setTag(R.drawable.transparent);
        D6.setTag(R.drawable.transparent);
        D7.setTag(R.drawable.transparent);
        D8.setTag(R.drawable.transparent);

        C1.setTag(R.drawable.transparent);
        C2.setTag(R.drawable.transparent);
        C3.setTag(R.drawable.transparent);
        C4.setTag(R.drawable.transparent);
        C5.setTag(R.drawable.transparent);
        C6.setTag(R.drawable.transparent);
        C7.setTag(R.drawable.transparent);
        C8.setTag(R.drawable.transparent);

        B1.setTag(R.drawable.black_pawn1);
        B2.setTag(R.drawable.black_pawn2);
        B3.setTag(R.drawable.black_pawn3);
        B4.setTag(R.drawable.black_pawn4);
        B5.setTag(R.drawable.black_pawn5);
        B6.setTag(R.drawable.black_pawn6);
        B7.setTag(R.drawable.black_pawn7);
        B8.setTag(R.drawable.black_pawn8);

        A1.setTag(R.drawable.black_rook1);
        A2.setTag(R.drawable.black_knight1);
        A3.setTag(R.drawable.black_bishop1);
        A4.setTag(R.drawable.black_queen);
        A5.setTag(R.drawable.black_king);
        A6.setTag(R.drawable.black_bishop2);
        A7.setTag(R.drawable.black_knight2);
        A8.setTag(R.drawable.black_rook2);

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A1);
            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A2);
            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A3);
            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A4);
            }
        });

        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A5);
            }
        });

        A6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A6);
            }
        });

        A7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A7);
            }
        });

        A8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(A8);
            }
        });

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B1);
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B2);
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B3);
            }
        });

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B4);
            }
        });

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B5);
            }
        });

        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B6);
            }
        });

        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B7);
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(B8);
            }
        });

        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C1);
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C2);
            }
        });

        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C3);
            }
        });

        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C4);
            }
        });

        C5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C5);
            }
        });

        C6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C6);
            }
        });

        C7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C7);
            }
        });

        C8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(C8);
            }
        });

        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D1);
            }
        });

        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D2);
            }
        });

        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D3);
            }
        });

        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D4);
            }
        });

        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D5);
            }
        });

        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D6);
            }
        });

        D7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D7);
            }
        });

        D8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(D8);
            }
        });

        E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E1);
            }
        });

        E2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E2);
            }
        });

        E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E3);
            }
        });

        E4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E4);
            }
        });

        E5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E5);
            }
        });

        E6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E6);
            }
        });

        E7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E7);
            }
        });

        E8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(E8);
            }
        });

        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F1);
            }
        });

        F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F2);
            }
        });

        F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F3);
            }
        });

        F4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F4);
            }
        });

        F5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F5);
            }
        });

        F6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F6);
            }
        });

        F7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F7);
            }
        });

        F8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(F8);
            }
        });

        G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G1);
            }
        });

        G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G2);
            }
        });

        G3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G3);
            }
        });

        G4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G4);
            }
        });

        G5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G5);
            }
        });

        G6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G6);
            }
        });

        G7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G7);
            }
        });

        G8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(G8);
            }
        });

        H1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H1);
            }
        });

        H2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H2);
            }
        });

        H3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H3);
            }
        });

        H4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H4);
            }
        });

        H5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H5);
            }
        });

        H6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H6);
            }
        });

        H7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H7);
            }
        });

        H8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(H8);
            }
        });
    }

    public void go(ImageView square) {
        if (previousSquare == null) {
            previousSquare = square;
            previousSquareId = (int) square.getTag();
        } else {
            move(previousSquareId, previousSquare, square);
            previousSquare = null;
        }
    }

    public void move(int piece, ImageView from, ImageView to) {
        turn = findViewById(R.id.turnDisplay);
        int moveTo = (int) to.getTag();
        if (piece == R.drawable.transparent) {
            return;
        }
        if (whiteToMove) {
            if (piece == BB1 || piece == BB2 || piece == BK || piece == BKn1 || piece == BKn2 || piece == BP1 || piece == BP2 || piece == BP3 || piece == BP4 || piece == BP5 || piece == BP6 || piece == BP7 || piece == BP8 || piece == BQ || piece == BR1 || piece == BR2) {
                return;
            }
            if (moveTo == WB1 || moveTo == WB2 || moveTo == WK || moveTo == WKn1 || moveTo == WKn2 || moveTo == WP1 || moveTo == WP2 || moveTo == WP3 || moveTo == WP4 || moveTo == WP5 || moveTo == WP6 || moveTo == WP7 || moveTo == WP8 || moveTo == WQ || moveTo == WR1 || moveTo == WR2) {
                return;
            }
            if (piece == WP1 || piece == WP2 || piece == WP3 || piece == WP4 || piece == WP5 || piece == WP6 || piece == WP7 || piece == WP8) {
                if (canPawnMove(piece, to.getId())) {
                    from.setImageResource(R.drawable.transparent);
                    from.setTag(R.drawable.transparent);
                    to.setImageResource(piece);
                    to.setTag(piece);
                    whiteToMove = false;
                    turn.setText(R.string.black_to_move);
                }
            }
        } else {
            if (moveTo == BB1 || moveTo == BB2 || moveTo == BK || moveTo == BKn1 || moveTo == BKn2 || moveTo == BP1 || moveTo == BP2 || moveTo == BP3 || moveTo == BP4 || moveTo == BP5 || moveTo == BP6 || moveTo == BP7 || moveTo == BP8 || moveTo == BQ || moveTo == BR1 || moveTo == BR2) {
                return;
            }
            if (piece == WP1 || piece == WP2 || piece == WP3 || piece == WP4 || piece == WP5 || piece == WP6 || piece == WP7 || piece == WP8 || piece == WB1 || piece == WB2 || piece == WK || piece == WQ || piece == WKn1 || piece == WKn2 || piece == WR1 || piece == WR2) {
                return;
            }
            from.setImageResource(R.drawable.transparent);
            from.setTag(R.drawable.transparent);
            to.setImageResource(piece);
            to.setTag(piece);
            whiteToMove = true;
            turn.setText(R.string.white_to_move);
        }
    }

    /**
     * Simulation of the board to help provide constraints.
     */
    String[][] board = {
            { "blackRook1", "blackKnight1", "blackBishop1", "blackQueen", "blackKing", "blackBishop2", "blackKnight2", "blackRook2" },
            { "noBlackPawn1", "noBlackPawn2", "noBlackPawn3", "noBlackPawn4", "noBlackPawn5", "noBlackPawn6", "noBlackPawn7", "noBlackPawn8" },
            { "null", "null", "null", "null", "null", "null", "null", "null" },
            { "null", "null", "null", "null", "null", "null", "null", "null" },
            { "null", "null", "null", "null", "null", "null", "null", "null" },
            { "null", "null", "null", "null", "null", "null", "null", "null" },
            { "noWhitePawn1", "noWhitePawn2", "noWhitePawn3", "noWhitePawn4", "noWhitePawn5", "noWhitePawn6", "noWhitePawn7", "noWhitePawn8" },
            { "whiteRook1", "whiteKnight1", "whiteBishop1", "whiteKing", "whiteKing", "whiteBishop2", "whiteKnight2", "whiteKnight2"}
    };

    /**
     * This method converts the array location to a location on the board.
     * @param i The y-component of the array
     * @param j The x-component of the array
     * @return The id of the location on the game board
     */
    public int converter(int i, int j) {
        String location;
        String letter;
        String number;
        if (i == 1) {
            letter = "B";
        } else if (i == 2) {
            letter = "C";
        } else if (i == 3) {
            letter = "D";
        } else if (i == 4) {
            letter = "E";
        } else {
            letter = "F";
        }
        if (j == 0) {
            number = "1";
        } else if (j == 1) {
            number = "2";
        } else if (j == 2) {
            number = "3";
        } else if (j == 3) {
            number = "4";
        } else if (j == 4) {
            number = "5";
        } else if (j == 5) {
            number = "6";
        } else {
            number = "7";
        }
        location = letter + number;
        if (location.equals("B1")) {
            return R.id.B1;
        } else if (location.equals("B2")) {
            return R.id.B2;
        } else if (location.equals("B3")) {
            return R.id.B3;
        } else if (location.equals("B4")) {
            return R.id.B4;
        } else if (location.equals("B5")) {
            return R.id.B5;
        } else if (location.equals("B6")) {
            return R.id.B6;
        } else if (location.equals("B7")) {
            return R.id.B7;
        } else if (location.equals("C1")) {
            return R.id.C1;
        } else if (location.equals("C2")) {
            return R.id.C2;
        } else if (location.equals("C3")) {
            return R.id.C3;
        } else if (location.equals("C4")) {
            return R.id.C4;
        } else if (location.equals("C5")) {
            return R.id.C5;
        } else if (location.equals("C6")) {
            return R.id.C6;
        } else if (location.equals("C7")) {
            return R.id.C7;
        } else if (location.equals("D1")) {
            return R.id.D1;
        } else if (location.equals("D2")) {
            return R.id.D2;
        } else if (location.equals("D3")) {
            return R.id.D3;
        } else if (location.equals("D4")) {
            return R.id.D4;
        } else if (location.equals("D5")) {
            return R.id.D5;
        } else if (location.equals("D6")) {
            return R.id.D6;
        } else if (location.equals("D7")) {
            return R.id.D7;
            //Will continue ASAP
        }
        return -1;
    }

    /**
     * Method to check if the attempt to move the pawn is valid.
     * @param piece Which pawn on the board it is
     * @param moveTo Where the piece is being attempted to move to
     * @return True if successful, false otherwise
     */
    public boolean canPawnMove(int piece, int moveTo) {
        if (piece == WP1) {
            if (board[6][0].equals("noWhitePawn1")) {
                if (R.id.F1 == moveTo) {
                    board[5][0] = "whitePawn1";
                    board[6][0] = "null";
                    return true;
                } else if (R.id.E1 == moveTo && board[5][0].equals("null")) {
                    board[4][0] = "whitePawn1";
                    board[6][0] = "null";
                    return true;
                }
            }
            for (int i = 1; i < 6; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals("whitePawn") && board[i - 1][j].equals("null")) {
                        //will complete soon.
                            return true;
                    }
                }
            }
        }
        if (piece == WP2) {
            if (board[6][1].equals("noWhitePawn2")) {
                if (R.id.F2 == moveTo) {
                    board[5][1] = "whitePawn2";
                    board[6][1] = "null";
                    return true;
                } else if (R.id.E2 == moveTo && board[5][1].equals("null")) {
                    board[4][1] = "whitePawn2";
                    board[6][1] = "null";
                    return true;
                }
            }
        }
        if (piece == WP3) {
            if (board[6][2].equals("noWhitePawn3")) {
                if (R.id.F3 == moveTo) {
                    board[5][2] = "whitePawn3";
                    board[6][2] = "null";
                    return true;
                } else if (R.id.E3 == moveTo && board[5][2].equals("null")) {
                    board[4][2] = "whitePawn3";
                    board[6][2] = "null";
                    return true;
                }
            }
        }
        if (piece == WP4) {
            if (board[6][3].equals("noWhitePawn4")) {
                if (R.id.F4 == moveTo) {
                    board[5][3] = "whitePawn4";
                    board[6][3] = "null";
                    return true;
                } else if (R.id.E4 == moveTo && board[5][3].equals("null")) {
                    board[4][3] = "whitePawn4";
                    board[6][3] = "null";
                    return true;
                }
            }
        }
        if (piece == WP5) {
            if (board[6][4].equals("noWhitePawn5")) {
                if (R.id.F5 == moveTo) {
                    board[5][4] = "whitePawn5";
                    board[6][4] = "null";
                    return true;
                } else if (R.id.E5 == moveTo && board[5][4].equals("null")) {
                    board[4][4] = "whitePawn5";
                    board[4][4] = "null";
                    return true;
                }
            }
        }
        if (piece == WP6) {
            if (board[6][5].equals("noWhitePawn6")) {
                if (R.id.F6 == moveTo) {
                    board[5][5] = "whitePawn6";
                    board[6][5] = "null";
                    return true;
                } else if (R.id.E6 == moveTo && board[5][5].equals("null")) {
                    board[5][5] = "whitePawn6";
                    board[6][5] = "null";
                    return true;
                }
            }
        }
        if (piece == WP7) {
            if (board[6][6].equals("noWhitePawn7")) {
                if (R.id.F7 == moveTo) {
                    board[5][6] = "whitePawn7";
                    board[6][6] = "null";
                    return true;
                }
                if (R.id.E7 == moveTo && board[5][6].equals("null")) {
                    board[4][6] = "whitePawn7";
                    board[6][6] = "null";
                    return true;
                }
            }
        }
        if (piece == WP8) {
            if (board[6][7].equals("noWhitePawn8")) {
                if (R.id.F8 == moveTo) {
                    board[5][7] = "whitePawn8";
                    board[6][7] = "null";
                    return true;
                } else if (R.id.E8 == moveTo && board[5][7].equals("null")) {
                    board[4][7] = "whitePawn8";
                    board[6][7] = "null";
                    return true;
                }
            }
        }
        return false;
    }
}
