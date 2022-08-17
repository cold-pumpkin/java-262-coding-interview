package 문자열.문자열과_정수_상호_전환하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 6.1 문자열과 정수 상호 전환하기
     * @param s 문자타입 숫자
     * @return int 타입으로 변환된 숫자
     */
    public static int stringToInt(String s) {
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return result;
    }

    /**
     * 6.1 문자열과 정수 상호 전환하기
     * @param x 문자열로 변환할 숫자
     * @return 문자열로 변환된 숫자
     */
    public static String intToString(int x) {
        int absX = Math.abs(x);
        StringBuilder result = new StringBuilder();
        do {
            result.append((char)('0' + absX % 10));
            absX /= 10;
        } while (absX > 0);

        if (x < 0) {
            result.append('-');
        }

        result.reverse();
        return result.toString();
    }

    @Test
    void test() {
        assertThat(stringToInt("4321"))
                .isEqualTo(4321);
        assertThat(stringToInt("0"))
                .isEqualTo(0);

        assertThat(intToString(4321))
                .isEqualTo("4321");
        assertThat(intToString(0))
                .isEqualTo("0");
    }
}
