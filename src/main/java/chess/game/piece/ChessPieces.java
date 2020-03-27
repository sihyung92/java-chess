package chess.game.piece;

import chess.game.piece.attribute.Color;
import chess.game.piece.attribute.Type;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessPieces {
    private static List<ChessPiece> whitePieces;
    private static List<ChessPiece> blackPieces;
    private static final Integer INDEX_OF_PAWN = 8;

    static {
        ChessPieceFactory factory = new ChessPieceFactory();
        whitePieces =
                Stream.concat(Type.orderedTypesWithoutPawn(), Type.pawns())
                        .map(type -> factory.createChessPiece(type, Color.WHITE))
                        .collect(Collectors.toList());
        blackPieces =
                Stream.concat(Type.orderedTypesWithoutPawn(), Type.pawns())
                        .map(type -> factory.createChessPiece(type, Color.BLACK))
                        .collect(Collectors.toList());
    }

    public static Stream<ChessPiece> whitePiecesWithoutPawnStream() {
        return whitePieces.subList(0, INDEX_OF_PAWN).stream();
    }

    public static Stream<ChessPiece> blackPiecesWithoutPawnStream() {
        return blackPieces.subList(0, INDEX_OF_PAWN).stream();
    }

    public static Stream<ChessPiece> whitePawnsStream() {
        return whitePieces.subList(INDEX_OF_PAWN, whitePieces.size()).stream();
    }

    public static Stream<ChessPiece> blackPawnsStream() {
        return blackPieces.subList(INDEX_OF_PAWN, blackPieces.size()).stream();
    }
}
