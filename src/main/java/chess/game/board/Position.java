package chess.game.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    private final File file;
    private final Rank rank;
    private static final Map<String, Position> CACHE;

    static {
        Map<String, Position> positions = new HashMap<>();
        for (File file : File.values()) {
            createPositionsByRank(positions, file);
        }
        CACHE = Collections.unmodifiableMap(positions);
    }

    private static void createPositionsByRank(Map<String, Position> positions, File file) {
        for (Rank rank : Rank.values()) {
            positions.put(createKey(file, rank), new Position(file, rank));
        }
    }

    private static String createKey(File file, Rank rank) {
        return file.initial + rank.rankNumber;
    }

    private Position(File file, Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public static Position of(String expression) {
        return CACHE.get(expression.toUpperCase());
    }

    public int horizontalDistance(Position target) {
        return file.calculateDistance(target.file);
    }

    public int verticalDistance(Position target) {
        return rank.calculateDistance(target.rank);
    }

    public Position move(Direction direction) {
        return Position.of(createKey(file.moveBy(direction.fileDistance), rank.moveBy(direction.rankDistance)));
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
