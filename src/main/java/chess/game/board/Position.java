package chess.game.board;

import java.util.Objects;

// TODO: 2020-03-27 : of 메소드 구현방식 수정 필요
public class Position implements Comparable<Position> {
    public static final int MAX_BOUND = 8;
    public static final int MIN_BOUND = 1;
    private final Integer x;
    private final Integer y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    public int horizontalDistance(Position target) {
        return target.x - this.x;
    }

    public int verticalDistance(Position target) {
        return target.y - this.y;
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

    @Override
    public int compareTo(Position o) {
        Position that = o;
        return (this.y - that.y) * 10 + (this.x - that.x);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
