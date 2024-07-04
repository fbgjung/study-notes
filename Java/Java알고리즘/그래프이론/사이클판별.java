package Java.Java알고리즘.그래프이론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클판별 {
    static int v, e;
    static int[] parent;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        makeSet();

        // 간선 연결 하는 과정에서 cycle이 발생하는지 판단
        boolean cycle = false;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (findSet(x) == findSet(y)) {
                System.out.println(x + " " + y);
                cycle = true; 
                break;
            }
            else union(x, y);
        }

        if (cycle) {
            System.out.println("사이클 발생");
        } else {
            System.out.println("사이클 발생 x");
        }
    }

    static void makeSet() {
        for (int i = 1; i < v+1; i++) {
            parent[i] = i;
        }
    }
    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px < py) parent[py] = px;  

        else parent[px] = py; 
    }
}

/*
3 3
1 2
1 3
2 3

2 3
사이클 발생
*/


/*
7 9
1 2
1 5
5 6
2 3
2 6
3 4
6 4
6 7
4 7

2 6
사이클 발생

-- 2 6을 맨 뒤로 보내보자.
7 9
1 2
1 5
5 6
2 3
3 4
6 4
6 7
4 7
2 6

6 4
사이클 발생

-- 2 6, 6 4 뺴기
7 7
1 2
1 5
5 6
2 3
3 4
6 7
4 7

4 7
사이클 발생

-- 4 7 제거
7 6
1 2
1 5
5 6
2 3
3 4
6 7

사이클발생x
*/