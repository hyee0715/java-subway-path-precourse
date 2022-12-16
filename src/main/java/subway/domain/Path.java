package subway.domain;

public class Path {
    Station upStation;
    Station downStation;
    int distance;
    int time;

    public Path() {
    }

    public Path(Station upStation, Station downStation, int distance, int time) {
        this.upStation = upStation;
        this.downStation = downStation;
        this.distance = distance;
        this.time = time;
    }
}
