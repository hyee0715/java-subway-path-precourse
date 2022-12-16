package subway.view;

import java.util.Scanner;

public class InputView {
    private static String SELECT_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static String INPUT_START_STATION_MESSAGE = "\n## 출발역을 입력하세요.";
    private static String INPUT_END_STATION_MESSAGE = "\n## 도착역을 입력하세요.";

    public String readFunctionSelection(Scanner scanner) {
        System.out.println(SELECT_FUNCTION_MESSAGE);
        return scanner.nextLine();
    }

    public String readStartStation(Scanner scanner) {
        System.out.println(INPUT_START_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String readEndStation(Scanner scanner) {
        System.out.println(INPUT_END_STATION_MESSAGE);
        return scanner.nextLine();
    }
}
