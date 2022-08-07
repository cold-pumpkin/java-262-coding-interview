package 기본자료형.사각형이_겹치는지_확인하기;


public class Solution {
    public static class Rectangle {
        int x;      // 왼쪽 아래 꼭지점 x 좌표
        int y;      // 왼쪽 아래 꼭지점 y 좌표
        int width;
        int height;
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static boolean isIntersect(Rectangle R1, Rectangle R2) {
        return R1.x <= R2.x + R2.width
                && R1.x + R1.width >= R2.x
                && R1.y <= R2.y + R2.height
                && R1.y + R1.height >= R2.y;
    }
}
