package Java.Java알고리즘.그래프이론.최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * MST
 * 간선 중심 (간선을 정렬해서 가장 비용이 작은 선택) - 간선리스트
 */
public class 크루스칼 {

    static int V, E, result; // MST 총 비용
    static int[] parent;
    static Edge[] edges; // 간선 리스트

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V];
        edges = new Edge[E];

        // 입력 처리
        for (int i = 0; i < E; i ++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        /**
         * 크루스칼 알고리즘 
         */
        // 1. 간선 정렬
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c); // 비용 오름차순으로 정렬
        // 2. 집합 배열 처리 (서로소)
        makeSet();
        int cnt = 0; // V-1개 만들면 된다 (cycle이 없는)
        
        for (Edge edge : edges) {
            // 3. cycle 체크
            if (union(edge.v1, edge.v2)) {
                result += edge.c;
                cnt++; // 간선 선택
                if (cnt == V-1) break;
            } 
        }
        System.out.println(result);
    }

    static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    /*
     * 크루스탈 사용 버전
     */
    static boolean union(int x, int y) { 
        int px = findSet(x);
        int py = findSet(y);

        if (py == px) return false; // 두 부모가 같다. cycle 발생

        if (px < py) parent[py] = px;  
        else parent[px] = py; 
        return true;
    }

    // static void union(int x, int y) {
    //     int px = findSet(x);
    //     int py = findSet(y);

    //     if (px < py) parent[py] = px;  
    //     else parent[px] = py; 
    // }
    
    static class Edge {
        int v1, v2, c;
        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

}

/*
정점수 간선수
시작정점 끝정점 가중치
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
----------------------------------
7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14
==>31
 */