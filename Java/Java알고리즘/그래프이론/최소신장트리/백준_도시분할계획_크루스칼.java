package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 크루스칼
 * 최소 비용으로 두 개의 마을을 분할하기 위해서는 가장 큰 비용이 드는 간선 1개를 없애면 된다.
 * 가장 마지막에 더한 비용을 빼면 정답니다.
 */
public class 백준_도시분할계획_크루스칼 {
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

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c); // 비용 오름차순으로 정렬

        // 크루스탈 시작
        makeSet();
        int cnt = 0;
        int temp = 0;
        for (Edge e : edges) {
            
            if (union(e.v1, e.v2)) {
                result += e.c;
                cnt++;
                temp = e.c;
                if (cnt == V) break;
            }   
            
        }
        result -= temp;
        System.out.println(result);
        System.out.println(Arrays.toString(parent));
    }

    static class Edge{
        int v1, v2, c;
        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

    static void makeSet() {
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
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
}


/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
*/