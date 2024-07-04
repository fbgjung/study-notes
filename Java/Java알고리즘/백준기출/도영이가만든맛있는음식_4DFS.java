package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 각 단계마다 신맛, 쓴맛을 달고다녀.. 그때그때 계산을 바로해서
 */
public class 도영이가만든맛있는음식_4DFS {
    static int N, min;
    static int[][] src; // 재료(신, 쓴)

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료수
        src = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        dfs(0,1,0);
        System.out.println(min);
    }

    // dfs로 푸는 것은 호출된 시점에 문제 풀이의 일부가 계속 계산되어서 다음 단계에 넘어가야 한다.
    static void dfs(int srcIdx, int sinSum, int ssnSum) { // 현재 단계 이전까지의 신맛, 쓴맛의 합
        // 기저조건
        if( srcIdx == N ) return;

        // 매 단계마다 신맛 쓴맛 계산
        int crrSin = src[srcIdx][0] * sinSum;
        int crrSsn = src[srcIdx][1] + ssnSum;

        min = Math.min(min, Math.abs(crrSin - crrSsn));

        // 현재의 재료를 선택하고 계속 가는 경우
        dfs(srcIdx+1, crrSin, crrSsn);

        // 현재의 재료를 선택하지 않고 계속 가는 경우
        dfs(srcIdx+1, sinSum, ssnSum);
    }
}
