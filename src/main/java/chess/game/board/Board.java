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

    public Map<Position, ChessPiece> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
