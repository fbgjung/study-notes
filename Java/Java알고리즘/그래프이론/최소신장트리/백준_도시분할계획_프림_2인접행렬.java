package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 프림 + 인접행렬
 * 메모리 초과: matrix가 너무 커져서 10만 x 10만
 */
public class 백준_도시분할계획_프림_인접행렬_Teacher {
    static int N, M, result;
    static boolean[] visited;
    static int[][] matrix;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 간선 -> 인접 행렬 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        visited[1] = true;
        for (int i = 1; i < N+1; i++) {
            if (matrix[1][i] != 0) pqueue.offer(new Vertex(i, matrix[1][i]));
        }
        
        int maxCost = 0;
        int cnt = 1; // 선택된 정점의 수!!( 간선 아님 간선은 크루스칼 )

        while(!pqueue.isEmpty()) {
            Vertex vertex = pqueue.poll();
            if (visited[vertex.v]) continue;
            visited[vertex.v] = true;
            result += vertex.c;
            // maxCost = vertex.c; // 현재 큐에 있는 것 중에 작은 것 부터 나오기 때문에 이렇게 하면 x
            maxCost = Math.max(maxCost, vertex.c);
            cnt++;
            if (cnt == N) break; // 정점이기때문에 N-1 이아니라 N

            for (int i = 1;i < N+1; i++) {
                if(matrix[vertex.v][i] == 0 || visited[i]) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i]));
            }
        }
        System.out.println(result - maxCost);
    }

    static class Vertex {
        int v, c;
        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
