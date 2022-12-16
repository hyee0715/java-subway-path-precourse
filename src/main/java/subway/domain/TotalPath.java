package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class TotalPath {
    String lineName;
    Set<String> line;

    public TotalPath(String lineName, Set<String> line) {
        this.lineName = lineName;
        this.line = new HashSet<>();
    }

    public boolean isSameLine(String lineName, String firstStation, String secondStation) {
        if (line.contains(firstStation) && line.contains(secondStation)) {
            return true;
        }

        return false;
    }
}
