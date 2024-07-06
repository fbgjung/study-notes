package Java.Java알고리즘.그리디;

import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

/**
 * BufferedReader + static(optional)
 * static 변수는 재귀호출에서 공유
 * Local 변수 대비, 반복 태케가 있는 경우(SWEA) 각 테케별로 초기화 해줘야 한다. 
 */

public class 큰수의법칙4_static {
    static int n,m,k,result;
    static int[] arr;
    // 방법 1
    public static void main(String[] args) throws Exception {
        
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

        Arrays.sort(arr); 
        int first = arr[n - 1];
        int second = arr[n - 2]; 

        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); 

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

