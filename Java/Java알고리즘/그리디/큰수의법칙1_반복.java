package Java.Java알고리즘.그리디;

import java.util.*;
/**
 * 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수, 두번째 큰 수만 고려
 * 가장 큰 수, 두번째 큰 수를 저렬을 통해서 구한다.
 * 방법 1. 반복: 하나씩
 * 방법 2. 반복 미리 계산: 한꺼번게 계산
 */
public class 큰수의법칙1_반복 {
    // 방법 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // m 개가 될 때까지 가장 큰수를 우선적으로 k번 사용 + 두변째 수 1번 사용
        int result = 0;
        int totalCnt = 0;
        int kCnt = 0;

        while(true) {
            if ( totalCnt == m ) break; 
            
            // 현재 first를 k번 연속 사용한 상태 -> second 사용해야함
            if ( kCnt == k ) {
                result += second;
                kCnt = 0; 
            } else {
                result += first;
                kCnt++;
            }
            totalCnt++;   
        }

        System.out.println(result);
        sc.close();
    }
}

/**
 * 5 8 3
 * 2 4 5 4 6
 * 
 * 46
 */