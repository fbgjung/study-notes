package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;

public class 백준_설탕배달 {
    static int n, cnt;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();

        // 들고갈 수 없다면 -1 출력
        while (n >= 0) {
            if (n % 5 == 0) {
                cnt += ( n / 5 );
                System.out.println(cnt);
                sc.close();
                return;
            } 

            n -= 3;
            cnt++;
        }

        System.out.println(-1);
        sc.close();
    }
}
