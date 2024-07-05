package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 완탐(dfs)
 */
public class 파이프옮기기1_1DFS {
    static int N, cnt;
    static int[][] map;
    // 이동 규칙이 담긴 delta
    static int[][][] delta = { // 0: 현재 이동 방향, 1: y변화량, 2: x변화량
        {{1,1}, {0,1}, {1,0}}, // 대각선 (대각선, 가로, 세로)
        {{1,1}, {0,1}, {0,0}}, // 가로
        {{1,1}, {0,0}, {1,0}}  // 세로
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {                
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs() 풀이
        dfs(1,2,1);
        System.out.println(cnt);
    }

    // visited? 필요 없다. 
    // 모든 좌표를 한번만 방문하는 문제x
    // 모든 가짓수를 따지는 문제 : 어느 y, x에 도달하지 이전에 다른 방법으로 다른 죄표를 거쳐서 올 수 있다. 
    static void dfs(int y, int x, int d) {
        // 기저조건
        if (y == N && x == N) {
            cnt++;
            return;
        }
        // 규칙이 적용된 delta를 이용해서 계속 가 본다.
        for (int i = 0; i < 3; i++) {
            int ny = y + delta[d][i][0];
            int nx = x + delta[d][i][1];

            // dummy check
            if (ny == y && nx == x) continue;
            if (ny > N || nx > N || map[ny][nx] == 1) continue; // 우하로 계속 증가 0보다 작은 부분 필요 x
            
            // 대각선일 경우 스치는 두 부분도 체크
            if (i == 0 && (map[ny][nx-1] == 1 || map[ny-1][nx] == 1)) continue;

            dfs(ny, nx, i); 
        }
    }
}
