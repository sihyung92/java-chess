package chess.game.piece;

import chess.game.board.Position;
import chess.game.piece.attribute.Color;

public abstract class Piece {
    private Color color;

    public abstract void move(Position source, Position target);
}
