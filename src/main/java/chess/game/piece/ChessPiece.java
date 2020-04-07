package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;
import chess.game.rule.MovingRule;

import java.util.Objects;

// TODO: 2020-03-29 pawn 움직이고 나면 movingRule 바꾸어줘야함
public class ChessPiece {
    private Type type;
    private Color color;
    private MovingRule movingRule;

    public ChessPiece(Type type, Color color, MovingRule movingRule) {
        this.type = type;
        this.color = color;
        this.movingRule = movingRule;
    }

    public String showSymbol() {
        String symbol = type.symbol();
        if (color.equals(Color.BLACK)) {
            symbol = symbol.toLowerCase();
        }
        return symbol;
    }

    public boolean canMove(int horizontalDistance, int verticalDistance) {
        return movingRule.canMove(horizontalDistance, verticalDistance);
    }

    public boolean isBlank() {
        return color == Color.BLANK;
    }

    public boolean hasSameColor(ChessPiece chessPiece) {
        return this.color == chessPiece.color;
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
