package Java.Java알고리즘.동적프로그래밍;

import java.util.Scanner;

/**
 * n kg 을 배달해야함
 * 봉지는 3kg, 5kg 짜리가 있는데
 * 필요한 최소 봉지의 수
 * 
 * DFS
 * 시간 초과!!!! N이 큰 수가 되면 재귀호출이 많이 일어나게 된다. 
 */
public class 백준_설탕배달_1완탐 {
    static int n, min;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();
        min = 5000;
        dfs(0, 0); // 시작, 둘 다 0개

        min = min == 5000 ? -1 : min;
        System.out.println(min);

        sc.close();
    }

    static void dfs(int five, int three) { // 5kg 몇개, 3kg 몇개
        // 기저 조건 
        int sum = five * 5 + three * 3;

        if ( sum == n ) { // 성공한 경우
            min = Math.min(min, five + three); // 최소값 갱신
            return;
        } else if ( sum > n ) {
            return; //  실패한 경우
        } 

        dfs(five + 1, three);
        dfs(five, three +1);

    }
}
