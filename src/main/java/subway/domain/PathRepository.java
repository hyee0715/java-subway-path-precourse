package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static boolean isConnected(String firstName, String secondName) {
        for (Path path : paths) {
            String firstStationName = path.getUpStation().getName();
            String secondStationName = path.getDownStation().getName();

            if ((firstStationName.equals(firstName) && secondStationName.equals(secondName)) || (firstStationName.equals(secondName) && secondStationName.equals(firstName))) {
                return true;
            }
        }

        return false;
    }

    public static List<Path> getPaths() {
        return paths;
    }

    public static int findDistanceByStationNames(String firstName, String secondName) {
        for (Path path : paths) {
            String firstStationName = path.getUpStation().getName();
            String secondStationName = path.getDownStation().getName();

            if ((firstStationName.equals(firstName) && secondStationName.equals(secondName)) || (firstStationName.equals(secondName) && secondStationName.equals(firstName))) {
                return path.getDistance();
            }
        }

        return 0;
    }

    public static int findTimeByStationNames(String firstName, String secondName) {
        for (Path path : paths) {
            String firstStationName = path.getUpStation().getName();
            String secondStationName = path.getDownStation().getName();

            if ((firstStationName.equals(firstName) && secondStationName.equals(secondName)) || (firstStationName.equals(secondName) && secondStationName.equals(firstName))) {
                return path.getTime();
            }
        }

        return 0;
    }
}
