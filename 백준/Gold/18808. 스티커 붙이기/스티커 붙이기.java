import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		List<int[][]> stickers = new ArrayList<>();
		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int tn = Integer.parseInt(st.nextToken());
			int tm = Integer.parseInt(st.nextToken());
			int[][] temp = new int[tn][tm];
			for (int i = 0; i < tn; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < tm; j++) {
					temp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			stickers.add(temp);
		}
		
		for (int[][] sticker : stickers) {
			boolean isPasted = false;
			int cnt = 0;
			while (cnt < 4 && !isPasted) {
				for (int i = 0; i <= n - sticker.length; i++) {
					if (isPasted) {
						break;
					}
					for (int j = 0; j <= m - sticker[0].length; j++) {
						if (isValid(map, sticker, i, j)) {
							paste(map, sticker, i, j);
							isPasted = true;
							break;
						}
					}
				}
				cnt++;
				sticker = rotate(sticker);
				
			}
		}
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					answer++;
				}
			}
		}
		System.out.print(answer);
	}
	
	private static int[][] rotate(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		int[][] result = new int[cols][rows];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][rows - 1 - i] = arr[i][j];
			}
		}
		
		return result;
	}
	
	private static void paste(int[][] map, int[][] sticker, int si, int sj) {
		int rows = sticker.length;
		int cols = sticker[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (sticker[i][j] == 1) {
					map[i + si][j + sj] = 1;
				}
			}
		}
	}
	
	private static boolean isValid(int[][] map, int[][] sticker, int si, int sj) {
		int n = map.length;
		int m = map[0].length;
		
		int rows = sticker.length;
		int cols = sticker[0].length;
		
		if (si + rows > n || sj + cols > m) {
			return false;
		}
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (sticker[i][j] == 1) {
					if (map[i + si][j + sj] == 1) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
