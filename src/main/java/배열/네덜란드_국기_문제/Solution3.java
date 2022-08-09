package 배열.네덜란드_국기_문제;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static 배열.네덜란드_국기_문제.Color.*;

public class Solution3 {
    public static List<Color> dutchFlagPartition(int pivotIndex, List<Color> colors) {
        // 피벗으로 사용할 색
        Color pivot = colors.get(pivotIndex);

        // 1) 피벗보다 작은 색들 앞으로 보내기
        int smaller = 0;
        for (int i = 0; i < colors.size(); i++) {
            if (colors.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(colors, smaller++, i);
                break;
            }
        }

        // 2) 피벗보다 큰 색들 뒤로 보내기
        int larger = colors.size() - 1;
        for (int i = colors.size() - 1; i >= 0 && colors.get(i).ordinal() >= pivot.ordinal(); i--) {
            if (colors.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(colors, larger--, i);
            }
        }

        return colors;
    }


    @Test
    void test() {
        // RED - WHITE - BLUE
        List<Color> colors = Arrays.asList(BLUE, RED, RED, WHITE, RED, WHITE, BLUE, BLUE);
        Assertions.assertThat(dutchFlagPartition(3, colors))
                .hasSameElementsAs(List.of(RED, RED, RED, WHITE, WHITE, BLUE, BLUE, BLUE));
    }
}
