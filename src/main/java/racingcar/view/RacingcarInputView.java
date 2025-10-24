package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingcarInputView {

    public static List<String> carNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        return parseCarNames(carNames);
    }

    public static int attemptCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return getAttemptCount();
    }

    public static List<String> parseCarNames(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("구분자 쉼표(,)가 존재하지 않습니다.");
        }

        return List.of(carNames.split(","));
    }

    public static int getAttemptCount() {
        String attemptCount = Console.readLine();

        if (!attemptCount.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.");
        }

        return Integer.parseInt(attemptCount);
    }
}
