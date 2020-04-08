package chess.game.board;

import chess.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = BoardFactory.createInitialBoard();
    }

    @DisplayName("64개 사이즈 판을 만드는지")
    @Test
    void name() {
        assertThat(board.getBoard().size()).isEqualTo(64);
    }

}