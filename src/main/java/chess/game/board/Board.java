package chess.game.board;

import chess.game.piece.ChessPiece;
import chess.game.piece.ChessPieces;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chess.game.board.Position.MAX_BOUND;
import static chess.game.board.Position.MIN_BOUND;

public class Board {
    public static final int BLACK_PIECES_ROW = 8;
    public static final int BLACK_PAWNS_ROW = 7;
    private static final int WHITE_PIECES_ROW = 1;
    public static final int WHITE_PAWNS_ROW = 2;

    private final Map<Position, ChessPiece> board = new HashMap<>();

    public Board() {
        ready();
    }

    public void ready() {
        cleanUp();
        fillPieces();
    }

    private void cleanUp() {
        for (int i = MIN_BOUND; i <= MAX_BOUND; i++) {
            for (int j = MIN_BOUND; j <= MAX_BOUND; j++) {
                board.put(new Position(i, j), null);
            }
        }
    }

    private void fillPieces() {
        fillPieces(ChessPieces.blackPiecesWithoutPawnStream(), BLACK_PIECES_ROW);
        fillPieces(ChessPieces.blackPawnsStream(), BLACK_PAWNS_ROW);
        fillPieces(ChessPieces.whitePiecesWithoutPawnStream(), WHITE_PIECES_ROW);
        fillPieces(ChessPieces.whitePawnsStream(), WHITE_PAWNS_ROW);
    }

    private void fillPieces(Stream<ChessPiece> stream, int rowNumber) {
        AtomicInteger xPosition = new AtomicInteger(MIN_BOUND);
        stream.forEach(chessPiece -> {
            board.put(Position.of(xPosition.getAndIncrement(), rowNumber), chessPiece);
        });
    }

    public void move(Position source, Position target) {
        ChessPiece chessPiece = board.get(source);
        board.put(target, chessPiece);
    }

    public List<String> showBoard() {
        List<Position> positions = new ArrayList<>(board.keySet());
        positions.sort(Position::compareTo);
        return positions.stream().map(board::get)
                .map(chessPiece -> {
                    if (Objects.isNull(chessPiece)) {
                        return ".";
                    }
                    return chessPiece.showSymbol();
                })
                .collect(Collectors.toList());
    }
}
