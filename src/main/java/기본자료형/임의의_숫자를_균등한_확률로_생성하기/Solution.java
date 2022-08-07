package 기본자료형.임의의_숫자를_균등한_확률로_생성하기;

import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1;
        int result;

        do {
            result = 0;
            // 0 ~ b-a 사이 숫자 생성
            for (int i = 0; (1 << i) < numberOfOutcomes; i++) {
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOutcomes);

        return result + lowerBound;
    }

    // 0 혹을 1을 랜덤으로 생성
    private static int zeroOneRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }


    @Test
    void test() {
        assertThat(uniformRandom(10, 73))
                .isBetween(10, 100);
        assertThat(uniformRandom(10, 80))
                .isBetween(10, 80);
    }
}
