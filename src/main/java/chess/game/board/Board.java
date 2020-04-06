package chess.game.board;

import chess.game.piece.ChessPiece;

import java.util.*;

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

    public List<Position> route(Position source, Position target) {
        List<Position> route = new ArrayList<>();
        Direction.findDirection(source, target);
        while (!source.equals(target)) {

        }
        return route;
    }

    public Map<Position, ChessPiece> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
