package src.main.java.sorting.common;

public class InsertionSort {

	public static int[] sort(int[] arr) {
		int len = arr.length;
		for (int first = 1; first < len ; first = first + 1) {
			int second = first - 1;
			int val = arr[first];
			while (second >= 0 && arr[second] > val) {
				arr[second + 1] = arr[second];
				second = second - 1;
			}
			arr[second + 1] = val;
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
