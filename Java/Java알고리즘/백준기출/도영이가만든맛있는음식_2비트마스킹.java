package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 비트마스킹
 */
public class 도영이가만든맛있는음식_2비트마스킹 {

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
        subset(0,0); // 첫번째 재료부터 시작 , 아무것도 선택되지 않은 ....00000 비트마스킹 상태
        System.out.println(min);
    }

    static void subset(int srcIdx, int mask) {
        // 기저조건
        if (srcIdx == N) {
            // 부분집합이 한 경우가 만들어짐
            // 문제의 경우를 따지면 된다.
            // select true인 재료를 사용
            int sin = 1; // 신맛
            int ssn = 0; // 쓴맛
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & 1 << i) != 0) { // mask의 bit 표현 중 i 번째가 1인지 0인지 확인 (1이면 선택된것)
                    sin *= src[i][0];
                    ssn += src[i][1];
                    cnt++;
                }
            }
            if (cnt > 0) min = Math.min(min, Math.abs(sin-ssn));

            return;
        }
        
        subset(srcIdx+1, mask | 1 << srcIdx); // 현재 재료를 선택 , 그 재료를 1로 바꿔준다.
        subset(srcIdx+1, mask); // 현재 재료 (srcIdx) 선택 안할거면 그냥 표시안하고 넘어가면 된다.
    }
}
