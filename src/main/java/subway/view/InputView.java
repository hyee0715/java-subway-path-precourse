package subway.view;

import java.util.Scanner;

public class InputView {
    private static String SELECT_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";

    public String readFunctionSelection(Scanner scanner) {
        System.out.println(SELECT_FUNCTION_MESSAGE);
        return scanner.next();
    }
}
