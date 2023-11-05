package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import lotto.domain.Lotto;
public class LottoTicketService {
    public static Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(numbers);
    }
}
