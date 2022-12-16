package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.service.Initializer;

import java.util.List;

public class SubwayController {
    Initializer initializer = new Initializer();

    public void run() {
        List<Line> lines = initializer.initializeLines();
        initializer.initializePath();
    }
}