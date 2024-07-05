package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 두 개 그룹으로 나누고, 잘 나뉘어 졌는지 확인(연결이 되어있는지)
 * 부분집합 선택된(A), 선택되지 않은(B)
 * 부분집합의 경우의 수가 완성되면 
 * 유효성 검사: 모두 연결되어 있는지 : 2차원 배열의 그래프 인접행렬을 구성 : BFS
 * A그룹 따로 B그룹 따로 있는 인접 구역을 모두 방문(visited[]) 이 모두 true로 되어있으면
 * 두 그룹 모두 방문 가능
 * 두 그룹의 인구수의 차이를 min
 */
public class 게리맨더링 {
    static int N, min;
    static int[][] matrix; // 그래프의 인접행렬은 i, j 모두 정점 j가 인덱스 정점x
    static boolean[] selected, visited; // selected(부분집합) visited(bfs 연결구조파악)
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1][N+1]; // 0 dummy -> 인구수 넣자 여기에
        selected = new boolean[N+1];
        visited = new boolean[N+1];

        // 인구수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        // 정점별 이웃하는 정점
        for (int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 1; j < size+1; j++) { // i 구역과 인접한 구역의 수
                int v = Integer.parseInt(st.nextToken());
                matrix[i][j] = v; // 굳이 빈공간 차지하도록 하지말고(내가 생각한것) 그냥 인접한 구역의 수 값만 채워넣자
            }
        }

        // 풀이
        min = Integer.MAX_VALUE;
        subset(1);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void subset(int srcIdx) {
        if (srcIdx == N+1){
            check();
            return;
        }
        
        selected[srcIdx] = true;
        subset(srcIdx + 1);

        selected[srcIdx] = false;
        subset(srcIdx+1);
    }


    /*
     * BFS 돌때 selecte 활용하면 되는 것이었다.
     */
    static void check() {
        // A, B 따로 각각 모두 연결 확인 bfs를 이용해서 visited 배열 완성
        Arrays.fill(visited, false);
        queue.clear();

        // A selected 배열 중 true
        for (int i = 1; i < N+1; i++) {
            if(selected[i]){
                visited[i] = true;
                queue.offer(i);
                break; // 시작점 하나 찾고 break;
            }
        } 

        if (queue.size() == 0) return; // 아무것도 뽑지 않은 공집합 따질필요 없음

        while(!queue.isEmpty()) {
            // 하나씩 꺼내서 갈 수 있는데를 다 가보자
            int v = queue.poll();  // 하나 선택
            for (int i = 1; i < N+1; i++) {
                int adj = matrix[v][i]; // 인접한 애들 하나씩 
                if (adj != 0 && !visited[adj] && selected[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        // B selected 배열 중 false
        for (int i = 1; i < N+1; i++) {
            if(!selected[i]){
                visited[i] = true;
                queue.offer(i);
                break; // 시작점 하나 찾고 break;
            }
        } 

        while(!queue.isEmpty()) {
            // 하나씩 꺼내서 갈 수 있는데를 다 가보자
            int v = queue.poll();  // 하나 선택
            for (int i = 1; i < N+1; i++) {
                int adj = matrix[v][i]; // 인접한 애들 하나씩 
                if (adj != 0 && !visited[adj] && !selected[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        // A, B 각각 visited를 갱신했지만 전체가 true 여야 모두 연결
        for (int i = 1; i < N+1; i++){
            if (!visited[i]) return;
        }

        // 유효검증 통과
        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i < N+1; i++) {
            if (selected[i]) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }

        min = Math.min(min, Math.abs(sumA-sumB));
    }
}
