package Java.Java알고리즘.input;

import java.util.Arrays;
import java.util.Scanner;

// 종합 비타밍~? 사용자 입장에서 간결하게 사용할 수 있어서 편함
// 다소 무겁다
public class ScannerTest {
    public static void main(String[] args) {
        // 1 2 3 4 5
        {
            Scanner sc = new Scanner(System.in); // 콘솔로 입력 받아서 System.in
            int[] input = new int[5];

            for (int i = 0; i < 5; i++) {
                input[i] = sc.nextInt();
            }
            
            // 출력
            // for (int i = 0; i < 5; i++) {
            //     System.out.println(input[i]);
            // }

            // Arrays.toString: ','으로 구분해서 출력
            System.out.println(Arrays.toString(input)); // [1, 2, 3, 4, 5]
            sc.close();
            
        }


        // 1 A 3 4 B
        {
            Scanner sc = new Scanner(System.in);
            char[] input = new char[5];

            for (int i = 0; i < 5; i++) {
                input[i] = sc.next().charAt(0); // 공백문자를 기준으로 하나씩 문자열로 처리한다 "1" "A" ...
            }
            
            System.out.println(Arrays.toString(input)); // [1, A, 3, 4, B]
            sc.close();
        }


        // ABCDE
        {
            Scanner sc = new Scanner(System.in); 
            // stack memory의 input이 heap에 5개짜리 배열이 만들어진다. 
            // char[] input = new char[5]; // 가비지된다능 

            // toCharArray가 heap memory에 하나 또 만든다
            // nextLine은 문자열 입력 받음 
            // input = sc.nextLine().toCharArray();  // "ABCDE" -> ['A',...]
            char[] input = sc.nextLine().toCharArray();
            System.out.println(Arrays.toString(input));
            
            sc.close();
        }

/**
 * 5
 * 1 2 3 4 5
 */
        {
            Scanner sc = new Scanner(System.in); 

            int n = sc.nextInt();
            int[] input = new int[n];

            for (int i = 0 ; i < n; i++) {
                input[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(input));
            
            sc.close();
        }

/**
 * 5/n
 * ABCDE
 */
        {
            Scanner sc = new Scanner(System.in); 

            int n = sc.nextInt(); // 다음 개행이나 스페이스 있을 때까지 읽어
            System.out.println(n);
            sc.nextLine(); // 주의! ! 남아있는 빈 개행문자를 처리해야 다음줄이 읽힌다 
            // char[] input = new char[5]; // 낭비
            char[] input = sc.nextLine().toCharArray();

            System.out.println(Arrays.toString(input));
            
            sc.close();
        }

    }
    
}
