package chess.game.board;

import chess.game.piece.ChessPiece;
import chess.game.piece.ChessPieceFactory;
import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoardFactory {
    public static Board createInitialBoard() {
        return new Board(createBoardSource());
    }

    private static Map<Position, ChessPiece> createBoardSource() {
        HashMap<Position, ChessPiece> boardSource = new HashMap<>();
        fillFirstRank(boardSource);
        fillSecondRank(boardSource);
        fillBlank(boardSource);
        fillSeventhRank(boardSource);
        fillEighthRank(boardSource);

        return boardSource;
    }

    private static void fillFirstRank(Map<Position, ChessPiece> boardSource) {
        boardSource.put(Position.of("a1"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.WHITE));
        boardSource.put(Position.of("b1"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.WHITE));
        boardSource.put(Position.of("c1"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.WHITE));
        boardSource.put(Position.of("d1"), ChessPieceFactory.createChessPiece(Type.KING, Color.WHITE));
        boardSource.put(Position.of("e1"), ChessPieceFactory.createChessPiece(Type.QUEEN, Color.WHITE));
        boardSource.put(Position.of("f1"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.WHITE));
        boardSource.put(Position.of("g1"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.WHITE));
        boardSource.put(Position.of("h1"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.WHITE));
    }

    private static void fillSecondRank(Map<Position, ChessPiece> boardSource) {
        for (File file : File.values()) {
            boardSource.put(Position.of(file.initial + Rank.TWO.getRankNumber())
                    , ChessPieceFactory.createChessPiece(Type.PAWN, Color.WHITE));
        }
    }

    private static void fillBlank(Map<Position, ChessPiece> boardSource) {
        for (int i = Rank.THREE.getRankNumber(); i <= Rank.SIX.getRankNumber(); i++) {
            int finalI = i;
            Arrays.stream(File.values())
                    .forEach(file -> boardSource.put(Position.of(file.initial+ finalI), ChessPieceFactory.createChessPiece(Type.BLANK, Color.BLACK)));
        }
    }

    private static void fillSeventhRank(Map<Position, ChessPiece> boardSource) {
        for (File file : File.values()) {
            boardSource.put(Position.of(file.initial + Rank.SEVEN.getRankNumber())
                    , ChessPieceFactory.createChessPiece(Type.PAWN, Color.BLACK));
        }
    }

    private static void fillEighthRank(Map<Position, ChessPiece> boardSource) {
        boardSource.put(Position.of("a8"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.BLACK));
        boardSource.put(Position.of("b8"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.BLACK));
        boardSource.put(Position.of("c8"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.BLACK));
        boardSource.put(Position.of("d8"), ChessPieceFactory.createChessPiece(Type.KING, Color.BLACK));
        boardSource.put(Position.of("e8"), ChessPieceFactory.createChessPiece(Type.QUEEN, Color.BLACK));
        boardSource.put(Position.of("f8"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.BLACK));
        boardSource.put(Position.of("g8"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.BLACK));
        boardSource.put(Position.of("h8"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.BLACK));
    }

}
