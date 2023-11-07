package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Lotto;

import java.text.DecimalFormat;

public class OutputView {
    public static final String AMOUNT_OF_LOTTO = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "\n당첨 통계";
    public static final String DIVIDER_LINE = "---";
    public static final String PROFIT_ANNOUNCEMENT = "총 수익률은 ";
    public static final String PROFIT_ANNOUNCEMENT_CLOSING = "%입니다.";


    public static void printUserLotto(User user) {
        System.out.println("\n"+user.getAmount()+AMOUNT_OF_LOTTO);
        for (Lotto lotto: user.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
    public static void printResult(Result result) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER_LINE);
        for(Rank currentrank : Rank.values()) {
            if (currentrank == Rank.NONE) {
                continue;
            }
            int count = result.getResults().stream()
                    .filter(rank -> rank == currentrank)
                    .mapToInt(rank -> 1)
                    .sum();
            int awardMoney = currentrank.getAwardMoney();
            String message = currentrank.getMessage();

            System.out.println(message + " ("+formatNumber(awardMoney)+"원) - "+ count+"개");
        }

    }
    private static String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
    public static void printProfitRate(double value) {
        System.out.println(PROFIT_ANNOUNCEMENT+Math.round(value*100.0)/100.0+PROFIT_ANNOUNCEMENT_CLOSING);
    }
}
