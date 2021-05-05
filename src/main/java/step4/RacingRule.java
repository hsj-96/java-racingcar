package step4;

import java.util.List;
import java.util.Random;

public class RacingRule implements Rule {
    private static final int CAN_GO = 4;
    private static final Random RANDOM = new Random();

    @Override
    public void go(Car car) {
        if (castDice() >= CAN_GO) {
            car.go();
        }
    }

    @Override
    public void go(Car car, int dice) {
        if (dice >= CAN_GO) {
            car.go();
        }
    }

    @Override
    public void goCars(List<Car> cars) {
        for (Car car : cars) {
            go(car);
        }
    }

    public int castDice() {
        return RANDOM.nextInt(10);
    }
}