package subway.view;

import java.util.List;

public class OutputView {
    private static String MAIN_QUESTION_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
    private static String PATH_STANDARD_MESSAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";
    private static String RESULT_MESSAGE = "## 조회 결과";
    private static String INFO_LINE_MESSAGE = "[INFO] ---";
    private static String INFO_MESSAGE = "[INFO] ";

    public void printMainQuestion() {
        System.out.println(MAIN_QUESTION_MESSAGE);
    }

    public void printPathStandard() {
        System.out.println(PATH_STANDARD_MESSAGE);
    }

    public void printResult(List<String> shortestDistance, int totalDistance, int totalTime) {
        System.out.println(RESULT_MESSAGE);
        printInfoLine();
        System.out.println(INFO_MESSAGE + "총 거리: " + totalDistance + "km");
        System.out.println(INFO_MESSAGE + "총 소요 시간: " + totalTime + "분");
        printInfoLine();
        for (String distance : shortestDistance) {
            System.out.println(INFO_MESSAGE + distance);
        }
        System.out.println();
    }

    public void printInfoLine() {
        System.out.println(INFO_LINE_MESSAGE);
    }
}
