package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_1인_우승일_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_2인_우승일_경우() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "3");
                assertThat(output()).contains("pobi : ", "woni : -", "jun : -",
                    "pobi : -", "woni : --", "jun : --", "pobi : -", "woni : ---", "jun : ---",
                    "최종 우승자 : woni, jun");
            },
            STOP, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 예외_테스트_자동차이름_5글자_초과() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,wonijun", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 예외_테스트_자동차이름_문자열에_구분자_쉼표가_없음() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobiwonijun", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자 쉼표(,)가 존재하지 않습니다.")
        );
    }

    @Test
    void 예외_테스트_이동횟수_입력시_숫자외에_입력할_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni,jun", "r"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자만 입력해야 합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
