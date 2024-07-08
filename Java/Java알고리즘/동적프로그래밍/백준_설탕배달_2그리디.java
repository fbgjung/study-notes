package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;

/**
 * 5로 나누어 떨어지면 나누고 그렇지 않으면 3을 뺀다. 
 */
public class 백준_설탕배달_2그리디 {
    static int n, cnt;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();

        while (true) {
            if (n < 0) { // 줄여나가는 과정에서 n을 맞추지 못하고 음수가 되면 
                System.out.println(-1);
                break;
            } 

            // 0 이거나, 5로 나누어 떨어지는 경우 
            if (n % 5 == 0) { // -3으로 처리하고 난 뒤 0인경우도 포함
                System.out.println(n / 5 + cnt);
                break;
            }

            n -= 3;
            cnt++;
        }

        sc.close();
    }
}
