package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * MST
 * 정점 중심 - 인접리스트 , 인접행렬
 * 시작점으로부터 가장 가까운 정점 
 * PriorityQueue에 담긴(고려하는 정점) 정점 중 가장 비용이 적은 정점을 꺼내서
 * 갈 수 있는 새로운 정점을 다시 PQ에 넣고 이 과정을 반복한다.
 * 비용이 가장 작은 정점 선택이 V개가 되면 된다.
 */

 // 그래프: 인접리스트 입력 테케: 간선 정보
 // PriorityQueue
 // visited
public class 프림2_인접리스트 {

    static int V, E, result;
    static int[][] matrix;
    static boolean[] visited;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        matrix = new int[V][V];
        visited = new boolean[V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향으로 해주어야 한다. 
            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        // 프림
        visited[0] = true;
        for (int i = 0; i < V; i++) {
            if ( matrix[0][i] == 0) continue; // 갈 수 없거나 이미 방문한 곳
            pqueue.offer(new Vertex(i, matrix[0][i])); // 정점 번호 i, 비용: 꺼낸 vertex.v -> i로 가는(인접한 비용)
        }
        int cnt = 1;

        while( !pqueue.isEmpty() ) {
            Vertex vertex = pqueue.poll();

            if ( visited[vertex.v] ) continue;

            // MST를 구성하는 정점이 선택됨
            visited[vertex.v] = true;
            result += vertex.c;
            cnt++;
            if (cnt == V) break; // 다 선택했기 때문에 멈춤
            
            // 꺼낸 정점으로부터 갈 수 있고 아직 방문하지 않은 정점이 있으면 pqueue에 추가
            for (int i = 0; i < V; i++) {
                if ( matrix[vertex.v][i] == 0 || visited[i]) continue; // 갈 수 없거나 이미 방문한 곳
                pqueue.offer(new Vertex(i, matrix[vertex.v][i])); // 정점 번호 i, 비용: 꺼낸 vertex.v -> i로 가는(인접한 비용)
            }
        }
        System.out.println(result);
    }

    static class Vertex {
        int v, c;
        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}


/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
==>10 MST의 총 비용
 */
