package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 비트마스킹 + DP
 */
public class 외판원순회 {
    static int N, allMask; // 모두방문 allMask
    static int INF = 9999999;
    static int[][] W; // 도시의 인접행렬
    static int[][] dp;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        allMask = ( 1 << N ) -1;
        W = new int[N][N];
        dp = new int[N][allMask];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0, 1));  // 0번도시부터 출발, 00001 1번 방문했다. 
    }
    
    static int tsp(int idx, int mask) { // 도시의 넘버링, 비트마스킹
        // 기저조건
        // mask가 모두 1이면 모든 도시를 방문( 되돌아가는 것만 남은 상황 )
        if (mask == allMask) {
            if (W[idx][0] == 0) return INF;
            else return W[idx][0]; // 되돌아가는 비용 return 
        }

        // 이미 최소비용이 계산되어 있는지
        if (dp[idx][mask] != 0) return dp[idx][mask]; // 갱신했으면 얘 써라 (여기서 굉장한 save가 생기는것?)
        
        // 충분히 큰 값으로 초기 설정
        dp[idx][mask] = INF;
        // 처음 idx 도시에서 mask에 남은 도시 상황
        for (int i = 0; i < N; i++) {
            // 현재 idx에서 i로 갈 수 있는지 따져봐야한다.
            // idx 도시에서 i 도시로 갈 수 없거나, i 도시를 idx 도착 전 이미 방문한 도시
            if (W[idx][i] == 0 || (mask & 1 << i) != 0) continue; 
            // Mask에 0인 아직 방문하지 않은 도시들 2, 4, 5에 해당
            dp[idx][mask] = Math.min(dp[idx][mask], W[idx][i] + tsp(i, mask | 1 << i));
        }
        return dp[idx][mask];
    }
}

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

35
 */
