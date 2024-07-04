package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집 {
    static int r,c,result;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        // 2차원 char배열 간단 입력 방법 
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 첫번째 행부터 실행해보자.
        for (int i = 0; i < r; i++) {
            if (check(i, 0)) result++;
        }

        System.out.println(result);

    }
    static boolean check(int x, int y) { // 행, 열
        map[x][y] = '-'; // 방문체크를 한다.  

        if (y == c-1) // 원웅이의 빵집에 도착한다면
        return true;

        if (x > 0 && map[x-1][y+1] == '.') {
            if (check(x-1, y+1)) return true;
        }

        if (map[x][y+1] == '.') {
            if (check(x, y+1)) return true;
        }

        if (x+1 < r && map[x+1][y+1] == '.') {
            if (check(x+1, y+1)) return true;
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