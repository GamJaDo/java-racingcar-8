package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCars;
import racingcar.model.Car;
import racingcar.view.RacingcarInputView;
import racingcar.view.RacingcarOutputView;

public class RacingcarContoller {

    public void RacingcarRun() {
        List<String> carNames = RacingcarInputView.carNameInput();
        int attemptCount = RacingcarInputView.attemptCountInput();

        RacingCars racingCars = new RacingCars(carNames);
        List<Car> cars = racingCars.getRacingCars();

        RacingcarOutputView.printExecutionResult();
        for (int i=0; i<attemptCount; i++) {
            playTurn(cars);
            RacingcarOutputView.printProgress(cars);
        }

        List<String> winnerCarNames = getWinners(cars);
        RacingcarOutputView.printWinners(winnerCarNames);
    }

    private void playTurn(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private List<String> getWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winnerCarNames = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winnerCarNames.add(car.getCarName());
            }
        }

        return winnerCarNames;
    }

    private int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }
}
