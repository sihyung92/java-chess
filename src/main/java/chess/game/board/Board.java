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

    private final Map<Position, ChessPiece> board;

    Board(Map<Position, ChessPiece> board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        ChessPiece chessPiece = board.get(source);

        if (chessPiece.canMove(source.horizontalDistance(target), source.verticalDistance(target))) {
            board.put(target, chessPiece);
        }

        throw new UnsupportedOperationException("해당 위치로 이동할 수 없습니다.");
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
