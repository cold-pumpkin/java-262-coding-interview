package 배열.네덜란드_국기_문제.README;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static 배열.네덜란드_국기_문제.README.Color.*;

public class Solution2 {
    public static List<Color> dutchFlagPartition(int pivotIndex, List<Color> colors) {
        // 피벗으로 사용할 색
        Color pivot = colors.get(pivotIndex);

        // 1) 피벗보다 작은 색들 앞으로 보내기
        for (int i = 0; i < colors.size(); i++) {
            for (int j = i+1; j < colors.size(); j++) {
                if (colors.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }

        // 2) 피벗보다 큰 색들 뒤로 보내기
        // : 윗 단계에서 피벗보다 작은 원소들은 이미 앞쪽으로 옮겨졌기 때문에 피벗보다 작은 원소를 만나면 즉시 멈춤
        for (int i = colors.size() - 1; i >= 0 && colors.get(i).ordinal() >= pivot.ordinal(); i--) {
            for (int j = i-1; j >= 0 && colors.get(j).ordinal() >= pivot.ordinal(); j--) {
                if (colors.get(j).ordinal() > pivot.ordinal()) {
                    Collections.swap(colors, i, j);
                    break;
                }
            }
        }
        return colors;
    }


    @Test
    void test() {
        // RED - WHITE - BLUE
        List<Color> colors = Arrays.asList(BLUE, RED, RED, WHITE, RED, WHITE, BLUE, BLUE);
        assertThat(dutchFlagPartition(3, colors))
                .hasSameElementsAs(List.of(RED, RED, RED, WHITE, WHITE, BLUE, BLUE, BLUE));
    }
}
