package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1_2DP {
    static int N, result; // 현재 파이프 끝 위치
    static int[][] map;
    static int[][][] dp; 
    // (4,3)
    // dp[0][4][3] 대각선으로 4, 3
    // dp[1][4][3] 가로로 4, 3
    // dp[2][4][3] 세로로 4, 3
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new int[3][N+1][N+1];
        
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {                
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이
        dp[1][1][2] = 1; // 시작점
        
        for (int y = 1; y < N+1; y++) {
            for (int x = 2; x < N+1; x++) { // 시작이 2부터라서
                if (map[y][x] == 1) continue;

                // 대각선: 모든 경우를 다 더하면 된다
                // 대각선(0) -> 대각선
                // 가로(1) -> 대각선
                // 세로 -> 대각선
                if (y < N && x < N && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0) {
                    dp[0][y+1][x+1] += ( dp[0][y][x] + dp[1][y][x] + dp[2][y][x]);
                } 

                // 가로
                // 대각선 -> 가로
                // 가로 -> 가로
                if (x < N && map[y][x+1] == 0) {
                    dp[1][y][x+1] += (dp[0][y][x] + dp[1][y][x]);
                }

                // 세로
                // 대각선 -> 세로
                // 세로 -> 세로
                if (y < N && map[y+1][x] == 0) {
                    dp[2][y+1][x] += (dp[0][y][x] + dp[2][y][x]);
                }
            }
        }
        System.out.println(dp[0][N][N] + dp[1][N][N] +dp[2][N][N]);
    }
}