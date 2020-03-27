package chess.view;

import chess.game.board.Board;

public class OutputView {

    public static final String START_MESSAGE = "게임을 시작하시려면 start를 입력해주세요";

    public static void startMenu() {
        System.out.println(START_MESSAGE);
    }

    public static void printBoard(Board Board) {
        makeBoard(Board);
        System.out.println(makeBoard(Board));
    }

    /*
            output[i][0]; 첫줄
            output[0][i]; 첫 새로줄
            output[i][9]; 끝줄
            output[9][i]; 끝 세로줄
     * */
    private static String[][] makeBoard(Board board) {
        String[][] output = new String[10][10];
        for (int i = 1; i < 9; i++) {
            output[0][i] = String.valueOf(i);
            output[9][i] = String.valueOf(i);
            output[i][0] = String.valueOf('A'+i);
            output[i][9] = String.valueOf('A'+i);
        }
        return output;
    }
}
