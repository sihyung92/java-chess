package chess.game.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("좌표명으로 포지션이 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asd","aa","ab","11","1b"})
    void name(String position) {
        assertThatThrownBy(() -> Position.of(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 좌표이름 입니다.");
    }
}