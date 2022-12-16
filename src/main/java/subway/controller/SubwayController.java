package subway.controller;

import static subway.constant.Constant.QUIT;
import static subway.service.FunctionSelectionService.takeFunctionSelection;

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
        String functionSelection = "";
        initializer = new Initializer();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(Scanner scanner) {
        initialize();
        do {
            outputView.printMainQuestion();

            String functionSelection = takeFunctionSelection(scanner);

        } while (!functionSelection.equals(QUIT));
    }

    public void initialize() {
        initializer.initializeLines();
        initializer.initializePath();
    }
}