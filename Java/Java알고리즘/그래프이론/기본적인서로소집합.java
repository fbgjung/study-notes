package Java.Java알고리즘.그래프이론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정점과 간선 정보를 이용해서 집합 소속 관계를 따지고싶다. 일차원 배열로
 */
public class 기본적인서로소집합 {

    static int v, e; // 정점, 간선
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v+1]; // 1번 정범부터
        
        // 자료구조를 집합관계로 만들어랑. 
        makeSet(); // 각 정점은 모두 서로소인 상태가 된다. parent[3] = 4 (3정점은 4가 부모인 집합에 포함)

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            union(x, y);
        }

        for (int i = 1; i <= v; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println();
        for (int i = 1; i <= v; i++) {
            System.out.print(findSet(i)+ " ");
        }
        System.out.println();
    }

    static void makeSet() {
        for (int i = 1; i < v+1; i++) {
            parent[i] = i;
        }
    }

    // 정점 x를 받으면 부모를 return 시켜줌 
    // return 값이 x의 부모가 된다.
    static int findSet(int x) {
        if (parent[x] == x) return x; // 자기자신과 똑같은 숫자를 갖고 있으면 자기가 부모
        return findSet(parent[x]);
    }

    // 두 정점을 하나의 집합으로 만듦
    // 두 부모의 수 중 작은 수를 부모로 (어떤 정점의 부모가 누구인지 알아야 한다. -> findSet)
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px < py) parent[py] = px;  
        // 1 4 parent[4] = 1
        // parent[2] = 3
        // parent[2] = 4

        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
    }
}


/*
// 정점, 간선 개수
6 4 
1 4
2 3
2 4
5 6 
*/

/**
1 2 3 4 5 6 
1 1 2 1 5 5 
1 1 1 1 5 5
 */