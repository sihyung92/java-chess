package chess.game.board;

import chess.game.piece.ChessPiece;
import chess.game.piece.ChessPieces;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static chess.game.board.Position.MAX_POSITION;
import static chess.game.board.Position.MIN_POSITION;

public class Board {
    public static final int BLACK_PIECES_ROW = 8;
    public static final int BLACK_PAWNS_ROW = 7;
    private static final int WHITE_PIECES_ROW = 2;
    public static final int WHITE_PAWNS_ROW = 1;

    private final Map<Position, ChessPiece> board = new HashMap<>();

    public Board() {
        ready();
    }

    public void ready() {
        cleanUp();
        fillPieces();
    }

    private void cleanUp() {
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            for (int j = MIN_POSITION; j <= MAX_POSITION; j++) {
                board.put(new Position(i, j), null);
            }
        }
    }

    private void fillPieces() {
        fillPieces(ChessPieces.blackPiecesWithoutPawnStream(), BLACK_PIECES_ROW);
        fillPieces(ChessPieces.blackPiecesWithoutPawnStream(), BLACK_PAWNS_ROW);
        fillPieces(ChessPieces.whitePiecesWithoutPawnStream(), WHITE_PIECES_ROW);
        fillPieces(ChessPieces.whitePiecesWithoutPawnStream(), WHITE_PAWNS_ROW);
    }

    private void fillPieces(Stream<ChessPiece> stream, int rowNumber) {
        stream.forEach(piece -> {
            for (int i = MIN_POSITION; i < MAX_POSITION; i++) {
                board.put(Position.of(i, rowNumber), piece);
            }
        });
    }

    public void move(Position source, Position target) {
        ChessPiece chessPiece = board.get(source);
        board.put(target, chessPiece);
    }
}
