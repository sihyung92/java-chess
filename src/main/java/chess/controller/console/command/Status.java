package chess.controller.console.command;

import chess.domain.manager.ChessGameManager;
import chess.domain.statistics.ChessGameStatistics;
import chess.view.OutputView;

import java.util.List;

public class Status implements Command {
    private static final int STATUS_COMMAND_PROPER_SIZE = 1;

    public Status(List<String> inputCommand) {
        if (inputCommand.size() != STATUS_COMMAND_PROPER_SIZE) {
            throw new IllegalArgumentException("유효하지 않은 상태 출력 명령입니다.");
        }
    }

    @Override
    public ChessGameManager execute(ChessGameManager chessGameManager) {
        ChessGameStatistics chessGameStatistics = chessGameManager.getStatistics();
        OutputView.printResult(chessGameStatistics);
        return chessGameManager;
    }
}
