package subway.view;

public class OutputView {
    private static String MAIN_QUESTION_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";
    private static String PATH_STANDARD_MESSAGE = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";

    public void printMainQuestion() {
        System.out.println(MAIN_QUESTION_MESSAGE);
    }

    public void printPathStandard() {
        System.out.println(PATH_STANDARD_MESSAGE);
    }
}
