package 기본자료형.거듭제곱_계산하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 4.7 x^y 계산하기
     * @param x  밑수
     * @param y  지수
     * @return x^y 결과값
     */
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        // 지수가 음수인 경우 양수로 만들어주고 밑수를 분수로 만든다.
        if (y < 0) {
            power = -power;
            x = 1 / x;
        }

        // 지수가 반 씩 나누면서 밑수 거듭제곱을 수행한다.
        while (power != 0) {
            // 지수가 홀수인 경우 x를 한 번 더 곱해준다.
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }


    @Test
    void test() {
        assertThat(power(10, 2))
                .isEqualTo(100);

        assertThat(power(5, 3))
                .isEqualTo(125);

        assertThat(power(0.2, -3))
                .isEqualTo(125);
    }
}
