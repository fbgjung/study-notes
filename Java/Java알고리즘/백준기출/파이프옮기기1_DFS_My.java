package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 빵집 문제가 생각나서 이렇게 품
 */
public class 파이프옮기기1_DFS_My {
    static int N, result; // 현재 파이프 끝 위치
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {                
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처음 파이프 끝 위치
        dfs(0,1,0);   // 가로부터 시작     
        System.out.println(result);
    }

    static void dfs (int y, int x, int direction) {
        if (y == N-1 && x == N-1) {
            result++;
            return;
        }

        // 가로 방향으로 있을 때 -> 가로, 대각선으로 갈 수 있음
        if (direction == 0) {
            if (x+1 < N && map[y][x+1] == 0) dfs(y, x+1, 0); // 가로로
            if (x+1 < N && y + 1 < N && map[y][x+1] == 0 && map[y+1][x+1] == 0 && map[y+1][x] == 0) dfs(y+1, x+1, 2); // 대각선으로
        }

        // 세로 방향으로 있을 때 -> 세로, 대각선으로 갈 수 있음
        if (direction == 1) {
            if (y+1 < N && map[y+1][x] == 0) dfs(y+1, x, 1); // 세로로
            if (x+1 < N && y + 1 < N && map[y][x+1] == 0 && map[y+1][x+1] == 0 && map[y+1][x] == 0) dfs(y+1, x+1, 2); // 대각선으로
        }

        // 대각선 방향으로 있을 때 -> 가로, 세로, 대각선으로 갈 수 있음
        if (direction == 2) {
            if (x+1 < N && map[y][x+1] == 0) dfs(y, x+1, 0); // 가로로
            if (y+1 < N && map[y+1][x] == 0) dfs(y+1, x, 1); // 세로로
            if (x+1 < N && y + 1 < N && map[y][x+1] == 0 && map[y+1][x+1] == 0 && map[y+1][x] == 0) dfs(y+1, x+1, 2); // 대각선으로
        }
    }
}

/*
3
0 0 0
0 0 0
0 0 0

1
====
6
0 0 0 0 0 0
0 1 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

13
 */