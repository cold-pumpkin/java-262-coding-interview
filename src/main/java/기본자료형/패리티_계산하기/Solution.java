package 기본자료형.패리티_계산하기;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution {
    /*
     주어진 x를 처음부터 끝까지 탐색하며 1을 만날 때 마다
     홀수 번째 인 경우 1, 짝수 번째인 경우 0으로 결과값을 업데이트
     */
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);  // 1과 & 연산자로 현재 비트가 1인지 판단 후 XOR 로 결과값을 업데이트
            x >>>= 1;
        }
        return result;
    }

    @Test
    void test() {
        assertThat(parity(11)).isOne();        // 1011 -> 1
        assertThat(parity(68)).isZero();       // 1000100 -> 0
    }
}
