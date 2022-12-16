package subway.service;

import subway.exception.FunctionSelectionValidator;
import subway.view.InputView;

import java.util.Scanner;

public class PathService {

    public static String takeFunctionSelection(Scanner scanner) {
        InputView inputView = new InputView();
        String functionSelection = inputView.readFunctionSelection(scanner);

        try {
            FunctionSelectionValidator.validate(functionSelection);
            return functionSelection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return takeFunctionSelection(scanner);
        }
    }
}
