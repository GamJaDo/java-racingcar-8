package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(List<String> carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }

        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
