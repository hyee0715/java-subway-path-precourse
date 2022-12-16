package subway.exception;

public class StationNameValidator {
    private static final String EMPTY_ERROR_MESSAGE = "[ERROR] 값이 입력되지 않았습니다.";

    public static void validateEmptyInput(String source) {
        if (source.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }
}
