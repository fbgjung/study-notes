package Java.Java알고리즘;

/**
 * 전체 부분집합 출력 
 * 조합의 합이라고 볼 수 이쏴
 */
public class SubSet_Basic {

    static int[] src = {1,2,3,4,5};
    static boolean[] select = new boolean[src.length];
    public static void main(String[] args) {
        subset(0);
    }
    
    static void subset(int srcIdx) {
        // 기저조건
        if (srcIdx == src.length) {
            printSubset();
            return;
        }
        
        // 현재 srcIdx에 대해서 선택, 비선택을 이어간다.
        select[srcIdx] = true;
        subset(srcIdx+1);

        select[srcIdx] = false;
        subset(srcIdx+1);
    }

    static void printSubset() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < src.length; i++) {
            if (select[i]) sb.append(src[i]).append(" ");
        }
        System.out.println(sb);
    }
}

/**
1 2 3 4 5 
1 2 3 4 
1 2 3 5 
1 2 3 
1 2 4 5 
1 2 4 
1 2 5 
1 2 
1 3 4 5 
1 3 4 
1 3 5 
1 3 
1 4 5 
1 4 
1 5 
1 
2 3 4 5 
2 3 4 
2 3 5 
2 3 
2 4 5 
2 4 
2 5 
2 
3 4 5 
3 4 
3 5 
3 
4 5 
4 
5 

 */