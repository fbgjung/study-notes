package Java.Java알고리즘.delta;

import java.util.Arrays;

// 2차원 문자 배열 
// if-else 구조의 4방 탐색은 개발자의 실수를 많이 유발
// 상,하,좌,우 이동에 대한 변화량을 미리 배열로 계산
// 한 칸이 이동이 아닌 될 수 있을 때까지 계속 이동 
public class DeltaTest2 {
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

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                print8(i, j);
            }
        }
    }

    static int dx4[] = {-1,1,0,0};
    static int dy4[] = {0,0,-1,1};

    static void print4(int x, int y) {
        System.out.print(map[x][y] + " : ");

        for (int d = 0; d < 4; d++) {
            // 반복문으로 구성, ny = y... -> ny = ny ...
            int nx = x;
            int ny = y;

            while(true) {
                nx = nx + dx4[d];
                ny = ny + dy4[d];
    
                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    System.out.print(map[nx][ny]);
                } else{ break; }
            }
            
        }
        System.out.println();
    }

    // 대각선
    static int dx4x[] = {-1, -1, 1, 1};
    static int dy4x[] = {-1, 1, 1, -1};

    static void print4x(int x, int y) {
        System.out.print(map[x][y] + " : ");
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;

            while(true) {
                nx = nx + dx4x[d];
                ny = ny + dy4x[d];
    
                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    System.out.print(map[nx][ny]);
                } else{ break; }
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
            int nx = x;
            int ny = y;

            while(true) {
                nx = nx + dx8[d];
                ny = ny + dy8[d];
    
                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5) {
                    System.out.print(map[nx][ny]);
                } else{ break; }
            }
        }
        System.out.println();
    }

}
