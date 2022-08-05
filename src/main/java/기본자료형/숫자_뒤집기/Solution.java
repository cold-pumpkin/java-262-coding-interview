package 기본자료형.숫자_뒤집기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public static int reverse(int x) {
        int result = 0;
        int remaining = Math.abs(x);

        while (remaining != 0) {
            result = result * 10 + remaining % 10;
            remaining /=  10;
        }

        return x < 0 ? -result : result;
    }


    @Test
    void test() {
        assertThat(reverse(1234567))
                .isEqualTo(7654321);
    }
}
