package 배열.다음_순열_구하기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.10 배열 안의 원소로 순열 구하기
     * @param perm  입력받은 순열
     * @return 사전순 다음 순열
     */
    public static List<Integer> nextPermutation(List<Integer> perm) {
        // 감소순열 시작되는 직전 지점 찾기
        // inversionPoint 이후는 감소순열
        int inversionPoint = perm.size() - 2;
        while (inversionPoint >= 0
                && perm.get(inversionPoint) >= perm.get(inversionPoint + 1)) {
            --inversionPoint;
        }

        // 이미 사전 순으로 마지막인 경우 빈 리스트 리턴
        if (inversionPoint < 0) {
            return Collections.emptyList();
        }

        // 감소순열 안에서 perm.get(inversionPoint) 보다 큰 수 중 가장 작은 수 검색하여 스왑
        // ㄴ 역순으로 검색
        for (int i = perm.size() - 1; i > inversionPoint; i--) {
            if (perm.get(i) > perm.get(inversionPoint)) {
                Collections.swap(perm, i, inversionPoint);
                break;
            }
        }

        // inversionPoint 이후 순열 뒤집기
        Collections.reverse(perm.subList(inversionPoint + 1, perm.size()));
        return perm;
    }


    @Test
    void test() {
        List<Integer> perm = Arrays.asList(6, 2, 1, 5, 4, 3, 0);
        assertThat(nextPermutation(perm))
                .containsExactly(6, 2, 3, 0, 1, 4, 5);

        perm = Arrays.asList(6, 5, 4, 3, 2, 1, 0);
        assertThat(nextPermutation(perm))
                .containsExactly();
    }
}
