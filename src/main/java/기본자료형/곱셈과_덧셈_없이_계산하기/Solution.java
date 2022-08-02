package 기본자료형.곱셈과_덧셈_없이_계산하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 4.5 곱셈과 덧셈 없이 x * y 계산하기
     * @param x
     * @param y
     * @return 곱셈 결과
     */
    public static long multiply(long x, long y) {
        long result = 0;
        while (x != 0) {
            // 비트가 0이면
            if ((x & 1) != 0) {
                result = add(result, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return result;
    }

    // 덧셈 구현
    public static long add(long a, long b) {
        long sum = 0, carryIn = 0, k = 1;
        long initialA = a, initialB = b;

        while (initialA != 0 || initialB != 0) {
            // 계산할 비트 빼고 마스킹
            long maskedA = a & k, maskedB = b & k;
            // 다음 올림 수
            long carryOut = (maskedA & maskedB) | (maskedA & carryIn) | (maskedB & carryIn);
            // 덧셈 수행
            sum |= (maskedA ^ maskedB ^ carryIn);
            // 다음 비트 계산을 위한 셋팅
            carryIn = carryOut << 1;
            k <<= 1;
            initialA >>>= 1;
            initialB >>>= 1;
        }
        return sum | carryIn;
    }


    @Test
    void test() {
        assertThat(multiply(5, 15))
                .isEqualTo(75);
    }
}
