package chess.game.board;

import java.util.stream.Stream;

public enum File {
    A(1, "A"),
    B(2, "B"),
    C(3, "C"),
    D(4, "D"),
    E(5, "E"),
    F(6, "F"),
    G(7, "G"),
    H(8, "H");

    int fileNumber;
    String initial;

    File(int fileNumber, String initial) {
        this.fileNumber = fileNumber;
        this.initial = initial;
    }

    public static File of(final String file) {
        return Stream.of(values())
                .filter(y -> y.initial.equalsIgnoreCase(file))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자에 해당하는 file이 없습니다."));
    }

    public static File of(final int fileNumber) {
        return Stream.of(values())
                .filter(y -> y.fileNumber == fileNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자에 해당하는 file이 없습니다."));
    }

    public int calculateDistance(File target) {
        return Math.abs(this.fileNumber - target.fileNumber);
    }
}
