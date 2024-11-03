package lotto;

import java.util.List;

public class LottoCheck {   // 로또 당첨 및 등수확인
    public int lottoRankResult (int match, boolean bonus) {     // 1~5등 조건
        if (match == 6) {
            return 1;
        }
        if (match == 5 && bonus) {
            return 2;
        }
        if (match == 4) {
            return 3;
        }
        if (match == 3) {
            return 4;
        }
        if (match == 2) {
            return 5;
        }
        return 0;
    }

    public int countMatches(List<Integer> userPurchasedLotto, List<Integer> winningNumber) {
        // 보너스번호 제외하고 유저가 구매한번호와 당첨번호가 몇개 맞는지 확인
        int match = 0;
        for (int number : userPurchasedLotto) {
            if (winningNumber.contains(number)) {
                match++;
            }
        }

        return match;
    }

    public int checkRank(Lotto userPurchasedLotto, List<Integer> winningNumber, int bonus) {    // 당첨 번호와 구매번호 비교해서 당첨 등수 확인
        int match = countMatches(userPurchasedLotto.getNumbers(), winningNumber);
        boolean bonusMatch = userPurchasedLotto.getNumbers().contains(bonus);

        return lottoRankResult(match, bonusMatch);
    }
}
