package subway.service;

import subway.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static subway.constant.Constant.*;

public class Initializer {
    private static final String[] line2Stations = new String[]{"교대역", "강남역", "역삼역"};
    private static final String[] line3Stations = new String[]{"교대역", "남부터미널역", "양재역", "매봉역"};
    private static final String[] bundanglineStations = new String[]{"강남역", "양재역", "양재시민의숲역"};

    private final String[] line2Path = new String[]{"교대역 : 2 : 3 : 강남역", "강남역 : 2 : 3 : 역삼역"};
    private final String[] line3Path = new String[]{"교대역 : 3 : 2 : 남부터미널역", "남부터미널역 : 6 : 5 : 양재역", "양재역 : 1 : 1 : 매봉역"};
    private final String[] BundangPath = new String[]{"강남역 : 2 : 8 : 양재역", "양재역 : 10 : 3 : 양재시민의숲역"};

    public List<Station> getStationsOfLine(String[] lineStations) {
        return Arrays.stream(lineStations)
                .map(Station::new)
                .collect(Collectors.toList());
    }

    public static void initializeStationRepository() {
        Arrays.stream(line2Stations)
                .map(Station::new)
                .forEach(StationRepository::addStation);
        Arrays.stream(line3Stations)
                .map(Station::new)
                .forEach(StationRepository::addStation);
        Arrays.stream(bundanglineStations)
                .map(Station::new)
                .forEach(StationRepository::addStation);
    }

    public static void initializeTotalPathRepository() {
        TotalPath totalPath = new TotalPath("2호선", Arrays.stream(line2Stations)
                .collect(Collectors.toSet()));
        TotalPathRepository.add(totalPath);

        totalPath = new TotalPath("3호선", Arrays.stream(line3Stations)
                .collect(Collectors.toSet()));
        TotalPathRepository.add(totalPath);

        totalPath = new TotalPath("분당선", Arrays.stream(bundanglineStations)
                .collect(Collectors.toSet()));
        TotalPathRepository.add(totalPath);

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
