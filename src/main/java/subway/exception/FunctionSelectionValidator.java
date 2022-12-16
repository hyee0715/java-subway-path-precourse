package subway.exception;

public class FunctionSelectionValidator {
    private static final String EMPTY_ERROR_MESSAGE = "[ERROR] 값이 입력되지 않았습니다.";
    private static final String LENGTH_RANGE_ERROR_MEESAGE = "[ERROR] 문자 1글자만 입력되어야 합니다.";
    private static final String NOT_MAIN_COMMAND_ERROR_MESSAGE = "[ERROR] 입력된 값은 1 또는 Q이어야 합니다.";

    private static final String PATH_LOOK = "1";
    private static final String QUIT = "Q";
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
        if (!source.equals(PATH_LOOK) && !source.equals(QUIT)) {
            throw new IllegalArgumentException(NOT_MAIN_COMMAND_ERROR_MESSAGE);
        }
    }
}
