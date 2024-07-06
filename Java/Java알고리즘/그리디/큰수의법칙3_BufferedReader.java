package Java.Java알고리즘.그리디;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
/**
 * 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수, 두번째 큰 수만 고려
 * 가장 큰 수, 두번째 큰 수를 저렬을 통해서 구한다.
 * BufferedReader 
 */
public class 큰수의법칙3_BufferedReader {
    // 방법 1
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 
        int first = arr[n - 1];
        int second = arr[n - 2]; 

        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); 

        int result = 0;
        result += cnt * first; 
        result += (m - cnt) * second; 

        System.out.println(result);
    }
}

/**
 * 5 8 3
 * 2 4 5 4 6
 * 
 * 46
 */

