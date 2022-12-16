package subway.service;

import subway.domain.Line;
import subway.domain.Path;
import subway.domain.PathRepository;
import subway.domain.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static subway.constant.Constant.*;

public class Initializer {
    private final String[] line2Stations = new String[]{"교대역", "강남역", "역삼역"};
    private final String[] line3Stations = new String[]{"교대역", "남부터미널역", "양재역", "매봉역"};
    private final String[] bundanglineStations = new String[]{"강남역", "양재역", "양재시민의숲역"};

    private final String[] line2Path = new String[]{"교대역 : 2 : 3 : 강남역", "강남역 : 2 : 3 : 역삼역"};
    private final String[] line3Path = new String[]{"교대역 : 3 : 2 : 남부터미널역", "남부터미널역 : 6 : 5 : 양재역", "양재역 : 1 : 1 : 매봉역"};
    private final String[] BundangPath = new String[]{"강남역 : 2 : 8 : 양재역", "양재역 : 10 : 3 : 양재시민의숲역"};

    public List<Station> getStationsOfLine(String[] lineStations) {
        return Arrays.stream(lineStations)
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public List<Line> initializeLines() {
        List<Line> lines = new ArrayList<>();

        List<Station> stations = getStationsOfLine(line2Stations);
        lines.add(new Line(LINE2, stations));
        stations = getStationsOfLine(line3Stations);
        lines.add(new Line(LINE3, stations));
        stations = getStationsOfLine(bundanglineStations);
        lines.add(new Line(BUNDANGLINE, stations));

        return lines;
    }

    public void initializePath() {
        List<Path> paths = new ArrayList<>();
        makePath(line2Path, paths);
        paths.forEach(PathRepository::addPath);

        makePath(line3Path, paths);
        paths.forEach(PathRepository::addPath);

        makePath(BundangPath, paths);
        paths.forEach(PathRepository::addPath);
    }


    public void makePath(String[] pathInfomation, List<Path> paths) {
        for (String path : pathInfomation) {
            String[] pathInfo = path.split(" : ");
            String upStation = pathInfo[0];
            int distance = Integer.parseInt(pathInfo[1]);
            int time = Integer.parseInt(pathInfo[2]);
            String downStation = pathInfo[3];

            paths.add(new Path(new Station(upStation), new Station(downStation), distance, time));
        }
    }
}
