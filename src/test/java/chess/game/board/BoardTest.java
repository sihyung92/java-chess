package chess.game.board;

import chess.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board = new Board();

    @BeforeEach
    void setUp() {
        board.ready();
    }

    @Test
    void ready() {
    }

    @Test
    @DisplayName("기물 움직임 테스트")
    void move() {
//        board.move();
//        assertThat()
    }

    @Test
    void showBoard() {
        board.ready();
        OutputView.printBoard(board);
    }
}