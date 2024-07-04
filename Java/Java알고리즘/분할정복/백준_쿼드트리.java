package Java.Java알고리즘.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_쿼드트리 {
    static int n;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        divide(0,0,n);
        System.out.println(sb);
    }

    static void divide(int y, int x, int n) {
        // y, x 좌표를 왼쪽위 시작점으로 하고 가로, 세로 n 길이만큼 무자가 모두 같은지 확인

        if ( check(y, x, n) ){
            sb.append(map[y][x]);
        } else {
            sb.append("(");
            int half = n / 2;
            divide(y, x, half);
            divide(y, x + half, half);
            divide(y + half, x, half);
            divide(y + half, x + half, half);
            sb.append(")");
        }
    }

    static boolean check(int y, int x, int n) {
        char ch = map[y][x];

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (ch != map[i][j]) return false;
            }
        }
        return true;
    }
}

// Top down
// 쪼개야하는지를 따져봄
// 전체가 일치하지 않으면 쪼개겠다.

// Bottom up
// 쪼갤 수 있을 때까지 쪼갠다.
