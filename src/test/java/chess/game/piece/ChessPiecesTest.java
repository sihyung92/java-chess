package chess.game.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chess.game.piece.attribute.Color.BLACK;
import static chess.game.piece.attribute.Color.WHITE;
import static chess.game.piece.attribute.Type.*;
import static org.assertj.core.api.Assertions.assertThat;

class ChessPiecesTest {
    ChessPieceFactory factory = new ChessPieceFactory();

    @Test
    @DisplayName("백색 기물(폰 제외) 리스트 스트림 생성 확인")
    void whitePiecesWithoutPawnStream() {
        //give
        List<ChessPiece> expectedPieces = Arrays.asList(
                factory.createChessPiece(ROOK, WHITE),
                factory.createChessPiece(KNIGHT, WHITE),
                factory.createChessPiece(BISHOP, WHITE),
                factory.createChessPiece(KING, WHITE),
                factory.createChessPiece(QUEEN, WHITE),
                factory.createChessPiece(BISHOP, WHITE),
                factory.createChessPiece(KNIGHT, WHITE),
                factory.createChessPiece(ROOK, WHITE)
        );

        //when
        List<ChessPiece> whiteChessList = ChessPieces.whitePiecesWithoutPawnStream().collect(Collectors.toList());

        //then
        assertThat(whiteChessList).isEqualTo(expectedPieces);
    }

    @Test
    @DisplayName("흑색 기물(폰 제외) 리스트 스트림 생성 확인")
    void blackPiecesWithoutPawn() {
        //give
        List<ChessPiece> expectedPieces = Arrays.asList(
                factory.createChessPiece(ROOK, BLACK),
                factory.createChessPiece(KNIGHT, BLACK),
                factory.createChessPiece(BISHOP, BLACK),
                factory.createChessPiece(KING, BLACK),
                factory.createChessPiece(QUEEN, BLACK),
                factory.createChessPiece(BISHOP, BLACK),
                factory.createChessPiece(KNIGHT, BLACK),
                factory.createChessPiece(ROOK, BLACK)
        );

        //when
        List<ChessPiece> blackChessList = ChessPieces.blackPiecesWithoutPawn().collect(Collectors.toList());

        //then
        assertThat(blackChessList).isEqualTo(expectedPieces);
    }

    @Test
    @DisplayName("백색 폰들 리스트 스트림 생성 확인")
    void whitePawnsStream() {
        //give
        List<ChessPiece> expectedPieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            expectedPieces.add(factory.createChessPiece(PAWN, WHITE));
        }
        //when
        List<ChessPiece> pawns = ChessPieces.whitePawnsStream().collect(Collectors.toList());

        //then
        assertThat(pawns).isEqualTo(expectedPieces);
    }

    @Test
    @DisplayName("흑색 폰들 리스트 스트림 생성 확인")
    void blackPawnsStream() {
        //give
        List<ChessPiece> expectedPieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            expectedPieces.add(factory.createChessPiece(PAWN, BLACK));
        }
        //when
        List<ChessPiece> pawns = ChessPieces.blackPawnsStream().collect(Collectors.toList());

        //then
        assertThat(pawns).isEqualTo(expectedPieces);
    }
}