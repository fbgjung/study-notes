package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

/**
 * 프림 + 인접리스트(정점을 담는것)
 * 메모리 초과: matrix가 너무 커져서 10만 x 10만
 */
public class 백준_도시분할계획_프림_인접리스트_Teacher {
    static int N, M, result;
    static boolean[] visited;
    static List<List<Vertex>> adjList = new ArrayList<>();
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+1; i++){
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        // 간선 -> 인접 행렬 만들기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(new Vertex(v2, c));
            adjList.get(v2).add(new Vertex(v1, c));
        }

        visited[1] = true;
        pqueue.addAll(adjList.get(1));  // offerAll()은 없다~ 
        
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

            // 꺼낸 애의 정점으로 부터 갈 수 있는 다른 모든 정점
            for (Vertex v : adjList.get(vertex.v)) {
                if (visited[v.v]) continue;
                pqueue.offer(new Vertex(v.v, v.c));
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
