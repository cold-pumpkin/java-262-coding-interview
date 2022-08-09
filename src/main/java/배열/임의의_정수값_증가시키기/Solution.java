package 배열.임의의_정수값_증가시키기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public static List<Integer> plusOne(List<Integer> numbers) {
        int n = numbers.size() - 1;
        numbers.set(n, numbers.get(n) + 1);

        // 자리수 올림 있는 경우 0 셋팅
        for (int i = n; i > 0 && numbers.get(i) == 10; --i) {
            numbers.set(i, 0);
            numbers.set(i-1, numbers.get(i-1) + 1);
        }
        if (numbers.get(0) == 10) {
            numbers.set(0, 1);
            numbers.add(0);
        }

        return numbers;
    }

    @Test
    void test() {
        assertThat(plusOne(Arrays.asList(1, 2, 9)))
                .hasSameElementsAs(Arrays.asList(1, 3, 0));

        assertThat(plusOne(Arrays.asList(1, 0, 9, 5)))
                .hasSameElementsAs(Arrays.asList(1, 0, 9, 6));
    }
}
