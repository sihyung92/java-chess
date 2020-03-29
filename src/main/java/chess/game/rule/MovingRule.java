package chess.game.rule;

import java.util.function.BiPredicate;

public enum MovingRule {
    // Position 에서 값을 꺼내서 x좌표 차이와 y좌표 차이를 구한다.
    // 1) 자리에 무엇이 있는 지 보고
    // 2) 이동할 수 있는지 보고
    //  2-1) 해당 기물의 type(movingRule 주입)을 보고 movingrule(direction 주입)을 본다 해당 Direction, . x,y에 의거하여
    // 3) 해당 포지션에 무엇이 있는지 보고
    // 4) 0보다 크다면, 디렉션에서 방향을 꺼내서
    KING((xDistance, yDistance) ->
            (Math.abs(xDistance) == 1 && Math.abs(yDistance) == 1)
                    || (Math.abs(xDistance) == 1 && yDistance == 0)
                    || (xDistance == 0 && Math.abs(yDistance) == 1)
    ),
    QUEEN((xDistance, yDistance) ->
            (Math.abs(xDistance) == Math.abs(yDistance))
                    || ((xDistance == 0 && yDistance != 0) || (xDistance != 0 && yDistance == 0))
    ),
    BISHOP((xDistance, yDistance) -> Math.abs(xDistance) == Math.abs(yDistance)),
    KNIGHT((xDistance, yDistance) ->
            (Math.abs(xDistance) == 2 && Math.abs(yDistance) == 1)
                    || (Math.abs(xDistance) == 1 && Math.abs(yDistance) == 2)
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
        return canMove(xDistance, yDistance) && isNotZero(xDistance, yDistance);
    }

    private boolean isNotZero(int xDistance, int yDistance) {
        return xDistance != 0 || yDistance != 0;
    }

}
