package 기본자료형.비트_뒤집기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    static final int NUMBER_OF_DIGITS = 32;

    /**
     * 4.3 비트 뒤집기 (비트 스왑 활용)
     * @param x  32비트 숫자
     * @return 비트를 역순으로 재구성한 숫자
     */
    public static int reverseBits(int x) {
        for (int i = 0; i < (NUMBER_OF_DIGITS / 2); i++) {
            x = swapBits(x, i, NUMBER_OF_DIGITS - 1 - i);
        }
        return x;
    }

    // 4.2 비트 뒤집기
    private static int swapBits(int x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long mask = (1L << i) | (1L << j);
            x ^= mask;
        }
        return x;
    }

    @Test
    void test() {
        // 43261596(= 00000010100101000001111010011100)
        // => 964176192 (= 00111001011110000010100101000000)
        assertThat(reverseBits(43261596))
                .isEqualTo(964176192);
    }
}
