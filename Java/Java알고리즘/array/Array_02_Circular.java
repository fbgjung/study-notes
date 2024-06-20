package Java.Java알고리즘.array;

public class Array_02_Circular {
    public static void main(String[] args) {
        char[] input = {'A', 'B', 'C', 'D', 'E','F','G'}; // linear array
        int n  = input.length;

        /**
         * 예외 발생
         */
        for (int i = 0; i < n * 2; i++) {
            System.out.println(input[i]);
        }
        System.out.println();

        /**
         * ABCDEFGABCDEFG
         */ 
        for (int i = 0; i < n * 2; i++) {
            System.out.print(input[i % n]);
        }
        System.out.println();

        /**
         * 반복 횟수를 정확히 알 수 없을 때 
         * ABCDEFGABCDEFGABCDEF
         */
        int count = 0;
        int finish = 20;
        int i = 0;
        while(true) {
            if ( count == finish ) break;
            System.out.print(input[i % n]);
            count++;
            i++;
        }
        
    }
}
