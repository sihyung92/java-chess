package chess.game.board;

import chess.game.piece.ChessPiece;
import chess.game.piece.ChessPieces;

import java.util.HashMap;
import java.util.Map;

import static chess.game.board.Position.*;

public class BasicBoard {
    private Map<Position, ChessPiece> board;

    private BasicBoard() {
    }

    public static BasicBoard createBoard(){
        BasicBoard instance = new BasicBoard();
        instance.board = new HashMap<>();
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++) {
            for (int j = MIN_POSITION; j <= MAX_POSITION; j++) {
                instance.board.put(new Position(i,j),null);
            }
        }
        return instance;
    }

    public void setUpPieces(ChessPieces chessPieces){
    }

    private void setUpBlack(){

    }

    private void setUpWhite(){

    }



}
