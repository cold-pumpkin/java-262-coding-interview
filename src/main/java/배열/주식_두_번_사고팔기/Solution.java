package 배열.주식_두_번_사고팔기;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.7 주식 두 번 사고팔기
     * @param prices 주가 리스트
     * @return 최대 이익
     */
    public static int buyAndSellStockTwice(List<Integer> prices) {
        int maxTotalProfit = 0;
        // 해당 날짜에 주식을 팔았을 때 최대 이익 리스트
        List<Integer> firstBuySellProfits = new ArrayList<>();
        int minPrice = Integer.MAX_VALUE;
        for (Integer price : prices) {
            minPrice = Math.min(minPrice, price);
            maxTotalProfit = Math.max(maxTotalProfit, price - minPrice);
            firstBuySellProfits.add(maxTotalProfit);
        }

        // 해당 날짜에 두번째 주식을 샀을 때 최대 이익
        int maxPrice = Integer.MIN_VALUE;
        for (int i = prices.size() - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices.get(i));
            maxTotalProfit = Math.max(maxTotalProfit, maxPrice - prices.get(i) + firstBuySellProfits.get(i-1));
        }

        return maxTotalProfit;
    }

    @Test
    void test() {
        List<Integer> prices = Arrays.asList(12, 11, 13, 9, 12, 8, 14, 13, 15);
        assertThat(buyAndSellStockTwice(prices))
                .isEqualTo(10);
    }
}
