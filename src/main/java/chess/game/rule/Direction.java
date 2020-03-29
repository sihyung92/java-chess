package chess.game.rule;

public enum Direction {
    NORTH(0, 1),
    NORTHWEST(-1, 1),
    WEST(-1, 0),
    SOUTHWEST(-1, -1),
    SOUTH(0, -1),
    SOUTHEAST(1, -1),
    EAST(1, 0),
    NORTHEAST(1, 1);

    Direction(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    Integer x;
    Integer y;

}
