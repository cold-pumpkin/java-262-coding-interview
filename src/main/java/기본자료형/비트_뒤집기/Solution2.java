package 기본자료형.비트_뒤집기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution2 {
    // 8비트로 이루어진 수(0~255)를 역순으로 뒤집은 모든 값들을 가진 룩업 테이블 (생략)
    final static int[] precumputedReverse = new int[]{0, 128, 64, 192};    // precomputedParity[0 ~ 255]

    /**
     * 4.3 비트 뒤집기 (룩업 테이블 활용)
     * @param x  32비트 숫자
     * @return 비트를 역순으로 재구성한 숫자
     */
    public static int reverseBits(int x) {
        final int WORD_SIZE = 8;
        final int BIT_MASK = 0xFF;  // 최하위 8개 비트만 남기기 위한 값

        return precumputedReverse[(x & BIT_MASK)] << (3 * WORD_SIZE)  // 가장 하위 8개 비트 값의 역순을 구한 후 상위 비트 자리로
                | precumputedReverse[(x >>> WORD_SIZE) & BIT_MASK] << (2 * WORD_SIZE)
                | precumputedReverse[(x >>> 2 * WORD_SIZE) & BIT_MASK] << WORD_SIZE
                | precumputedReverse[(x >>> 3 * WORD_SIZE) & BIT_MASK];  // OR 연산으로 4개 결과값을 반영
    }

    @Test
    void test() {
        // 43261596(= 00000010100101000001111010011100)
        // => 964176192 (= 00111001011110000010100101000000)
        assertThat(reverseBits(43261596))
                .isEqualTo(964176192);
    }
}
