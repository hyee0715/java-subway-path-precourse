package subway.exception;

public class PathStandardValidator {
    private static final String EMPTY_ERROR_MESSAGE = "[ERROR] 값이 입력되지 않았습니다.";
    private static final String LENGTH_RANGE_ERROR_MEESAGE = "[ERROR] 문자 1글자만 입력되어야 합니다.";
    private static final String NOT_MAIN_COMMAND_ERROR_MESSAGE = "[ERROR] 입력된 값은 1 또는 2 또는 B여야 합니다.";

    private static final String SHORTEST_DISTANCE = "1";
    private static final String SHORTEST_TIME = "2";
    private static final String BACK = "B";
    private static final int SOURCE_LENGTH_LIMIT = 1;

    public static void validate(String source) {
        validateEmptyInput(source);

        validateLengthRange(source);

        validateMainCommand(source);
    }

    public static void validateEmptyInput(String source) {
        if (source.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateLengthRange(String source) {
        if (source.length() != SOURCE_LENGTH_LIMIT) {
            throw new IllegalArgumentException(LENGTH_RANGE_ERROR_MEESAGE);
        }
    }

    public static void validateMainCommand(String source) {
        if (!source.equals(SHORTEST_DISTANCE) && !source.equals(SHORTEST_TIME) && !source.equals(BACK)) {
            throw new IllegalArgumentException(NOT_MAIN_COMMAND_ERROR_MESSAGE);
        }
    }
}
