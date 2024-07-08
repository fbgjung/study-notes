package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;
import java.util.Arrays;

public class 백준_설탕배달_3DP {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 초기값 처리
        if (n <= 5) {
            if (n == 3 || n == 5) System.out.println(1);
            else System.out.println(-1);
            sc.close();
            return;
        }
        
        dp = new int[n+1];
        Arrays.fill(dp, 5000);
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min( dp[i-3]+1, dp[i-5] + 1 );
        }

        if ( dp[n] == 5000 ) System.out.println(-1);
        else System.out.println(dp[n]); 
        sc.close();
    }
}

/**
 * 
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
 * - - - 1 - 1 2 - - 3 2  -  4  3  -  3  -  -  4
 * 
 */
