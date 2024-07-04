package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * x는 무조건 +1
 * y는 -1,0,1
 * 그리디!!
 */
public class 빵집_그리디 {
    static int R, C, ans;
    static char[][] map;
    static int[] dy = {-1,0,1}; // 우선 순위: 상우, 우, 하우
    // visited 사용x -> 이전에 어떤 좌표를 지났으면 다음 시도(다음 파이프 연결)할 때 그 좌표는 이전에 성공하던 실패하던 갈 수가 없다.
        // 좌표를 따라가서 성공했다라면 이미 그 자리에 파이프가 놓여져 있는 것
        // 좌표를 따라가서 실패했다면 그 자리를 갈 필요가 없다.
        // 방문하면 'x' 표시 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 풀이
        // 맨 위부터 맨 아래행으로 내려오면서 연결 시도
        for (int i = 0; i < R; i++) {
            if (dfs(i,0)) ans++; // 열은 항상 왼쪽부터
        }
        System.out.println(ans); 
    }

    static boolean dfs(int y, int x) {
        int nx = x + 1; // 다음 움직임은 x는 무조건 1증가 (오른쪽)
        if (nx == C-1) return true; // 끝까지 갔다는 건 파이프 연결이 된 것이다. true 반환

        // for 문 안에서 3방향 중 우선순위로 탐색하되 먼저 성공하면, 나머지 탐색은 진행 x
        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            if (ny  < 0 || ny >= R || map[ny][nx] == 'x') continue;
            
            // 갈 수 있는 곳이면
            map[ny][nx] = 'x'; // 일종의 visited 체크
            if (dfs(ny, nx)) return true; // 세군데로 다 가면 안된다. 성공하자마자 리턴해주자 
        } 
        return false;
    }
}

/*
5 5
.xx..
..x..
.....
...x.
...x.

2
 */