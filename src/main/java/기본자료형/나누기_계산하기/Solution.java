package 기본자료형.나누기_계산하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public static long divide(long x, long y) {
        long result = 0;
        int power = 32; // 2^k
        long yPower = y << power;

        while (x >= y) {
            // x >= 2^k * y 만족하는 가장 큰 k 찾기
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }

            // 결과값에 2^k 증가시키고 x에서는 2^k * y 차감
            result += 1L << power;
            x -= yPower;
        }
        return result;
    }

    @Test
    void test() {
        assertThat(divide(100, 5))
                .isEqualTo(20);

        assertThat(divide(21, 4))
                .isEqualTo(5);
    }
}
