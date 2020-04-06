package chess.game.board;

import java.util.stream.Stream;

public enum Rank {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    private final int rankNumber;

    Rank(int rankNumber) {
        this.rankNumber = rankNumber;
    }

    public static Rank of(final int rankNumber) {
        return Stream.of(values())
                .filter(y -> rankNumber == y.rankNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 숫자에 해당하는 Rank를 찾을 수 없습니다."));
    }

    public Rank moveBy(final int rankDistance){
        return Stream.of(values())
                .filter(y -> rankNumber + rankDistance == y.rankNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 숫자에 해당하는 Rank를 찾을 수 없습니다."));
    }

    public int getRankNumber() {
        return rankNumber;
    }



    public int calculateDistance(Rank target) {
        return this.rankNumber - target.rankNumber;
    }
}
