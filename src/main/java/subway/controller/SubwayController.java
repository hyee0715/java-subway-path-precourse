package subway.controller;

import subway.service.Initializer;
import subway.view.OutputView;


public class SubwayController {
    Initializer initializer;
    OutputView outputView;

    public SubwayController() {
        initializer = new Initializer();
        outputView = new OutputView();
    }

    public void run() {
        initialize();

        outputView.printMainQuestion();
    }

    public void initialize() {
        initializer.initializeLines();
        initializer.initializePath();
    }
}