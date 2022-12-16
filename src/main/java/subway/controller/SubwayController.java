package subway.controller;

import static subway.constant.Constant.*;
import static subway.service.PathService.takeFunctionSelection;
import static subway.service.PathService.takePathStandard;

import subway.service.Initializer;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    Initializer initializer;
    InputView inputView;
    OutputView outputView;
    String functionSelection;

    public SubwayController() {
        functionSelection = "";
        initializer = new Initializer();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(Scanner scanner) {
        initialize();

        do {
            outputView.printMainQuestion();

            functionSelection = takeFunctionSelection(scanner);
            findPath(functionSelection, scanner);

        } while (!functionSelection.equals(QUIT));
    }

    public void initialize() {
        initializer.initializeLines();
        initializer.initializePath();
    }

    public void findPath(String functionSelection, Scanner scanner) {
        System.out.print(LINE_BREAK);
        if (functionSelection.equals(SEARCH_PATH)) {
            outputView.printPathStandard();

            String pathStandard = takePathStandard(scanner);
            System.out.println(pathStandard);
        }
    }
}