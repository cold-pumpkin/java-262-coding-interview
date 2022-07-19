package 기본자료형.패리티_계산하기;

public class Solution3 {
    /**
     * [룩업 테이블]
     */
    // 16비트의 패리티 값을 모두 캐싱하고 있는 배열
    static int[] precomputedParity = new int[]{0, 1, 1, 0};    // precomputedParity[0 ~ 65536] = 패리티 값(0 or 1)

    public static short parity(long x) {    // x: 64비트 입력값
        final int WORD_SIZE = 16;       // 16비트 * 4개 씩 나누기 => 인덱스 0 ~ 65536
        final int BIT_MAST = 0xFFFF;    // 마스킹으로 최하위 16비트만 뽑아내기 위한 용도
        return (short) (
                precomputedParity[(int) (x >>> (3 * WORD_SIZE) & BIT_MAST)]     // 첫번째 16비트의 패리티 값
                ^ precomputedParity[(int) (x >>> (2 * WORD_SIZE) & BIT_MAST)]   // 두번째 16비트의 패리티 값
                ^ precomputedParity[(int) (x >>> WORD_SIZE & BIT_MAST)]         // 세번째 16비트의 패리티 값
                ^ precomputedParity[(int) (x & BIT_MAST)]                       // 마지막 16비트의 패리티 값
        );
    }
}
