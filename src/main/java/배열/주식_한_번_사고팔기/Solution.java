package 배열.주식_한_번_사고팔기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.6 주식 한 번 사고팔기
     * @param prices 주가 리스트
     * @return 최대 이익
     */
    public static int computeMaxProfit(List<Integer> prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (Integer price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    @Test
    void test() {
        List<Integer> prices = Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250);
        assertThat(computeMaxProfit(prices))
                .isEqualTo(30);
    }
}
