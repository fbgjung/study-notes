package Java.Java알고리즘.분할정복;

import java.io.*;
import java.util.*;

/**
 * 분할정복
 */
public class 백준_Z_1반복문 {

    static int n, r, c, ans;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 2 제곱수
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = (int)Math.pow(2, n);  // n을 2^n으로 보정

        // 원점부터 (r,c) 까지의 거리
        int y = 0;
        int x = 0;

        // 반복문으로 분할정복
        // (r,c) 위치까지 찾아질 동안 계속 분할 처리
        while (true) {
            if (n == 1) break; // 더이상 쪼개어질 수 없을 때
            n /= 2;
            if ( r < y + n && c < x + n ) { // 1사분면
                ; // 분할 영역
            } else if( r < y + n && c >= x + n) {  // 2사분면
                ans += n * n * 1; // n을 반으로 나누었기 때문에 
                x += n;// 시작점 x만 이동
            } else if(r >= y + n && c < x + n ) { // 3사분면
                ans += n * n * 2;
                y += n;

            } else {
                ans += n * n * 3;
                y += n;
                x += n;
            } 
 
        }

        System.out.println(ans);
    }
    
}
