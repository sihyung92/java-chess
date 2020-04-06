package chess.game.board;

import java.util.Objects;

// TODO: 2020-03-27 : 포지션 싱글톤 방식으로 변경 필요
public class Position {
    private final Rank rank;
    private final File file;

    public Position(String file, int rank) {
        this.file = File.of(file);
        this.rank = Rank.of(rank);
    }

    public Position(File file, Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public static Position of(String position) {
        if (position.matches("^[a-zA-Z][0-9]$")) {
            return new Position(String.valueOf(position.charAt(0)), Integer.parseInt(String.valueOf(position.charAt(1))));
        }
        throw new IllegalArgumentException("잘못된 좌표이름 입니다.");
    }

    public int horizontalDistance(Position target) {
        return file.calculateDistance(target.file);
    }

    public int verticalDistance(Position target) {
        return rank.calculateDistance(target.rank);
    }

    public Position move(Direction direction) {
        return new Position(file.moveBy(direction.fileDistance), rank.moveBy(direction.rankDistance));
    }

    public Rank getRank() {
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
