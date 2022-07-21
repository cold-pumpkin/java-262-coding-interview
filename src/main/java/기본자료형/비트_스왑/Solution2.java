package 기본자료형.비트_스왑;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2 {
    /**
     * 4.2 비트 스왑
     * 스왑할 비트가 다른 경우에만 스왑
     */
    public static long swapBits(long x, int i, int j) {
        // i번째 비트 & j번째 비트 비교
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // 다른 경우 XOR 연산을 활용해 각 비트를 뒤집기
            long mask = (1L << i) | (1L << j);
            x ^= mask;
        }
        return x;
    }

    @Test
    void test() {
        // 73 : 01001001 => 11: 00001011
        assertThat(swapBits(73, 1, 6))
                .isEqualTo(11);
    }
}
