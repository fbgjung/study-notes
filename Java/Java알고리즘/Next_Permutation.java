package Java.Java알고리즘;

import java.util.Arrays;

/**
 * Next Permutation
 * 재귀적으로 구현하지 않고 각 인덱스 값을 비교하여 모든 경우의 인덱스 값을 뽑아내는 방법
 * 조합에도 써먹을 수 있다. 
 * 
 */
public class Next_Permutation {
    static int[] src = {3,1,5,4,2};

    public static void main(String[] args) {
        // NP
        // asc로 정렬 1,2,3,4,5
        // 반복 (가장 작은수로 출발해서 가장 큰수로 만드는 과정 -> 이 과정의 하나하나가 바로 순열)
            // 위 정렬의 수보다 하나 더 큰 수 
            // 1 2 3 5 4
            // 1 2 4 3 5
            //  ....
            // 5 4 3 2 1
        Arrays.sort(src);
        while(true) {
            System.out.println(Arrays.toString(src));
            if(!np()) break; 
        }
    }

    static boolean np() {
        // 3
        // 맨 뒤에서 출발
        int i = src.length - 1;
        
        // 뒤보다 앞이 크거나 같으면( 내림차순으로 정렬되어 있으면 ) 계속 가다가 그렇지 않으면 멈춘다.
        // 5 <-- 4 <-- 2 까지는 계속
        // 1 X 5 <-- 4 <-- 2
        while( i > 0 && src[i-1] >= src[i] ) --i;
        
        // 맨 앞까지 왔으면 종료
        if( i == 0 ) return false;
        
        // 현재 src[i-1] 이 src[i] 보다 작은 상태
        // src[i] 이후 항목 (src[i] 보다 작은) 과 src[i-1]과 비교 필요
        
        // 맨 뒤에서 출발
        int j = src.length - 1;
        // i 이전 항목 중 src[i-1] 보다 작은 것은 무시하고, 큰 것이 있으면 멈춤 
        //  만약 큰 것이 있으면 그것과  없으면 src[i] 와 교환
        while( src[i-1] >= src[j]) --j;
        swap( src, i-1, j );
        
        // i 부터 맨 뒤까지 reverse
        int k = src.length - 1;
        while( i < k ) {
            swap(src, i++, k--);            
        }
        return true;
    }

    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
