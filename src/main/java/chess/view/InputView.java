package chess.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    static public String inputStart() {
        return Objects.requireNonNull(scanner.nextLine().trim(), "문자를 입력해 주세요.");
    }
}
