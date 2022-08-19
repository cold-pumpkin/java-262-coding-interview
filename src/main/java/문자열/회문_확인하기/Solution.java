package 문자열.회문_확인하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 6.5 회문 확인하기
     * @param s 입력 문자열
     * @return 회문 확인 결과
     */
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // i, j는 영문자나 숫자가 아니면 스킵
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                ++i;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                --j;
            }
            if (Character.toLowerCase(s.charAt(i++))
                    != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        assertThat(isPalindrome("A man, a plan, a canal, Panama."))
                .isTrue();
        assertThat(isPalindrome("This is not palindrome"))
                .isFalse();
    }
}
