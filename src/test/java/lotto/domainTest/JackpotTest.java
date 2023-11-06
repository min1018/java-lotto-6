package lotto.domainTest;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.JackpotNumber;
import lotto.domain.Lotto;
import lotto.utils.JackpotNumberException;

public class JackpotTest {

    @Test
    @DisplayName("입력 받은 당첨 로또 번호 중 1~45 사이의 수 외의 수가 입력된다면 예외처리한다.")
    void isInRangeTest() {
        assertThatThrownBy(() -> JackpotNumberException.isJackpotRange(new JackpotNumber(new Lotto(List.of(0, 23, 2, 4, 5, 46)))))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("입력 받은 당첨 로또 번호 중 중복된 수가 입력된다면 예외처리한다.")
    void isDuplicatedTest() {
        assertThatThrownBy(() -> JackpotNumberException.isJackpotDuplicated(new JackpotNumber(new Lotto(List.of(23, 23, 2, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("입력 받은 당첨 로또 번호가 6개가 아니라면 예외처리한다.")
    void isSixValuesTest() {
        assertThatThrownBy(() -> JackpotNumberException.isJackpotSixValue(new JackpotNumber(new Lotto(List.of(23, 2, 4, 5, 6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
