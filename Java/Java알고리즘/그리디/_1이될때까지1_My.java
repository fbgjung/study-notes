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
public class _1이될때까지1_MySolution {
    static int n,k,result;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());   
        result = 0;

        while(n > 1) {
            if ( n % k == 0 ) {
                n = ( n / k );
                result++;
            } else {
                n -= 1;
                result++;
            }
            
        }
        
        System.out.println(result);
    }
}
