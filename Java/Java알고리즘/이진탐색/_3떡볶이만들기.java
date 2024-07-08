package Java.Java알고리즘.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 자를 높이의 range가 중요
 * 이 range를 이진탐색으로 처리
 */
public class _3떡볶이만들기_Teacher {

    static int n, m, result;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 10_0000_0000;  // 문제 제시 중 높이에 대한 범위 중 최대값 (실제 배열에 든 떡 길이와는 무관)
        
        // 이진탐색
        while( start <= end ){
            long total = 0; // 자르고 남는 떡의 종합 <= m 을 만족시켜댜 한다.
            
            int mid = (start + end) / 2; // mid : 중간값 (높이)
            for (int i = 0; i < n; i++) {
                if( arr[i] > mid ) total += arr[i] - mid;
            }
            
            if( total < m ) { // 떡이 모자르다. 높이를 낮춰서 따져본다.
                end = mid - 1;
            }else { // 떡이 같거나 남는 상황
                result = mid; // 현재 시점의 최선의 정답을 저장하고 다시 따진다. ( 더 좋은 정답이 나올수도 안나올수도 있다. )
                start = mid + 1;
            }
        }
        
        System.out.println(result);
    }
}
/*
4 6
19 15 10 17
15
*/