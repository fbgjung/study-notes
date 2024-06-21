package Java.Java알고리즘.recursive;

public class FactorialTest {
    public static void main(String[] args) {
        factorial(5);
        System.out.println(factorial2(5));
        factorial3(5, 1);
    }

    // 계산 결과를 static 변수를 이용
    static int result = 1;
    static void factorial(int n) {
        /**
         * 기저조건
         * 1. 재귀호출을 끝내야 한다.
         * 2. 문제에서 원하는 상태가 완료되었다.
         */
        if (n == 1) {
            // 계산 결과 출력
            System.out.println(result);
            return;
        }
        result = result * n;

        factorial(n-1);
        // System.out.println("Returning from factorial(" + n + "), current result: " + result);

    }

    // 재귀호출 결과가 리턴 5 <- 4 <- 3 <- 2 <- 1 
    static int factorial2(int n) {

        // 기저조건
        if (n == 1) {
            // 계산 결과 출력 대신 재귀 호출 종료 처리
            return 1; 
        }
        // 계산
        // 3 단계 입장은 4에게 2x1의 결과에 3자신을 곱해서 리턴
        // 나보다 1적은 재귀호출을 수행하고 그 결과에 나를 곱한다음 리턴
        return n * factorial2(n-1);    
    }


    // 파라미터를 이용 (5, 1) 전달 받음
    static void factorial3(int n, int result) {
        // 종료처리 
        if (n == 1) {
            System.out.println(result);
            return ;
        }

        // 재귀호출 + 계산
        factorial3(n-1, result * n);
    } 


    

    
}
