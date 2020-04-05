package chess.game.piece.attribute;

import chess.game.rule.MovingRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Type {
    KING("K"),
    QUEEN("Q"),
    BISHOP("B"),
    KNIGHT("K"),
    ROOK("R"),
    PAWN("P"),
    BLANK(".");

    private static List<Type> orderedTypes;

    private static final int NUMBER_OF_PAWN = 8;
    private static final Type[] typesOrderWithOutPawn =
            new Type[]{ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK};

    String symbol;

    static {
        orderedTypes = Arrays.asList(typesOrderWithOutPawn);
    }

    Type(String symbol) {
        this.symbol = symbol;
    }
    public String symbol() {
        return symbol;
    }

    public static Stream<Type> orderedTypesWithoutPawn() {
        return orderedTypes.stream();
    }

    public static Stream<Type> pawns() {
        List<Type> pawns = new ArrayList<>(NUMBER_OF_PAWN);
        for (int i = 0; i < NUMBER_OF_PAWN; i++) {
            pawns.add(PAWN);
        }
        return pawns.stream();
    }
}
