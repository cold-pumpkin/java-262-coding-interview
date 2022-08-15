package 배열.배열_안의_원소로_순열_구하기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.10 배열 안의 원소로 순열 구하기
     * @param rule 재배열 규칙
     * @param numbers 숫자 배열
     * @return 재배열된 배열
     */
    public static List<Integer> applyPermutation(List<Integer> rule, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            // perm.get(i)가 음수이면 교환 사이클이 끝남
            // 양수이면 아직 교환 사이클이 끝나지 않았으므로 교환 진행
            int next = i;
            while (rule.get(next) >= 0) {
                Collections.swap(numbers, i, rule.get(next));
                int temp = rule.get(next);

                // 이미 사이클에 속해있음을 나타내기 위해 perm.size()를 빼서 음수로 만듦
                rule.set(next, rule.get(next) - rule.size());
                next = temp;
            }
        }

        return numbers;
    }

    @Test
    void test() {
        List<Integer> rule = Arrays.asList(2, 0, 1, 3);
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3);
        assertThat(applyPermutation(rule, numbers))
                .containsExactly(1, 2, 0, 3);

//        rule = Arrays.asList(2, 3, 1, 0);
//        numbers = Arrays.asList(0, 1, 2, 3);
//        assertThat(applyPermutation(rule, numbers))
//                .hasSameElementsAs(List.of(3, 0, 2, 1));
       }
}
