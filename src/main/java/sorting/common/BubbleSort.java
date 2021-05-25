package src.main.java.sorting.common;

public class BubbleSort {

	public static int[] sort(int[] arr) {
		int len = arr.length;
		boolean didSwapping = true;
		
		while(didSwapping) {
			didSwapping = false;
			for (int i = 1 ; i < len ; i = i + 1) {
				if (arr[i] < arr[i-1]) {
					int temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
					didSwapping = true;
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {9, -3, 5, 2, 6, 8, -6, -5, 8, -6, 0, 1, 3};
		int[] sorted = sort(arr);
		
		for (int el : sorted) {
			System.out.print(el + " ");
		}
	}
	
}
