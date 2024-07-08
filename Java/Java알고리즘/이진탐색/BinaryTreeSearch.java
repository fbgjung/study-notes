package Java.Java알고리즘.이진탐색;

import java.util.Queue;
import java.util.ArrayDeque;

/**
 * 1차원 배열로 이진트리 표현
 *               1
 *      2                 3
 *   4       5        6        7
 * 8   9  10   11  12   13  14   15
 * 
 * 1차원 배열로 이루어진 이진트리를 BFS, DFS로 탐색해 본다.
 */

 /**
  * 이진트리 구조에서 부모 -> 자식을 찾아갈 때 왼쪽 자식은 부모 인덱스 *2, 오른쪽 자식은 부모 인덱스 *2+1이 된다.
  * 자식 -> 부모를 찾아갈 때 /2 한 
  */

public class BinaryTreeSearch {

    static int[] tree = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; // 자료구조로 사용
    static StringBuilder sb = new StringBuilder(); // 탐색순서 

    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        sb.setLength(0); // sb 비우기

        dfs(1);
        System.out.println(sb);
    }    
    
    static void bfs(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);

        while( ! queue.isEmpty() ) {
            int curIdx = queue.poll(); // 꺼내면 방문한 것

            // 탐색 순서 출력
            sb.append(tree[curIdx]).append(" ");

            // 5를 꺼냈으면 10, 11을 담아야한다. 인덱스 기준으로 왼쪽은 *2, 오른쪽은 *2 + 1
            int lcIdx = curIdx * 2; // 왼쪽 자식 인덱스
            int rcIdx = curIdx * 2 + 1; // 오른쪽 자식 인덱스

            if( lcIdx < tree.length ) queue.offer(lcIdx);
            if( rcIdx < tree.length ) queue.offer(rcIdx);
        }
    }

    static void dfs(int idx) {
        // 왼쪽자식을 먼저 간다. *2 를 먼저.
        if (idx >= tree.length) return;

        sb.append(tree[idx]).append(" ");
        // 왼족
        dfs(idx * 2);
        dfs(idx * 2 +1);
    }
}

/**
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
1 2 4 8 9 5 10 11 3 6 12 13 7 14 15 
 */