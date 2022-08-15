package 배열.n보다_작은_모든_소수_나열하기;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 5.9 n보다 작은 모든 소수 나열하기
     * @param n 입력값
     * @return 1과 n 사이에 있는 모든 소수 리스트
     */
    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        // p의 소수 여부를 담고있는 리스트 (0, 1 제외하고 true로 초기화
        List<Boolean> isPrime = initIsPrime(n);

        for (int p = 2; p <= n; p++) {
            if (isPrime.get(p)) {
                primes.add(p);
                // p의 배수는 소수가 아니므로 false
                for (int j = p; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }

    private static List<Boolean> initIsPrime(int n) {
        List<Boolean> isPrime =new ArrayList<>(Collections.nCopies(n+1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        return isPrime;
    }

    @Test
    void test() {
        assertThat(generatePrimes(18))
                .hasSameElementsAs(List.of(2, 3, 5, 7, 11, 13, 17));
    }
}
