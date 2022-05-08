package 기본자료형.비트_뒤집기;

public class Solution {
    /*
       [Q4.2] i번째와 j 번째 비트를 바꾸기
     */
    public static long swapBits(long x, int i, int j) {
        // i번째 비트와 j번째 비트를 비교
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // 다른 경우 비트마스트 & XOR 활용해 각 비트를 뒤집기
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}
