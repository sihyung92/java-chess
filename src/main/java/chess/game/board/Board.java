package chess.game.board;

import chess.game.piece.ChessPiece;

import java.util.*;

public class Board {
    private final Map<Position, ChessPiece> board;

    Board(Map<Position, ChessPiece> board) {
        this.board = board;
    }

    public void move(Position source, Position target) {
        validate(source, target);
        board.put(target, getPiece(source));
    }

    private void validate(Position source, Position target) {
        canMove(board.get(source), source ,target);
        route(source, target);
        isSameColor(source, target);
    }

    private void canMove(ChessPiece piece, Position source,Position target) {
        piece.canMove(source, target);
    }

    private List<Position> route(Position source, Position target) {
        List<Position> route = new ArrayList<>();
        Direction direction = Direction.findDirection(source, target);
        while (!source.equals(target)) {
            route.add(source.move(direction));
            isBlank(source);
        }
        return route;
    }

    private void isSameColor(Position source, Position target) {
        if(getPiece(target).hasSameColor(getPiece(target))){
           throw new IllegalArgumentException("해당 위치에 있는 말은 아군 말입니다.");
        }
    }

    private void isBlank(Position position) {
        if(!getPiece(position).isBlank()){
            throw new IllegalArgumentException("가는 길목에 다른 말이 있습니다.");
        }
    }

    public ChessPiece of(String expression){
        return getPiece(Position.of(expression));
    }

    private ChessPiece getPiece(Position target) {
        return board.get(target);
    }

    public Map<Position, ChessPiece> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
