package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessPieceFactory {
    public ChessPiece createChessPiece(Type type, Color color) {
        return new ChessPiece(type, color);
    }
}
