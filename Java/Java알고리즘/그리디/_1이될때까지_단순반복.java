package Java.Java알고리즘.그리디;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

/**
 * 1을 뺀다
 * k로 나눈다
 * solution: 최대한 많이 나눠주면 된다. 
 * 
 */
public class _1이될때까지_단순반복 {
    static int n,k,result;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());   
        result = 0; // 연산 수행 횟수

        while(true) {
            // 우선순위대로 n을 1로 변경해나가야한다.
            // 1이되면 종료해야한다. 
            if( n == 1 ) break;
            
            // k로 나눌 수 있으면 나눈다.
            if( n % k == 0 ){
                n /= k;
            } else {
                n -=1 ;
            }
            result++;
        }
        
        System.out.println(result);
    }
}
