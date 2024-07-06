package Java.Java알고리즘.그리디;

import java.util.*;
import java.io.*;

/**
 * BufferedReader + static(optional)
 * static 변수는 재귀호출에서 공유
 * Local 변수 대비, 반복 태케가 있는 경우(SWEA) 각 테케별로 초기화 해줘야 한다. 
 * 테케 입력을 파일로 처리
 */

public class 큰수의법칙6_시간복잡도 {
    static int n,m,k,result;
    static int[] arr;
    // 방법 1
    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("Java/Java알고리즘/그리디/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 안쓰는 숫자들까지 정렬? 
         * 그냥 배열 쭉 두번만 훑어서 가장 큰수와 두번째 큰수를 구하자 
         */
        // Arrays.sort(arr);  // O(NlogN) 시간복잡도

        // O(N)
        int first = first();
        int second = second();
    
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); 

        result += cnt * first; 
        result += (m - cnt) * second; 

        System.out.println(result);
    }

    static int first() {
        int first = 0;
        int firstIndex = 0;
        for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if (arr[i] > first) {
                first = arr[i];
                firstIndex = i;
            }
        }
        arr[firstIndex] = 0; // 가장 큰 수의 Index를 이용해서 0으로 변경
        return first;
    }
    static int second() {
        int second = 0;
        for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if (arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }
}

/**
 * 5 8 3
 * 2 4 5 4 6
 * 
 * 46
 */
