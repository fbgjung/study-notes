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

 // 그래프: 인접행렬로 풀어보자
 // PriorityQueue
 // visited
public class 프림1_인접행렬 {

    static int V, result;
    static int[][] matrix;
    static boolean[] visited;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        matrix = new int[V][V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 프림
        /**
         * 방법1
         */
        // pqueue.offer(new Vertex(0,0));
        // int cnt = 0;

        /**
         * 방법2 한꺼번에 미리 집어넣기
         */
        visited[0] = true;
        for (int i = 0; i < V; i++) {
            if ( matrix[0][i] == 0 ) continue; // 갈 수 없
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
크루스칼 한 거랑 같은 그래프임 행렬로 주어졌을 뿐

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
output==>10
 */