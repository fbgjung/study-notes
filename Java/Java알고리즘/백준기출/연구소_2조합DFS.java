package Java.Java알고리즘.백준기출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연구소_2조합DFS {

	static int N, M, max;
	static int[][] map, copyMap;
	static ArrayList<int[]> zero = new ArrayList<>();
	static ArrayList<int[]> virus = new ArrayList<>();
	static int zeroSize;
	static int[][] wall = new int[3][2];
	
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;				
				if( n == 0 ) {
					zero.add(new int[] {i,j});
				}else if( n == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		
		max = Integer.MIN_VALUE; // 이게 필요한가?????? 확인 후 이거 지워라
		
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

		// wall
		for (int i = 0; i < 3; i++) {
			int y = wall[i][0];
			int x = wall[i][1];
			copyMap[y][x] = 1;
		} 
		
		////////virus
		// 초기 virus 각각 dfs() 수행
		for (int[] v : virus) {			
			dfs( v[0], v[1] );
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

	static void dfs( int y, int x ) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if( ny < 0 || nx < 0 || ny >= N || nx >= M  ) continue;
			if( copyMap[ny][nx] == 0 ) {
				copyMap[ny][nx] = 2;
				dfs( ny, nx );
			}
		}
	}
}
