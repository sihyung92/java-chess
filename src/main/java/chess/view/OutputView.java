package chess.view;

import chess.game.board.Board;
import chess.game.board.File;
import chess.game.board.Position;
import chess.game.board.Rank;
import chess.game.piece.ChessPiece;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OutputView {

    public static final String START_MESSAGE = "게임을 시작하시려면 start를 입력해주세요";

    public static void startMenu() {
        System.out.println(START_MESSAGE);
    }

    public static void printBoard(Board board) {
        for (Rank rank : Rank.values()){
            showPieces(board, rank);
            System.out.println();
        }
    }

    private static void showPieces(Board board,Rank rank){
        for (File file : File.values()){
            Position po = new Position(file.getInitial(), rank.getRankNumber());

            System.out.print(board.getBoard().get(po).showSymbol());
        }
    }
}
