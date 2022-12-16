package subway.service;

import subway.exception.FunctionSelectionValidator;
import subway.exception.PathStandardValidator;
import subway.exception.StationNameValidator;
import subway.view.InputView;

import java.util.Scanner;

public class InputService {

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

    public static String takePathStandard(Scanner scanner) {
        InputView inputView = new InputView();
        String pathStandard = inputView.readFunctionSelection(scanner);

        try {
            PathStandardValidator.validate(pathStandard);
            return pathStandard;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return takePathStandard(scanner);
        }
    }

    public static String takeStartStation(Scanner scanner) {
        InputView inputView = new InputView();
        String station = inputView.readStartStation(scanner);

        try {
            StationNameValidator.validateEmptyInput(station);
            return station;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return takeStartStation(scanner);
        }
    }

    public static String takeEndStation(Scanner scanner) {
        InputView inputView = new InputView();
        String station = inputView.readEndStation(scanner);

        try {
            StationNameValidator.validateEmptyInput(station);
            return station;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
            return takeEndStation(scanner);
        }
    }
}
