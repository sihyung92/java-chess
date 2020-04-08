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

    String symbol;

    Type(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }

}
