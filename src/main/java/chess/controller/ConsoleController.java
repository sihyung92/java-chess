package chess.controller;

import chess.game.board.Board;
import chess.view.InputView;
import chess.view.OutputView;

import java.util.Objects;

class ConsoleController implements Controller {
    public static final String START = "start";

    @Override
    public void run() {
        enterGame();
        chessStart();
    }

    private String enterGame() {
        OutputView.startMenu();
        String answer = InputView.inputStart();
        if (answer.isEmpty() || Objects.isNull(answer)) {
            throw new IllegalArgumentException("input data is null or empty");
        }
        if (!answer.equals(START)) {
            throw new IllegalArgumentException("input data is not validate");
        }
        return answer;
    }

    private void chessStart() {
        Board board = new Board();
        OutputView.printBoard(board);
    }
}
