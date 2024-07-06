package Java.Java알고리즘.그리디;

import java.util.Scanner;

/**
 * 1을 뺀다
 * k로 나눈다
 * solution: 최대한 많이 나눠주면 된다. 
 * 안 나누어지는 수는 반복적으로 -1 하지말고 미리계산해서(나누어지는 수까지의 차)
 */

public class _1이될때까지_ {
    static int n,k,result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k; 
            result += (n - target); 
            n = target; 
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            n /= k;
        }
        System.out.println(result); 
        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);
        System.out.println(result); 
        sc.close();
    }
}
