package racingcar.model;

public class Car {

    private String carName;
    private int distance;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.distance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            distance += 1;
        }
    }
}
