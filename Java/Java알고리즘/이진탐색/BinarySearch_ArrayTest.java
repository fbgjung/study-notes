package Java.Java알고리즘.이진탐색;

import java.util.Arrays;

/**
 * 있어야하는 인덱스의 값을 리턴한다.
 */
public class BinarySearch_ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        System.out.println(Arrays.binarySearch(arr, 1)); // 원소 1에 해당하는 인덱스 0 반환
        System.out.println(Arrays.binarySearch(arr, 2)); // -2 반환  원래 1 반환되어야하는데 거기에 마이너스 붙이고 또 하나를 빼준 값이다.
        System.out.println(Arrays.binarySearch(arr, 0));
    }
    
}
