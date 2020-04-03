package chess.game.board;

import chess.game.piece.ChessPiece;

import java.util.HashMap;
import java.util.Map;

public class BoardFactory {
    public static Board createInitialBoard(){
        return new Board(createBoardSource());
    }

    private static Map<Position, ChessPiece> createBoardSource() {
        HashMap<Position, ChessPiece> boardSource = new HashMap<>();
        fillFirstRank(boardSource);
        fillSecondRank(boardSource);

        fillSeventhRank(boardSource);
        fillEighthRank(boardSource);

        return boardSource;
    }

    private static void fillFirstRank(Map<Position, ChessPiece> boardSource){
        boardSource.put(new Position());
    }

    private static void fillSecondRank(Map<Position, ChessPiece> boardSource){

    }

    private static void fillSeventhRank(Map<Position, ChessPiece> boardSource){

    }

    private static void fillEighthRank(Map<Position, ChessPiece> boardSource){

    }

}
