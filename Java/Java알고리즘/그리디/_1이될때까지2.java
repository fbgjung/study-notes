package Java.Java알고리즘.그리디;

import java.util.*;
import java.io.*;

/**
 * 1을 뺀다
 * k로 나눈다
 * solution: 최대한 많이 나눠주면 된다. 
 * 안 나누어지는 수는 반복적으로 -1 하지말고 미리계산해서(나누어지는 수까지의 차)
 */

public class _1이될때까지2 {
    static int n,k,result;
        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());   
            result = 0;
    
            while(true) {
                if (n == 1) break;
                if ( n % k == 0 ) {
                    n /= k;
                    result++;
                } else {
                    // 여러개 연산 갯수 처리 
                    int target = (n / k) * k;
                    result += (n-target); // targe:k로 나누어질 수 있는 수
                    n = target;
                }
                 
            }
            
            System.out.println(result);
    }
}
