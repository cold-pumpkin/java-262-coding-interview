package 문자열.스프레드시트_열_인코딩_계산하기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    /**
     * 6.3 스프레드시트 열 인코딩 계산하기
     * @param column 스프레드시트 열 문자열
     * @return 정수로 변환된 값
     */
    public static int ssDecodeColdID(final String column) {
        return column.chars()
                .reduce(0, (subtotal, col) -> subtotal * 26 + (col - 'A' + 1));
    }

    @Test
    void test() {
        assertThat(ssDecodeColdID("AA"))
                .isEqualTo(27);
        assertThat(ssDecodeColdID("D"))
                .isEqualTo(4);
        assertThat(ssDecodeColdID("ZZ"))
                .isEqualTo(702);
    }
}
