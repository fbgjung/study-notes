package Java.Java알고리즘;

import java.util.*;
/**
 * 5개 수 중 3개의 수로 만들 수 있는 순열의 종류
 * 그 구성
 * 순열을 순서가 있는것 (1,2) (2,1) 다르다
 * 
 * 사용된 수는 제거하고 고려한다.
 */
public class Permutation_Basic {

    static int[] src = {1,2,3,4};
    static int[] tgt = new int[3]; //  __ __ __ <- tgtIdx
    static boolean[] select = new boolean[src.length]; // src 각각에 대한 이전 사용 여부 체크 
    public static void main(String[] args) {
        perm(0); // 첫번째 자리를 채우면서 시작
    }

    static void perm(int tgtIdx) {
        // 기저조건
        if (tgtIdx == tgt.length) {
            // 순열 한 가지가 완성
            System.out.println(Arrays.toString(tgt));
            return;
        }
        // tgtIdx 자리에 채울 수를 고려 
        for (int i = 0; i < src.length; i++) {
            // tgtIdx 앞자리에 이미 사용된 수만 제외, 사용된 수는 select[]에 기록
            if(select[i]) continue;
            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx+1); // 다 따지고 돌아와서 i+1이 되면 
            select[i] = false; // 로 원복 시켜줘야 한다. i가 이전 재귀호출에서 선택되어 고려되었으므로 다음 i를 위해 i 선택 해제
            // System.out.println(Arrays.toString(select));
        }
    }
}

/**
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 2]
[1, 3, 4]
[1, 3, 5]
[1, 4, 2]
[1, 4, 3]
[1, 4, 5]
[1, 5, 2]
[1, 5, 3]
[1, 5, 4]
[2, 1, 3]
[2, 1, 4]
[2, 1, 5]
[2, 3, 1]
[2, 3, 4]
[2, 3, 5]
[2, 4, 1]
[2, 4, 3]
[2, 4, 5]
[2, 5, 1]
[2, 5, 3]
[2, 5, 4]
[3, 1, 2]
[3, 1, 4]
[3, 1, 5]
[3, 2, 1]
[3, 2, 4]
[3, 2, 5]
[3, 4, 1]
[3, 4, 2]
[3, 4, 5]
[3, 5, 1]
[3, 5, 2]
[3, 5, 4]
[4, 1, 2]
[4, 1, 3]
[4, 1, 5]
[4, 2, 1]
[4, 2, 3]
[4, 2, 5]
[4, 3, 1]
[4, 3, 2]
[4, 3, 5]
[4, 5, 1]
[4, 5, 2]
[4, 5, 3]
[5, 1, 2]
[5, 1, 3]
[5, 1, 4]
[5, 2, 1]
[5, 2, 3]
[5, 2, 4]
[5, 3, 1]
[5, 3, 2]
[5, 3, 4]
[5, 4, 1]
[5, 4, 2]
[5, 4, 3]
 */