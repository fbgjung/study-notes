package Java.Java알고리즘.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        // 1 2 3 4 5
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine(); // 한줄 전체를 읽음
            StringTokenizer st = new StringTokenizer(str, ",");  // 구분자를 줄 수 있다. 1,2,3,4,5 -> [1, 2, 3, 4, 5] 없으면 스페이스바 한칸 

            int[] input = new int[5];
            for (int i = 0; i < 5; i++) {
                input[i] = Integer.parseInt(st.nextToken()); // 문자열이 하나씩 넘어온다 "1" "2" 이런식 -> 정수로 바꿔줘야 함
            }
            System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5]

        }


        // 1 A 3 B 5
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine(); 
            StringTokenizer st = new StringTokenizer(str); 

            char[] input = new char[5];
            for (int i = 0; i < 5; i++) {
                input[i] = st.nextToken().charAt(0); // 각각의 문자열에서 맨 앞에 있는 거를 넣는다~
            }
            System.out.println(Arrays.toString(input)); // [1, A, 3, B, 5]

        }


        // ABCDE
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            // String str = br.readLine();
            // char[] input = str.toCharArray();

            char[] input = br.readLine().toCharArray();

            System.out.println(Arrays.toString(input));

        }


/*
* 5
* 1 2 3 4 5
*/
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            
            int[] input =  new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n ; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(Arrays.toString(input));

        }

/*
* 5
* ABCDE
*/
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            char[] input = br.readLine().toCharArray();

            System.out.println(Arrays.toString(input));

        }

        /**
         * 2차원 베열
         * 5 (5 X 5)
         * 1 2 3 4 5
         * 6 7 8 9 0
         * 1 2 3 4 5
         * 6 7 8 9 0
         * 1 2 3 4 5
         */
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);

            int[][] input = new int[n][n];

            for (int i = 0 ; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); 
                for (int j = 0 ; j < n; j ++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 출력해보자 
            for (int i = 0 ; i < n; i++) {
                System.out.println(Arrays.toString(input[i]));
            }

        }

        

        /**
         * 2차원 직사각형 베열
         * 3 5  (3 X 5)
         * 1 2 3 4 5
         * 6 7 8 9 0
         * 1 2 3 4 5
         */
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()); // "3 5"
            int n = Integer.parseInt(st.nextToken()); // 3
            int m = Integer.parseInt(st.nextToken()); // 5

            int[][] input = new int[n][m];

            for (int i = 0 ; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < m; j ++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0 ; i < n; i++) {
                System.out.println(Arrays.toString(input[i]));
            }

        }


        /*
         * 첫 줄에 테스트 케이스 개수
         * 둘째줄부터 테스트케이스
         * 각 테스트케이스는 첫 줄에 N, M이 주어지고 
         * 이어지는 N개의 줄에 M개의 수가 주어진다.
         3
         2 2
         1 2
         6 7
         3 5
         1 2 3 4 5
         6 7 8 9 0
         1 2 3 4 5
         2 1
         8
         9
         */
        {
            // 1. 디버거를 적극적으로 활용하자. 
            // 2. 파일 입력을 적극적으로 활용하자.
            System.setIn(new FileInputStream("Java알고리즘/input.txt")); // 입력 파일 생성 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[][] input = new int[n][m];

                for (int i = 0 ; i < n; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < m; j++) {
                        input[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for (int i = 0 ; i < n; i++) {
                    System.out.println(Arrays.toString(input[i]));
                }
            }

        }

    }
    
}
