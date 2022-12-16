package subway.view;

public class OutputView {
    private static String MAIN_QUESTION_MESSAGE = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료";

    public void printMainQuestion() {
        System.out.println(MAIN_QUESTION_MESSAGE);
    }
}
