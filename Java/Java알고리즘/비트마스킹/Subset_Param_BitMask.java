package Java.Java알고리즘.비트마스킹;

/**
 * 부분집합은 조합의 함
 * select 배열을 parameter 화
 * select 배열 대신 bitmasking
 * <<, &, |
 */
public class Subset_Param_BitMask {
    static int[] src = {1,2,3,4,5};
    public static void main(String[] args) {
        // boolean[] select = new boolean[src.length];
        subset(0, 0);
    }

    static void subset(int srcIdx, int mask) { // mask: select 대체
        // 기저조건
        if (srcIdx == src.length) {
            printSubset(mask);
            return;
        }
        
        // 현재 srcIdx에 대해서 선택, 비선택을 이어간다.
        subset(srcIdx+1, mask | 1 << srcIdx); // mask의 bit 표현중 srcIdx 자리를 1로 변경
        subset(srcIdx+1, mask); // 1로 바꾸지 않고 원래있던것을 그대로 전달
    }

    static void printSubset(int mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < src.length; i++) {
            if ( (mask & 1 << i) != 0 ) sb.append(src[i]).append(" ");
        }
        System.out.println(sb);
    }
}

/*
 * 원소 5개 32bit 부호비트 빼고 31개의 원소에 대해 쓸 수 있다.
 * src는 힙에 객체가 만들어진다. 값을 바꾸고 일거오고 힙에 ~
 * 파라미터 mask에 넘어오는걸 바로 쓰면 된다. 기본타입 파라미터를 바로 쓸 수 있다.
 * 빠르다! 비트연산 빠르다!!!!
 * 훨씬 더 빠르다!!!
 */