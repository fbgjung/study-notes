package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;

/**
 * 최소의 연산을 사용해서 1로 만들자
 * 1에서 부터 x로 가는! 점화식을 이용해서 
 */
public class _2_1로만들기 {
    static int[] dp = new int[30001];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x = sc. nextInt();


        for (int i = 2; i <= x; i++) {
            // 현재 수 i를 만드는 최소 방법의 수를 찾는다.
            // 이전 수 중 + 1 => i
            dp[i] = dp[i-1] + 1;
            // 이전 수 중 * 2 => i: i가 2로 나누어 떨어진다.
            if (i % 2 == 0) {
                dp[i] = Math.min( dp[i / 2] + 1, dp[i]);
            }
            
            // 이전 수 중 * 3 => i
            if (i % 3 == 0) {
                dp[i] = Math.min( dp[i / 3] + 1, dp[i]);
            }

            // 이전 수 중 * 5 => i
            if (i % 5 == 0) {
                dp[i] = Math.min( dp[i / 5] + 1, dp[i]);
            }

        }
        System.out.println(dp[x]);
        sc.close();
    }
    
}
