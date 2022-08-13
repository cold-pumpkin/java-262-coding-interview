package 배열.대체_연산;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.8 대체 연산
     * @param numbers  숫자 배열
     * @return 규칙에 따라 재배치된 배열
     */
    public static List<Integer> rearrange(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (isEven(i) && numbers.get(i-1) >= numbers.get(i)) {
                continue;
            }
            if (!isEven(i) && numbers.get(i) <= numbers.get(i)) {
                continue;
            }
            Collections.swap(numbers, i-1, i);
        }
        return numbers;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }


    @Test
    void test() {
        List<Integer> numbers = Arrays.asList(2, 1, 0 , 4, 5, 6, 10, 7, 8);
        assertThat(rearrange(numbers))
                .hasSameElementsAs(List.of(1, 2, 0, 4, 6, 5, 7, 10, 8));
    }
}
