package subway.controller;

import subway.service.Initializer;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;


public class SubwayController {
    Initializer initializer;
    InputView inputView;
    OutputView outputView;

    public SubwayController() {
        initializer = new Initializer();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(Scanner scanner) {
        initialize();
        outputView.printMainQuestion();

        String functionSelection = inputView.readFunctionSelection(scanner);
    }

    public void initialize() {
        initializer.initializeLines();
        initializer.initializePath();
    }
}