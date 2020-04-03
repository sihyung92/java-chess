package chess.game.board;

import java.util.Objects;

// TODO: 2020-03-27 : of 메소드 구현방식 수정 필요
public class Position implements Comparable<Position> {
    public static final int MAX_BOUND = 8;
    public static final int MIN_BOUND = 1;
    private final Rank rank;
    private final File file;

    public Position(String file, int rank) {
        this.file = File.of(file);
        this.rank = Rank.of(rank);
    }

    public Position(int file, int rank) {
        this.file = File.of(file);
        this.rank = Rank.of(rank);
    }

    public Position(String fileRank){
    }

    public static Position of(int file, int rank) {
        return new Position(file, rank);
    }

    public int horizontalDistance(Position target) {
        return file.calculateDistance(target.file);
    }

    public int verticalDistance(Position target) {
        return rank.calculateDistance(target.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rank == position.rank &&
                file == position.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }

    @Override
    public int compareTo(Position o) {
        Position that = o;
        return (file.calculateDistance(that.file)) * 10 + (rank.calculateDistance(that.rank));
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + rank +
                ", y=" + file +
                '}';
    }
}
