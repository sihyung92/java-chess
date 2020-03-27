package chess.game.piece.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Type {
    KING("K"),
    QUEEN("Q"),
    BISHOP("B"),
    KNIGHT("K"),
    ROOK("R"),
    PAWN("P");

    private static List<Type> list = new ArrayList<>();

    private static final int NUMBER_OF_KING = 1;
    private static final int NUMBER_OF_QUEEN = 1;
    private static final int NUMBER_OF_BISHOP = 2;
    private static final int NUMBER_OF_KNIGHT = 2;
    private static final int NUMBER_OF_ROOK = 2;
    private static final int NUMBER_OF_PAWN = 6;

    private static final int[] numberOfType =
            new int[]{NUMBER_OF_KING, NUMBER_OF_QUEEN, NUMBER_OF_BISHOP, NUMBER_OF_KNIGHT, NUMBER_OF_ROOK, NUMBER_OF_PAWN};

    String initial;

    Type(String initial) {
        this.initial = initial;
    }

    public static List<Type> aSet() {
        Arrays.stream(values())
                .forEach(type -> addByEachCount(type, numberOfType[type.ordinal()]));
        return list;
    }

    private static void addByEachCount(Type type, int count) {
        for (int i = 0; i < count; i++) {
            list.add(type);
        }
    }
}
