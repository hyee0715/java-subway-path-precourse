package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class PathRepository {
    private static final List<Path> paths = new ArrayList<>();

    public static void addPath(Path path) {
        paths.add(path);
    }
}
