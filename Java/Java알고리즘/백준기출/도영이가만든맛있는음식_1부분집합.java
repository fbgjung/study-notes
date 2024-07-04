package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1.부분집합
 * select 배열
 */
public class 도영이가만든맛있는음식_1부분집합 {

    static int N, min;
    static int[][] src; // 재료(신, 쓴)
    static boolean[] selected;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료수
        
        src = new int[N][2];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        subset(0); // 첫번째 재료부터 시작
        System.out.println(min);
    }

    static void subset(int srcIdx) {
        // 기저조건
        if (srcIdx == N) {
            // 부분집합이 한 경우가 만들어짐
            // 문제의 경우를 따지면 된다.
            // select true인 재료를 사용
            int sin = 1; // 신맛
            int ssn = 0; // 쓴맛
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    sin *= src[i][0];
                    ssn += src[i][1];
                    cnt++;
                }
            }
            if (cnt > 0) min = Math.min(min, Math.abs(sin-ssn));

            return;
        }
        
        selected[srcIdx] = true;
        subset(srcIdx+1);

        selected[srcIdx] = false;
        subset(srcIdx+1);
    }
}

/*
2
3 8
5 8

1
=======
4
1 7
2 6
3 8
4 9

1
 */