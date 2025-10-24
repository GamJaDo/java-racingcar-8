package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RacingcarOutputView {

    public static void printExecutionResult() {
        System.out.println("\n실행 결과");
    }

    public static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            printDistance(car.getDistance());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerCarNames) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNames));
    }

    private static void printDistance(int distance) {
        for (int i=0; i<distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
