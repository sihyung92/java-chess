package chess.view;

import chess.game.board.Board;

import java.util.List;

public class OutputView {

    public static final String START_MESSAGE = "게임을 시작하시려면 start를 입력해주세요";

    public static void startMenu() {
        System.out.println(START_MESSAGE);
    }

    public static void printBoard(Board board) {
        List<String> boardData = board.showBoard();

        for (int i = 0; i < boardData.size(); i++) {
            System.out.print(boardData.get(i));
            if ((i + 1) % 8 == 0 && i != 0) {
                System.out.println(" " + (i + 1) / 8);
            }
        }

        for (int i = 0; i < 8; i++) {
            System.out.print((char) ('A' + i));
        }
    }
}
