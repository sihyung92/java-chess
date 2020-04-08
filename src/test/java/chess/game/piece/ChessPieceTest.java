package chess.game.piece;

import chess.game.board.Board;
import chess.game.board.BoardFactory;
import chess.game.board.Position;
import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChessPieceTest {

    @DisplayName("canMove 검증")
    @ParameterizedTest
    @CsvSource(value = {"ROOK:A1:A8:true","BISHOP:A1:A2:false","BISHOP:A1:b2:true","KING:A1:A2:true","KING:a2:b4:false"}, delimiter = ':')
    void name(String type, String fromExpression, String toExpression, boolean expectedResult) {
        ChessPiece chessPiece = ChessPieceFactory.createChessPiece(Type.valueOf(type.toUpperCase()), Color.BLACK);
        assertThat(chessPiece.canMove(Position.of(fromExpression), Position.of(toExpression))).isEqualTo(expectedResult);

    }
}