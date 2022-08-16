package 배열.오프라인_데이터_샘플_구하기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.12 오프라인 데이터 샘플 구하기
     * @param k  샘플 개수
     * @param numbers  숫자 배열
     * @return 임의의 크기의 부분 배열
     */
    public static List<Integer> randomSampling(int k, List<Integer> numbers) {
        Random gen = new Random();
        for (int i = 0; i < k; i++) {
            // i ~ 마지막 인덱스 사이에서 임의의 수 생성 후 해당 수가 앞으로 갈 수 있도록 스왑
            Collections.swap(numbers, i, gen.nextInt(numbers.size() - i));
        }
        return numbers.subList(0, k);
    }

    @Test
    void test() {
        int k = 3;
        List<Integer> numbers = Arrays.asList(3, 7, 5, 1);
        assertThat(randomSampling(k, numbers))
                .hasSize(k);
    }
}
