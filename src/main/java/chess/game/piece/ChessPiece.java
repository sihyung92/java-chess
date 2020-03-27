package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return type == that.type &&
                color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }
}
