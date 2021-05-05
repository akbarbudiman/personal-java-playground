package src.main.java.dynamicprogramming.tabulation;

public class GridTravelerTabulation {

	/*
	 * 3:22:17
	 * https://youtu.be/oBt53YbR9Kk
	 */
	
	public static Long gridTraveler(int x, int y) {
		if (x == 1 || y == 1) return (long) 1;
		
		long[][] table = new long[x+1][y+1];
		table[0][0] = (long) 1;
		
		for (int row = 0 ; row <= x-1 ; row += 1) {
			for (int col = 0 ; col <= y-1 ; col += 1) {
				table[row+1][col] += table[row][col];
				table[row][col+1] += table[row][col];
			}
		}
//		print(table);
		return table[x-1][y-1];
	}
	
	public static Long gridTravelerOther(int x, int y) {
		if (x == 1 || y == 1) return (long) 1;
		
		long[][] table = new long[x][y];
		table[0][0] = (long) 1;
		
		for (int row = 0 ; row < x-1 ; row += 1) {
			for (int col = 0 ; col < y-1 ; col += 1) {
				table[row+1][col] += table[row][col];
				table[row][col+1] += table[row][col];
			}
			table[row+1][y-1] += table[row][y-1];
		}
		for (int col = 0 ; col < y - 1 ; col += 1) {
			table[x-1][col+1] += table[x-1][col];
		}
//		print(table);
		return table[x-1][y-1];
	}
	
	public static void print(long[][] table) {
		for (long[] i : table) {
			for (long j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println(gridTraveler(1, 1));
		System.out.println(gridTraveler(2, 3));
		System.out.println(gridTraveler(3, 2));
		System.out.println(gridTraveler(3, 3));
		System.out.println(gridTraveler(18, 18));
		
		System.out.println(gridTravelerOther(1, 1));
		System.out.println(gridTravelerOther(2, 3));
		System.out.println(gridTravelerOther(3, 2));
		System.out.println(gridTravelerOther(3, 3));
		System.out.println(gridTravelerOther(18, 18));
	}
	
}
