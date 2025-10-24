package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = cars;
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public void playTurn() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> findWinnerCarNames() {
        int maxDistance = getMaxDistance();
        List<String> winnerCarNames = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winnerCarNames.add(car.getCarName());
            }
        }

        return winnerCarNames;
    }

    private int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        return maxDistance;
    }
}
