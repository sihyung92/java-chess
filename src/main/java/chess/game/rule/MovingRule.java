package chess.game.rule;

import java.util.function.BiPredicate;

public enum MovingRule {

    KING((xDistance, yDistance) ->
            (xDistance == 1 && yDistance == 1)
                    || (xDistance == 1 && yDistance == 0)
                    || (xDistance == 0 && yDistance == 1)
    ),
    QUEEN((xDistance, yDistance) ->
            xDistance == yDistance
                    || ((xDistance == 0 && yDistance != 0) || (xDistance != 0 && yDistance == 0))
    ),
    BISHOP((xDistance, yDistance) -> xDistance == yDistance),
    KNIGHT((xDistance, yDistance) ->
            (xDistance == 2 && yDistance == 1)
                    || (xDistance == 1 && yDistance == 2)
    ),
    ROOK((xDistance, yDistance) -> (xDistance == 0 && yDistance != 0) || (xDistance != 0 && yDistance == 0)),
    WHITE_PAWN((xDistance, yDistance) -> xDistance == 0 && yDistance == -1),
    WHITE_PAWN_FIRST((xDistance, yDistance) -> xDistance == 0 && (yDistance == -1 || yDistance == -2)),
    BLACK_PAWN((xDistance, yDistance) -> xDistance == 0 && yDistance == 1),
    BLACK_PAWN_FIRST((xDistance, yDistance) -> xDistance == 0 && (yDistance == 1 || yDistance == 2));

    BiPredicate<Integer, Integer> canMove;

    MovingRule(BiPredicate<Integer, Integer> canMove) {
        this.canMove = canMove;
    }

    public boolean canMove(int xDistance, int yDistance) {
        return canMove(xDistance, yDistance) && isNotStay(xDistance, yDistance);
    }

    private boolean isNotStay(int xDistance, int yDistance) {
        return xDistance != 0 || yDistance != 0;
    }

}
