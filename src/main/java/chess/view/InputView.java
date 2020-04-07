package chess.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String read() {
        return Objects.requireNonNull(scanner.nextLine().trim(), "공백은 입력할 수 없습니다.");
    }

    /*
    * if (position.matches("^[a-zA-Z][0-9]$")) {
            return new Position(String.valueOf(position.charAt(0)), Integer.parseInt(String.valueOf(position.charAt(1))));
        }
        throw new IllegalArgumentException("잘못된 좌표이름 입니다.");
    *
    * */
}
