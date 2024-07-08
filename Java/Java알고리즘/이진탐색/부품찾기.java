package Java.Java알고리즘.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 부품찾기 {
    static int n, m, start, end;
    static int arr[];
    static int targetArr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        targetArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m ;i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // m 번 돌면서 찾자!! 해당 번호 있는지
        for (int i = 0; i < m; i++) {
            int target = targetArr[i];
            // 배열안에 해당 타겟 숫자가 있다면 yes
            if ( check(target) ) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static boolean check(int target) {
        start = 0; 
        end = n - 1; 
        while (start <= end) {

            int mid = ( start + end ) / 2; 

            if (target == arr[mid]) {
                return true;
            }
            else if ( target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }
}

/**
5
8 3 7 9 2
3
5 7 9

no yes yes
*/