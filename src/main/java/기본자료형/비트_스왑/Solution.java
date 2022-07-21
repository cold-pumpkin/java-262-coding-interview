package 기본자료형.비트_스왑;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 4.2 비트 스왑
     * i번째 비트와 j번째 비트를 구한 후 서로의 위치에 셋팅
     */
    public static long swapBits(long x, int i, int j) {
        // 최하위 비트(LSB) 기준 i번째 비트
        long ith_bit = (x >>> i) & 1;
        long jth_bit = (x >>> j) & 1;

        x = setBit(x, ith_bit, j);
        x = setBit(x, jth_bit, i);
        return x;
    }

    //  x의 p번째 비트를 bit로 셋팅
    //  https://www.geeksforgeeks.org/modify-bit-given-position/
    private static long setBit(long x, long bit, int p) {
        long mask = 1L << p;    // 변경할 위치만 1인 마스크
        return (x & ~mask)      // 변경할 위치의 비트를 0으로 셋팅
                | ((bit << p) & mask);  // 새로 셋팅할 비트를 변경할 위치까지 옮긴 후 마스킹하여 OR 연산
    }

    @Test
    void test() {
        // 73 : 01001001 => 11: 00001011
        assertThat(swapBits(73, 1, 6))
                .isEqualTo(11);
    }
}
