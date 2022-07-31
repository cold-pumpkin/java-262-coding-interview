package 기본자료형.같은_무게를_가진_가장_가까운_정수_찾기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2 {
    /**
     * 4.4 같은 무게를 가진 가장 가까운 정수 찾기
     * @param x  64비트 숫자
     * @return 같은 무게를 가진 가장 가까운 정수
     */
    public static long closestIntSameBitCount(long x) {
        final int UNSIGNED_NUM_BITS = 63;  // 음이 아닌 정수이므로 최상위 비트는 고려하지 않음
        for (int i = 0; i < UNSIGNED_NUM_BITS - 1; i++) {
            // 최하위 비트부터 탐색하며 서로 다른 연속한 두 비트를 찾아 스왑
            if ( ((x >>> i) & 1) != ((x >>> (i + 1)) & 1) ) {
                x ^= (1L << i) | (1L << (i+1));  // i번째 <-> i+1번째 비트 스왑
                return x;
            }
        }

        throw new IllegalArgumentException("모든 비트가 0 혹은 1입니다.");
    }

    @Test
    void test() {
        // 73 : 01001001 => 74 : 01001010
        assertThat(closestIntSameBitCount(73))
                .isEqualTo(74);
    }
}
