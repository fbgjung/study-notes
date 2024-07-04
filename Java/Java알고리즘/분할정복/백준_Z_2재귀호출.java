package Java.Java알고리즘.분할정복;

import java.io.*;
import java.util.*;

/**
 * 분할정복
 */
public class 백준_Z_2재귀호출 {

    static int n, r, c, ans;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 2 제곱수
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = (int)Math.pow(2, n);  // n을 2^n으로 보정

        z(0,0);

        System.out.println(ans);
    }

    static void z(int y, int x) {
        if (n == 1) return; // 더이상 쪼개어질 수 없을 때

        n /= 2;
        if ( r < y + n && c < x + n ) { // 1사분면
            z(y,x);
        } else if( r < y + n && c >= x + n) {  // 2사분면
            ans += n * n * 1; // n을 반으로 나누었기 때문에
            z(y, x += n);
        } else if(r >= y + n && c < x + n ) { // 3사분면
            ans += n * n * 2;
            z(y += n, x);
        } else {
            ans += n * n * 3;            
            z(y += n, x += n);
        } 
    }
}

/**
 *
 3 7 7

 63
 */