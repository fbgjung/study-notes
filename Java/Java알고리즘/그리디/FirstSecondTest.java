package Java.Java알고리즘.그리디;

public class FirstSecondTest {

    static int[] arr = {8,7,2,4,6,7,7,6,8};
    static int n = 9;

    public static void main(String[] args) {
        System.out.println(first());
        System.out.println(second());

    }

    static int first() {
        int first = 0;
        int firstIndex = 0;
        for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if (arr[i] > first) {
                first = arr[i];
                firstIndex = i;
            }
        }
        arr[firstIndex] = 0; // 가장 큰 수의 Index를 이용해서 0으로 변경
        return first;
    }
    static int second() {
        int second = 0;
        for (int i = 0; i < n; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if (arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }
}
