package chess.game.piece.attribute;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chess.game.piece.attribute.Type.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TypeTest {
    @Test
    @DisplayName("pawns 사이즈 및 요소 확인")
    void pawns() {
        assertThat(Type.pawns())
                .hasSize(8)
                .containsOnly(PAWN);
    }

    @Test
    @DisplayName("OrderedTypes 사이즈 및 요소 순서 확인")
    void orderedTypesWithoutPawn() {
        assertThat(Type.orderedTypesWithoutPawn())
                .hasSize(8)
                .containsExactlyInAnyOrder(ROOK,KNIGHT,BISHOP,KING,QUEEN,BISHOP,KNIGHT,ROOK);
    }
}