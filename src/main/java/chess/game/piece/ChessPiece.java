package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;

public class ChessPiece {
    private Type type;
    private Color color;

    public ChessPiece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public boolean isBlack(){
        return color.equals(Color.BLACK);
    }
}
