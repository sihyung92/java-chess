package chess.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputStart() {
        return Objects.requireNonNull(scanner.nextLine().trim(), "문자를 입력해 주세요.");
    }

    public static String read() {
        return Objects.requireNonNull(scanner.nextLine().trim(), "공백은 입력할 수 없습니다.");
    }
}
