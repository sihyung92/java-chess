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
        boardSource.put(Position.of("A1"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.WHITE));
        boardSource.put(Position.of("B1"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.WHITE));
        boardSource.put(Position.of("C1"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.WHITE));
        boardSource.put(Position.of("D1"), ChessPieceFactory.createChessPiece(Type.KING, Color.WHITE));
        boardSource.put(Position.of("E1"), ChessPieceFactory.createChessPiece(Type.QUEEN, Color.WHITE));
        boardSource.put(Position.of("F1"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.WHITE));
        boardSource.put(Position.of("G1"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.WHITE));
        boardSource.put(Position.of("H1"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.WHITE));
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
        boardSource.put(Position.of("A8"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.BLACK));
        boardSource.put(Position.of("B8"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.BLACK));
        boardSource.put(Position.of("C8"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.BLACK));
        boardSource.put(Position.of("D8"), ChessPieceFactory.createChessPiece(Type.KING, Color.BLACK));
        boardSource.put(Position.of("E8"), ChessPieceFactory.createChessPiece(Type.QUEEN, Color.BLACK));
        boardSource.put(Position.of("F8"), ChessPieceFactory.createChessPiece(Type.BISHOP, Color.BLACK));
        boardSource.put(Position.of("G8"), ChessPieceFactory.createChessPiece(Type.KNIGHT, Color.BLACK));
        boardSource.put(Position.of("H8"), ChessPieceFactory.createChessPiece(Type.ROOK, Color.BLACK));
    }

}
