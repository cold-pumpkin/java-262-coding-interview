package 문자열.밑수_바꾸기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 6.2 밑수 바꾸기
     * @param numAsString 문자형 숫자
     * @param b1  밑수1
     * @param b2  밑수2
     * @return 밑수 변환된 값
     */
    public static String convertBase(String numAsString, int b1, int b2) {
        // 10진수로 변환
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;
        for (int i = isNegative ? 1 : 0; i < numAsString.length(); i++) {
            numAsInt *= b1;
            numAsInt += Character.isDigit(numAsString.charAt(i))
                    ? numAsString.charAt(i) - '0'
                    : numAsString.charAt(i) - 'A' - '0';
        }

        System.out.println(numAsInt);

        if (numAsInt  == 0) {
            return "0";
        }

        return (isNegative ? "-" : "") + constructFromBase(numAsInt, b2);
    }

    // 10진수 숫자를 base 진수로 변호나
    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? ""
                : constructFromBase(numAsInt / base, base)
                    + (char) ( (numAsInt % base) >= 10
                        ? 'A' + (numAsInt % base) - 10
                        : '0' + (numAsInt % base) );

    }


    @Test
    void test() {
        assertThat(convertBase("615", 7, 13))
                .isEqualTo("1A7");
        assertThat(convertBase("0", 5, 3))
                .isEqualTo("0");
    }
}
