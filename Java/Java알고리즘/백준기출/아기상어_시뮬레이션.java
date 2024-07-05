package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상어가 먹는 상황을 반복
 * 발생했던 오류에 대한 원인
 * #1. PrioriyQueue? 상어위치 ~ 각 물고기: 맨하턴 거리 X 이동 불가한 지점이 포함될 수 있다.
 * #2. while if()에서 찾으면 바로 break: queue에 동등한 자격의 더 가까운 Node가 포함될 수 있다.
 */
public class 아기상어_시뮬레이션 {
    static int N, sy, sx, size, eat, ans; // 상어 위치, 크기, 먹는물고기수
    static int[][] map;
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 9) {
                    sy = i;
                    sx = j;
                }
                map[i][j] = n;
            }
        }

        // 시뮬레이션 풀이
        size = 2;
        // 상어는 가장 가까운 합당한 먹이를 찾고 먹는 작업을 반복(불가능할 때까지)
        while(true) {
            int cnt = bfs();
            if (cnt == 0) break;
            ans += cnt;
        }
        System.out.println(ans);
    }

    // 가장 가까운 합당한 먹이를 찾고 먹는 작업, 이동한 시간(거리) return, 못찾으면 -1 return
    static int bfs() {
        // 초기화
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE; // 최단거리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }

        // 현재 상어의 위치에서 출발
        visited[sy][sx] = true;
        queue.offer(new Node(sy,sx,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if (map[node.y][node.x] < size && map[node.y][node.x] != 0) {
                // 자격이되는 물고기를 찾음
                if (node.d < minDis) {
                    minDis = node.d;
                    minY = node.y;
                    minX = node.x;
                } else if(node.d == minDis){
                    if (node.y < minY) {
                        minDis = node.d;
                        minY = node.y;
                        minX = node.x;
                    } else if(node.y == minY) {
                        if(node.x < minX) {
                            minDis = node.d;
                            minY = node.y;
                            minX = node.x;
                        }
                    }
                }
                // break; // 안댐
            }
            
            // 가지치기 조금 safe가 된다. 밑에 for문 안가서 
            if ((node.d + 1) >= minDis) continue;

            // 이상한 사람이여
            for (int i = 0; i < 4; i++){
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] > size) continue;
                visited[ny][nx] = true;
                queue.offer(new Node(ny, nx, node.d + 1));
            }
        }

        // 이동한 거리 
        if (minDis == Integer.MAX_VALUE) return 0;
        else {
            eat++;
            if( eat == size ) {
                size++;
                eat = 0;
            }
            map[minY][minX] = 0; // 물고기를 먹어서
            map[sy][sx] = 0;  // 상어가 있던 자리
            sy = minY;
            sx = minX;
        }
        return minDis;
    }

    static class Node {
        int y, x, d; // 거리
        Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}

/*
3
0 0 0
0 0 0
0 9 0

0
======
4
4 3 2 1
0 0 0 0
0 0 9 0
1 2 3 4

14
=====
6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6

60
=====
 */