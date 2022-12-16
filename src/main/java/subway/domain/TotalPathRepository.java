package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalPathRepository {
    public static final List<TotalPath> totalPathRepository = new ArrayList<>();

    public static void add(TotalPath totalPath) {
        totalPathRepository.add(totalPath);
    }

    public static List<TotalPath> getTotalPathRepository() {
        return totalPathRepository;
    }
}
