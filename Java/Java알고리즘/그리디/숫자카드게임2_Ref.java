package Java.Java알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2차원배열 제거, 입력받으면서 바로 처리
 */

public class 숫자카드게임2_Ref {
    static int n, m, result;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int min_value = 100001;
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                min_value = Math.min(min_value, input);
            }
            result = Math.max(result, min_value);
        }
        System.out.println(result);
        
    }
}
