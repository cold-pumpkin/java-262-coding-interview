package 기본자료형.회문_확인하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        // 자리수 = 밑이 10인 로그 적용 후 + 1
        final int numberOfDigits = (int)Math.floor(Math.log10(x)) + 1;
        // 맨 앞자리 수를 구하지 위한 값 = 10^(n-1)
        int mask = (int)Math.pow(10, numberOfDigits - 1);

        // 반복적으로 양 끝자리 비교
        for (int i = 0; i < (numberOfDigits / 2); i++) {
            if ((x / mask) != (x % 10)) {
                return false;
            }
            x %= mask;  // x의 최상위 숫자 삭제
            x /= 10;    // x의 최하위 숫자 삭제
            mask /= 100;
        }
        return true;
    }


    @Test
    void test() {
        assertThat(isPalindromeNumber(2147447412)).isTrue();
        assertThat(isPalindromeNumber(7)).isTrue();
        assertThat(isPalindromeNumber(123456)).isFalse();
    }
}
