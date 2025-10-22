package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        List<String> carNameList = parseCarNames(carNames);

        HashMap<String, Integer> racingProgress = racingProgressReset(carNameList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            runRacing(carNameList, racingProgress);
            printProgress(carNameList, racingProgress);
        }
    }

    public static List<String> parseCarNames(String carNames) {

        return List.of(carNames.split(","));
    }

    public static HashMap<String, Integer> racingProgressReset(List<String> carNameList) {
        HashMap<String, Integer> racingProgress = new HashMap<String, Integer>();
        for (String carName : carNameList) {
            racingProgress.put(carName, 0);
        }

        return racingProgress;
    }

    public static void runRacing(List<String> carNameList, Map<String, Integer> racingProgress) {
        for (String carName : carNameList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                racingProgress.put(carName, racingProgress.get(carName) + 1);
            }
        }
    }

    public static void printProgress(List<String> carNameList, Map<String, Integer> racingProgress) {

        for (String carName : carNameList) {
            System.out.print(carName + " : ");
            for (int j = 0; j < racingProgress.get(carName); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
