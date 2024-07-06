package Java.Java알고리즘.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {
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
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            // 각 행별로 가장 작은 수 선택 
            int min_value = 100001;
            for (int j = 0; j < m; j++) {
                min_value = Math.min(min_value, map[i][j]);
            }
            result = Math.max(result, min_value);
        }
        System.out.println(result);
        
    }
}
