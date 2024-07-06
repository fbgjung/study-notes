package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

/* 
 * 안전영역 최대값 구하기
 */
public class 연구소_DFSBFS_My {
    static int N, M, max;
    static int[][] map;
    static int[][] visited; 
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    // 3개 고르기!!
    static void dfs(int d) {
        if (d == 3) {
            bfs(); // 바이러스 퍼트리기
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(d+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        // 바이러스 맵을 새로 만들어준다.
        int[][] virus_map = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_map[i][j] = map[i][j];
            }
        }

        // 바이러스 큐에 넣고 탐색하자~
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];     
            
            for (int i = 0; i < 4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && virus_map[ny][nx] == 0) {
                    virus_map[ny][nx] = 2; // 바이러스 퍼짐
                    queue.offer(new int[]{ny,nx});
                }
            }
        }
        safe(virus_map);
    }

    // 안전영역 구하기 - 갱신
    static void safe(int[][] virus_map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */