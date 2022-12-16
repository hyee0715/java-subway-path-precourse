package subway.controller;

import static subway.constant.Constant.*;
import static subway.domain.DistanceCalculator.*;
import static subway.service.FunctionService.*;

import subway.service.Initializer;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
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
        initializer.initializeTotalPathRepository();
    }

    public void findPath(String functionSelection, Scanner scanner) {
        System.out.print(LINE_BREAK);
        if (functionSelection.equals(SEARCH_PATH)) {
            outputView.printPathStandard();
            String pathStandard = takePathStandard(scanner);
            proceedPathStandard(pathStandard, scanner);
        }
    }

    public void proceedPathStandard(String pathStandard, Scanner scanner) {
        if (pathStandard.equals(SHORTEST_DISTANCE)) {
            getResultDistanceWeight(scanner);
        }
        if (pathStandard.equals(SHORTEST_TIME)) {
            getResultTimeWeight(scanner);
        }
        if (pathStandard.equals(BACK)) {
            return;
        }
    }

    public void getResultDistanceWeight(Scanner scanner) {
        String startStation = takeStartStation(scanner);
        String endStation = takeEndStation(scanner, startStation);

        List<String> shortestDistance = calculateDistanceWeightGraph(startStation, endStation);

        int totalDistance = calculateTotalDistance(shortestDistance);
        int totalTime = calculateTotalTime(shortestDistance);
    }

    public void getResultTimeWeight(Scanner scanner) {
        String startStation = takeStartStation(scanner);
        String endStation = takeEndStation(scanner, startStation);

        List<String> shortestDistance = calculateTimeWeightGraph(startStation, endStation);

        int totalDistance = calculateTotalDistance(shortestDistance);
        int totalTime = calculateTotalTime(shortestDistance);
    }
}