package 배열.네덜란드_국기_문제;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution4 {
    public static List<Color> dutchFlagPartition(int pivotIndex, List<Color> colors) {
        Color pivot = colors.get(pivotIndex);

        /**
         * 분류할 때 마다 다음 불변식 만족
         * - 피벗보다 작은 원소 그룹 : colors.subList(0, smaller)
         * - 피벗과 같은 원소 그룹 : colors.subList(smaller, equal)
         * - 미분류 원소 그룹 : colors.subList(equal, larger)
         * - 피벗보다 큰 원소 그룹 : colors.subList(larger, colors.size())
         */
        int smaller = 0, equal = 0, larger = colors.size();

        // 분류되지 않은 원소가 있는 동안 반복
        while (equal < larger) {
            // colors.get(equal) : 분류되지 않은 원소
            if (colors.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(colors, smaller++, equal++);
            } else if (colors.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else {
                Collections.swap(colors, equal, --larger);
            }
        }
        return colors;
    }

    @Test
    void test() {
        // RED - WHITE - BLUE
        List<Color> colors = Arrays.asList(Color.BLUE, Color.RED, Color.RED, Color.WHITE, Color.RED, Color.WHITE, Color.BLUE, Color.BLUE);
        assertThat(dutchFlagPartition(3, colors))
                .hasSameElementsAs(List.of(Color.RED, Color.RED, Color.RED, Color.WHITE, Color.WHITE, Color.BLUE, Color.BLUE, Color.BLUE));
    }
}
