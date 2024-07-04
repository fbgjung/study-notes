package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 백준_최소스패닝트리_크루스칼 {
    static int V, E, result;
    static int[] parent;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new Edge[E];

        // 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        // 간선 정렬!!!
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);
        makeSet();
        int cnt = 0;
        for ( Edge e : edges ) {
            if (union(e.v1, e.v2)) {
                result += e.c;
                cnt++;
                if( cnt == V ) break;
            }
        }
        System.out.println(result);
    }

    static void makeSet() {
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
    }
    
    static int findSet(int x) {
        if (parent[x]  == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == py) return false;
        if (px < py) parent[py] = px;
        else parent[px] = py; 
        return true;
    }

    static class Edge{
        int v1, v2, c;
        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}
