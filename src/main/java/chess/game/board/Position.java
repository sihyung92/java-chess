package chess.game.board;

import java.util.Objects;

// TODO: 2020-03-27 : of 메소드 구현방식 수정 필요
public class Position{
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

    public static Position of(String position) {
        if (position.matches("^[a-zA-Z][0-9]$")) {
            return new Position(String.valueOf(position.charAt(0)), Integer.parseInt(String.valueOf(position.charAt(1))));
        }
        throw new IllegalArgumentException("잘못된 좌표이름 입니다.");
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

    public Rank getRank(){
        return rank;
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
    public String toString() {
        return "Position{" +
                "x=" + rank +
                ", y=" + file +
                '}';
    }
}
