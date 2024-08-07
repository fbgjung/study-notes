package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;

public class _4_바닥공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] * 2 - dp[i-2];
        }

        System.out.println(dp[n]);

        sc.close();
    }
    
}
