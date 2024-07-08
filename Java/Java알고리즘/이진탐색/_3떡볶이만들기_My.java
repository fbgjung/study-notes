package Java.Java알고리즘.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _3떡볶이만들기_My {
    static int n, m, temp;
    static int[] arr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // n개의 떡을 저장할 배열
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 정렬
        int max = arr[n-1]; // 19  가장 큰 값
        binary_search(0, max); 
    }
    
    static void binary_search( int start, int end) {
        // start, end  는 인덱스 기준임
        while(start <= end) {
            int mid = (start + end) / 2; // 인덱스 1 19 => arr[mid] = 10
            long term = 0; 

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    term += (arr[i] - mid);
                }
            }

            // 문제를 제대로 안읽었음!! 적어도!!!
            if (term >= m) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            } 
        }
        System.out.println(result);
    }
}


/**
4 6
19 10 15 17
 */