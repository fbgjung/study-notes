package Java.Java알고리즘;

import java.util.Arrays;

/**
 * 조합은 select 필요 x
 * src 의 맨 앞에서부터 tgt의 각 자리를 순차적으로 고려하면서 채운다.
 */
public class Combination_Basic {
    static int[] src = {1,2,3,4,5};
    static int[] tgt = new int[3];
    public static void main(String[] args) {
        comb(0,0);
    }
    static void comb(int srcIdx, int tgtIdx){
        if (tgtIdx == tgt.length) {
            // 순열 한 가지가 완성
            System.out.println(Arrays.toString(tgt));
            return;
        }

        if (srcIdx == src.length) return;

        tgt[tgtIdx] = src[srcIdx]; 
        
        comb(srcIdx + 1, tgtIdx + 1); 
        comb(srcIdx + 1, tgtIdx); 

    }
    
}

/**
[1, 2, 3]
[1, 2, 4]
[1, 2, 5]
[1, 3, 4]
[1, 3, 5]
[1, 4, 5]
[2, 3, 4]
[2, 3, 5]
[2, 4, 5]
[3, 4, 5]
 */