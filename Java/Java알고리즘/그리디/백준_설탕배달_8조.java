package Java.Java알고리즘.그리디;

import java.util.Scanner;

public class 백준_설탕배달_8조 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        while (n >= 0) {
            if( n % 5 == 0) {
                result += n / 5;
                System.out.println(result);
                sc.close();
                return;
            } else {
                n -= 3;
                result++;
            }
        }

        System.out.println(-1);
        sc.close();
    }
}
