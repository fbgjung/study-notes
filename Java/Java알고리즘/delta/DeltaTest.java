package Java.Java알고리즘.delta;

import java.util.Arrays;

// 2차원 문자 배열 
// if-else 구조의 4방 탐색은 개발자의 실수를 많이 유발
// 상,하,좌,우 이동에 대한 변화량을 미리 배열로 계산
public class DeltaTest {
    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        char ch = 'A';

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }

        // 출력
        for(int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        /**
         * [A, B, C, D, E]
           [F, G, H, I, J]
           [K, L, M, N, O]
           [P, Q, R, S, T]
           [U, V, W, X, Y]
         */

        //  System.out.println(Arrays.deepToString(map).replace("],","],\n")); // [[A, B, C, D, E], [F, G, H, I, J], [K, L, M, N, O], [P, Q, R, S, T], [U, V, W, X, Y]]

         // y = 3, x = 3 자리의 상하좌우 출력
        print4_no_delta(4, 4);

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                print8(i, j);
            }
        }
    }

    static void print4_no_delta(int y, int x) {
        // 상
        if( y-1 >= 0 ){
            System.out.print(map[y-1][x]);
        }

        // 하
        if( y+1 < 5 ){
            System.out.print(map[y+1][x]);
        }

        // 좌
        if( x-1 >= 0 ){
            System.out.print(map[y][x-1]);
        }
    
        // 우
        if( x+1 < 5 ){
            System.out.print(map[y][x+1]);
        }
        System.out.println();
    }

    // delta
    // 문제에 따라 순서를 고정시켜야하는 경우도 존재
    static int dx4[] = {-1,1,0,0};
    static int dy4[] = {0,0,-1,1};

    static void print4(int x, int y) {
        System.out.print(map[x][y] + " : ");
        for (int d = 0; d < 4; d++) {
            int nx = x + dx4[d];
            int ny = y + dy4[d];

            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                System.out.print(map[nx][ny]);
            }
        }
        System.out.println();
    }

    // 대각선
    // 좌상, 우상, 좌하, 우하 웅하하
    static int dx4x[] = {-1, -1, 1, 1};
    static int dy4x[] = {-1, 1, 1, -1};

    static void print4x(int x, int y) {
        System.out.print(map[x][y] + " : ");
        for (int d = 0; d < 4; d++) {
            int nx = x + dx4x[d];
            int ny = y + dy4x[d];

            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                System.out.print(map[nx][ny]);
            }
        }
        System.out.println();
    }

    // 8방
    static int dx8[] = {-1, -1, 1, 1, 0, 0, -1, 1};
    static int dy8[] = {-1, 1, 1, -1, -1, 1, 0, 0};

    static void print8(int x, int y) {
        System.out.print(map[x][y] + " : ");
        for (int d = 0; d < 8; d++) {
            int nx = x + dx8[d];
            int ny = y + dy8[d];

            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                System.out.print(map[nx][ny]);
            }
        }
        System.out.println();
    }


}
