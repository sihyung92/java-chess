package chess.game.board;

import java.util.Arrays;

public enum Direction {
    NORTH(0, 1),
    NORTHWEST(-1, 1),
    WEST(-1, 0),
    SOUTHWEST(-1, -1),
    SOUTH(0, -1),
    SOUTHEAST(1, -1),
    EAST(1, 0),
    NORTHEAST(1, 1),

    NORTH_NORTH_EAST(1, 2),
    NORTH_NORTH_WEST(-1, 2),
    SOUTH_SOUTH_EAST(1, -2),
    SOUTH_SOUTH_WEST(-1, -2),
    EAST_EAST_NORTH(2, 1),
    EAST_EAST_SOUTH(2, -1),
    WEST_WEST_NORTH(-2, 1),
    WEST_WEST_SOUTH(-2, -1);

    Integer fileDistance;
    Integer rankDistance;

    Direction(Integer fileDistance, Integer rankDistance) {
        this.fileDistance = fileDistance;
        this.rankDistance = rankDistance;
    }

    public static Direction findDirection(Position source, Position target) {
        int fileDistance = source.horizontalDistance(target);
        int rankDistance = source.verticalDistance(target);
        return findDirection(fileDistance, rankDistance);
    }

    private static Direction findDirection(int fileDistance, int rankDistance) {
        if (fileDistance == 0 && rankDistance == 0) {
            throw new NullPointerException("잘못된 방향입니다.");
        }

        if (fileDistance == 0) {
            rankDistance /= Math.abs(rankDistance);
        }

        if (rankDistance == 0) {
            fileDistance /= Math.abs(fileDistance);
        }

        if (fileDistance != 0 && rankDistance != 0) {
            int step = Math.min(Math.abs(fileDistance), Math.abs(rankDistance));
            fileDistance /= step;
            rankDistance /= step;
        }

        int x = fileDistance;
        int y = rankDistance;

        return Arrays.stream(Direction.values())
                .filter(direction -> direction.has(x, y))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("잘못된 방향입니다."));
    }

    private boolean has(int fileDistance, int rankDistance) {
        return this.fileDistance == fileDistance && this.rankDistance == rankDistance;
    }
}
