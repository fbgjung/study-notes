package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;


public class 백준_도시분할계획_프림 {
    static int V, E, result;
    static boolean[] visited;
    static int[][] matrix;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        matrix = new int[V+1][V+1];
        visited = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        pqueue.offer(new Vertex(1,0));
        int cnt = 0;
        int temp = 0;

        // 프림
        while( ! pqueue.isEmpty() ) {
            Vertex vertex = pqueue.poll();
            if ( visited[vertex.v] ) continue;

            visited[vertex.v] = true;
            result += vertex.c;
            temp = vertex.c;
            cnt++;

            if (cnt == V) break;

            for (int i = 1; i < V + 1; i++) {
                if (matrix[vertex.v][i] == 0 || visited[i]) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i]));
            }
        }

        System.out.println(result-temp);
    }

    static class Vertex {
        int v, c;
        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
