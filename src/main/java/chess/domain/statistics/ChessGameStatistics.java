package chess.domain.statistics;

import chess.domain.board.Board;
import chess.domain.board.DefaultBoardInitializer;
import chess.domain.piece.attribute.Color;

import java.util.Collections;
import java.util.Map;

public class ChessGameStatistics {
    private final Map<Color, Double> colorsScore;
    private final MatchResult matchResult;

    public ChessGameStatistics(Map<Color, Double> colorsScore, MatchResult matchResult) {
        this.colorsScore = colorsScore;
        this.matchResult = matchResult;
    }

    public static ChessGameStatistics createNotStartGameResult() {
        Board defaultBoard = DefaultBoardInitializer.getBoard();
        return new ChessGameStatistics(defaultBoard.getScoreMap(), MatchResult.DRAW);
    }

    public Map<Color, Double> getColorsScore() {
        return Collections.unmodifiableMap(colorsScore);
    }

    public String getResultText() {
        return this.matchResult.getText();
    }
}
