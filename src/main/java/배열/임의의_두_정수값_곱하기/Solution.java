package 배열.임의의_두_정수값_곱하기;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.3 임의의 두 정수값 곱하기
     * @param num1  숫자 배열1
     * @param num2  숫자 배열2
     * @return 두 수의 곱을 리스트로 나타낸 값
     */
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        // 결과값의 부호
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        // 곱셈 결과 자릿수는 최대 num1 자릿수 + num2 자릿수
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        // 일의 자리 수 부터 차례대로 곱셈
        for (int i = num1.size() - 1; i >= 0; i--) {
            for (int j = num2.size() -1; j >= 0; j--) {
                // 결과를 담을 리스트의 맨 오른쪽부터 채우기
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }

        // 0으로 시작하는 부분 제거
        int zeroCount = 0;
        while (zeroCount < result.size() && result.get(zeroCount) == 0) {
            zeroCount++;
        }
        result = result.subList(zeroCount, result.size());

        // 0인 경우 체크
        if (result.isEmpty()) {
            return List.of(0);
        }

        // 부호 적용
        result.set(0, result.get(0) * sign);

        return result;
    }

    @Test
    void test() {
        List<Integer> num1 = Arrays.asList(1, 2, 9);
        List<Integer> num2 = Arrays.asList(5, 2, 3);
        assertThat(multiply(num1, num2))
                .hasSameElementsAs(List.of(6, 7, 4, 6, 7));

        num1 = Arrays.asList(1, 2, 9);
        num2 = Arrays.asList(-2, 3);
        assertThat(multiply(num1, num2))
                .hasSameElementsAs(List.of(-2, 9, 6, 7));

        num1 = Arrays.asList(1, 2, 9);
        num2 = Arrays.asList(0);
        assertThat(multiply(num1, num2))
                .hasSameElementsAs(List.of(0));
    }
}
