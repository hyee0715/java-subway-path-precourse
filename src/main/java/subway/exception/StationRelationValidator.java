package subway.exception;

import subway.domain.PathRepository;
import subway.domain.TotalPath;
import subway.domain.TotalPathRepository;

import java.util.List;

public class StationRelationValidator {
    private static final String SAME_STATION_NAME_ERROR_MESSAGE = "[ERROR] 출발역과 도착역의 이름이 같습니다.";
    private static final String NOT_CONNECTED_ERROR_MESSAGE = "[ERROR] 출발역과 도착역이 연결되어 있지 않습니다.";

    public static void validate(String stationFirst, String stationSecond) {
        validateSameStationName(stationFirst, stationSecond);
        validateNotConnected(stationFirst, stationSecond);
    }

    public static void validateSameStationName(String stationFirst, String stationSecond) {
        if (stationFirst.equals(stationSecond)) {
            throw new IllegalArgumentException(SAME_STATION_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateNotConnected(String stationFirst, String stationSecond) {
        if (!checkTotalPathRepositoryOfLine2(stationFirst, stationSecond) && !checkTotalPathRepositoryOfLine3(stationFirst, stationSecond) && !checkTotalPathRepositoryOfbundangLine(stationFirst, stationSecond)) {
            throw new IllegalArgumentException(NOT_CONNECTED_ERROR_MESSAGE);
        }
    }

    public static boolean checkTotalPathRepositoryOfLine2(String stationFirst, String stationSecond) {
        List<TotalPath> totalPathRepository = TotalPathRepository.getTotalPathRepository();

        for (TotalPath totalPath : totalPathRepository) {
            if (totalPath.isSameLine("2호선", stationFirst, stationSecond)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkTotalPathRepositoryOfLine3(String stationFirst, String stationSecond) {
        List<TotalPath> totalPathRepository = TotalPathRepository.getTotalPathRepository();

        for (TotalPath totalPath : totalPathRepository) {
            if (!totalPath.isSameLine("3호선", stationFirst, stationSecond)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTotalPathRepositoryOfbundangLine(String stationFirst, String stationSecond) {
        List<TotalPath> totalPathRepository = TotalPathRepository.getTotalPathRepository();

        for (TotalPath totalPath : totalPathRepository) {
            if (!totalPath.isSameLine("분당선", stationFirst, stationSecond)) {
                return true;
            }
        }
        return false;
    }
}
