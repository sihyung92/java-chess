package chess.game.board;

import java.util.Objects;

// TODO: 2020-03-27 : of 메소드 구현방식 수정 필요
public class Position {
    public static final int MAX_POSITION = 8;
    public static final int MIN_POSITION = 1;
    private final Integer x;
    private final Integer y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
