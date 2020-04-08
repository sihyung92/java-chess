package chess.view;

import chess.game.board.Board;
import chess.game.board.File;
import chess.game.board.Rank;

public class OutputView {

    public static final String START_MESSAGE = "게임을 시작하시려면 start를 입력해주세요";

    public static void startMenu() {
        System.out.println(START_MESSAGE);
    }

    public static void printBoard(Board board) {
        for (Rank rank : Rank.values()) {
            showPieces(board, rank);
            System.out.println();
        }
    }

    private static void showPieces(Board board, Rank rank) {
        for (File file : File.values()) {
            String expression = generateExpression(file, rank);
            System.out.print(board.of(expression).showSymbol());
        }
    }

    private static String generateExpression(File file, Rank rank) {
        return file.getInitial() + rank.getRankNumber();
    }
}
