package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.RacingcarInputView;
import racingcar.view.RacingcarOutputView;

public class RacingcarContoller {

    public void RacingcarRun() {
        List<String> carNames = RacingcarInputView.carNameInput();
        int attemptCount = RacingcarInputView.attemptCountInput();

        RacingCars racingCars = new RacingCars(carNames);

        RacingcarOutputView.printExecutionResult();
        for (int i=0; i<attemptCount; i++) {
            racingCars.playTurn();

            List<Car> turnCars = racingCars.getRacingCars();
            RacingcarOutputView.printProgress(turnCars);
        }

        List<String> winnerCarNames = racingCars.findWinnerCarNames();
        RacingcarOutputView.printWinners(winnerCarNames);
    }
}
