package 배열.배열에서_이동하기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.4 배열에서 이동하기
     * @param maxAdvanceSteps  각 포지션에서 움직일 수 있는 최대 거리를 저장한 배열
     * @return 마지막 지점 도달 가능 여부
     */
    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int maxReachablePosition = 0, lastIndex = maxAdvanceSteps.size() - 1;

        for (int i = 0; i <= lastIndex && maxReachablePosition < lastIndex; i++) {
            maxReachablePosition = Math.max(maxReachablePosition, i + maxAdvanceSteps.get(i));
        }

        return maxReachablePosition >= lastIndex;
    }

    @Test
    void test() {
        List<Integer> maxAdvanceSteps = Arrays.asList(3, 2, 0, 0, 2, 0, 1);
        assertThat(canReachEnd(maxAdvanceSteps))
                .isTrue();

        maxAdvanceSteps = Arrays.asList(3, 2, 0, 0, 0, 0, -1);
        assertThat(canReachEnd(maxAdvanceSteps))
                .isFalse();
    }

}
