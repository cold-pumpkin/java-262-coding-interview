package 배열.정렬된_배열에서_중복_제거하기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.5. 정렬된 배열에서 중복 제거하기
     * @param numbers  정렬된 숫자 리스트
     * @return 중복 제거된 리스트
     */
    public static List<Integer> deleteDuplicates(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return Collections.emptyList();
        }

        int writeIndex = 1;  // 첫 중복 숫자가 나타난 위치
        for (int i = 1; i < numbers.size(); i++) {
            if (!numbers.get(writeIndex-1).equals(numbers.get(i))) {
                numbers.set(writeIndex++, numbers.get(i));
            }
        }
        return numbers.subList(0, writeIndex);
    }

    @Test
    void test() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 5, 6, 7, 11, 11, 11, 13);
        assertThat(deleteDuplicates(numbers))
                .hasSameElementsAs(Arrays.asList(2, 3, 5, 6, 7, 11, 13));

        numbers = Arrays.asList(0, 0);
        assertThat(deleteDuplicates(numbers))
                .hasSameElementsAs(List.of(0));
    }
}
