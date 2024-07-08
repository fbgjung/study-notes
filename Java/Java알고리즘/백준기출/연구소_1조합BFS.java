package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 조합으로 완탐
 */
public class 연구소_1조합BFS {
    static int N, M, max;
	static int[][] map, copyMap;
	static ArrayList<Node> zero = new ArrayList<Node>();
	static ArrayList<Node> virus = new ArrayList<Node>();
	static int zeroSize;
	static Node[] wall = new Node[3];
	
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static Queue<Node> queue = new ArrayDeque<Node>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;				
				if( n == 0 ) {
					zero.add(new Node(i, j));
				}else if( n == 2) {
					virus.add(new Node(i, j));
				}
			}
		}
		
		zeroSize = zero.size();
		comb( 0, 0 );

		System.out.println(max);
	}

	static void comb(int srcIdx, int tgtIdx ) {
		if( tgtIdx == 3 ) {
			check();
			return;
		}
				
		if( srcIdx == zeroSize ) return;
		
		wall[tgtIdx] = zero.get(srcIdx);
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
		
	}
	
	static void check() {

		//////// map copy 하면서 copyMap 자동으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		//////// wall
		for (int i = 0; i < 3; i++) {
			int y = wall[i].y;
			int x = wall[i].x;
			copyMap[y][x] = 1;
		} 
		
		//////// virus
		// bfs
		// 초기 virus 를 queue 에 담는다.
		queue.addAll(virus);

		// bfs 로 virus 퍼지게
		while( !queue.isEmpty() ) {
			Node n = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if( ny < 0 || nx < 0 || ny >= N || nx >= M ) continue;
				if( copyMap[ny][nx] == 0 ) { // 빈 칸이면
					copyMap[ny][nx] = 2;
					queue.offer(new Node( ny, nx ));
				}
			}
		}
		
		// virus 가 퍼지고 난 뒤 남은 0 계산
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if( copyMap[i][j] == 0 ) sum++;
			}
		}
		
		// max 갱신
		max = Math.max(max, sum);
	}
	
	static class Node{
		int y, x;
		Node(int y, int x) {
			this.y = y; this.x = x;
		}
	}
    
}
