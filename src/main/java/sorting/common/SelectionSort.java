package src.main.java.sorting.common;

public class SelectionSort {

	public static int[] sort(int[] arr) {
		int len = arr.length;
		for (int i = 0 ; i < len ; i++) {
			int minIndex = i;
			
			for (int j = i + 1 ; j < len ; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
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
