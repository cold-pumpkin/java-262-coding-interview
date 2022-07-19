package 기본자료형.패리티_계산하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2 {
    /**
     * [비트 조작 트릭]
     * x & (x-1) 연산으로 마지막 비트를 1로 바꾸며
     * 모든 비트가 0이 될 때 까지 반복
     */
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;     // 연산 반복될 때 마다 1과 XOR 연산하여 결과값 업데이트
            x &= (x - 1);
        }
        return result;
    }

    @Test
    void test() {
        assertThat(parity(11)).isOne();        // 1011 -> 1
        assertThat(parity(68)).isZero();       // 1000100 -> 0
    }
}
