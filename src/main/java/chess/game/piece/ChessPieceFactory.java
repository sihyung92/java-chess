package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;
import chess.game.rule.MovingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessPieceFactory {
    public static ChessPiece createChessPiece(Type type, Color color) {
        if (color == Color.WHITE && type == Type.PAWN) {
            return new ChessPiece(type, color, MovingRule.WHITE_PAWN_FIRST);
        }

        if (color == Color.BLACK && type == Type.PAWN) {
            return new ChessPiece(type, color, MovingRule.BLACK_PAWN_FIRST);
        }

        return new ChessPiece(type, color, MovingRule.valueOf(type.name()));
    }
}
