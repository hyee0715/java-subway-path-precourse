package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.service.Initializer;

import java.util.List;

public class DistanceCalculator {
    public static final WeightedMultigraph<String, DefaultWeightedEdge> distanceWeightGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    public static final WeightedMultigraph<String, DefaultWeightedEdge> timeWeightGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public static int calculateTotalDistance(List<String> shortestPath) {
        int totalDistance = 0;
        for (int count = 0; count < shortestPath.size() - 1; count++) {
            int distanceByStationNames = PathRepository.findDistanceByStationNames(shortestPath.get(count), shortestPath.get(count + 1));
            totalDistance += distanceByStationNames;
        }

        return totalDistance;
    }

    public static int calculateTotalTime(List<String> shortestPath) {
        int totalTime = 0;
        for (int count = 0; count < shortestPath.size() - 1; count++) {
            int timeByStationNames = PathRepository.findTimeByStationNames(shortestPath.get(count), shortestPath.get(count + 1));
            totalTime += timeByStationNames;
        }

        return totalTime;
    }

    public static List<String> calculateDistanceWeightGraph(String start, String end) {
        initializeDistanceWeightGraph();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceWeightGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(start, end).getVertexList();

        return shortestPath;
    }

    public static List<String> calculateTimeWeightGraph(String start, String end) {
        initializeTimeWeightGraph();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeWeightGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(start, end).getVertexList();

        return shortestPath;
    }

    public static void initializeDistanceWeightGraph() {
        Initializer.initializeStationRepository();

        List<Station> stations = StationRepository.getStations();
        stations.forEach(station -> distanceWeightGraph.addVertex(station.getName()));

        List<Path> paths = PathRepository.getPaths();
        paths.forEach(path -> distanceWeightGraph.setEdgeWeight(distanceWeightGraph.addEdge(path.getUpStation().getName(), path.getDownStation().getName()), path.getDistance()));
    }

    public static void initializeTimeWeightGraph() {
        Initializer.initializeStationRepository();

        List<Station> stations = StationRepository.getStations();
        stations.forEach(station -> timeWeightGraph.addVertex(station.getName()));

        List<Path> paths = PathRepository.getPaths();
        paths.forEach(path -> timeWeightGraph.setEdgeWeight(timeWeightGraph.addEdge(path.getUpStation().getName(), path.getDownStation().getName()), path.getTime()));
    }
}
