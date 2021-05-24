package src.main.java.searching;

public class SearchingAlgorithm {

	public static int linearSearch(int[] arr, int target) {
		int len = arr.length;
		for (int i = 0 ; i < len ; i = i + 1) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static int jumpSearch(int[] arr, int target) {
		int len = arr.length;
		if (target > arr[len-1]) {
			return -1;
		}
		
		int jumpLen = (int) Math.sqrt(len);
		
		int step = 1;
		int bound = Math.min(step*jumpLen, len-1);
		
		while (true) {
			if (target <= arr[bound]) {
				break;
			}
			else {
				step = step + 1;
				bound = Math.min(step*jumpLen, len-1);
			}
		}
		
		for (int i = (step-1)*jumpLen ; i <= bound ; i = i + 1) {
			if (arr[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	public static int exponentialSearch(int[] arr, int target) {
		int len = arr.length;
		if (target > arr[len-1]) {
			return -1;
		}
		
		int jumpRatio = 2;
		
		if (arr[0] == target) {
			return 0;
		}
		
		int low = 1;
		int high = low * jumpRatio;
		while (true) {
			if (target <= arr[high]) {
				break;
			}
			else {
				low = high;
				high = high * jumpRatio;
			}
		}
		
		for (int i = low ; i <= high ; i = i + 1) {
			if (arr[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	public static int binarySearch(int[] arr, int target) {
		int len = arr.length;
		
		int low = 0;
		int high = len-1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			int midVal = arr[mid];
			
			if (midVal == target) {
				return mid;
			}
			else if (midVal > target) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	
	public static int interpolationSearch(int[] arr, int target) {
		int len = arr.length;
		
		int low = 0;
		int high = len - 1;
		
		while (low <= high) {
			double ratio = (target - arr[low]) / (arr[high] - arr[low]);
			int ratioSize = high - low;
			int pos = low + (int) (ratio * ratioSize);
			
			int posVal = arr[pos];
			if (posVal == target) {
				return pos;
			}
			else if (posVal > target) {
				high = pos - 1;
			}
			else {
				low = pos + 1;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17};
		
		System.out.println("linearSearch()");
		System.out.println(linearSearch(arr, 3));
		System.out.println(linearSearch(arr, 4));
		System.out.println(linearSearch(arr, 11));
		System.out.println(linearSearch(arr, 12));
		System.out.println(linearSearch(arr, 17));
		System.out.println(linearSearch(arr, 18));

		System.out.println("jumpSearch()");
		System.out.println(jumpSearch(arr, 3));
		System.out.println(jumpSearch(arr, 4));
		System.out.println(jumpSearch(arr, 11));
		System.out.println(jumpSearch(arr, 12));
		System.out.println(jumpSearch(arr, 17));
		System.out.println(jumpSearch(arr, 18));

		System.out.println("exponentialSearch()");
		System.out.println(exponentialSearch(arr, 3));
		System.out.println(exponentialSearch(arr, 4));
		System.out.println(exponentialSearch(arr, 11));
		System.out.println(exponentialSearch(arr, 12));
		System.out.println(exponentialSearch(arr, 17));
		System.out.println(exponentialSearch(arr, 18));
		
		System.out.println("binarySearch()");
		System.out.println(binarySearch(arr, 3));
		System.out.println(binarySearch(arr, 4));
		System.out.println(binarySearch(arr, 11));
		System.out.println(binarySearch(arr, 12));
		System.out.println(binarySearch(arr, 17));
		System.out.println(binarySearch(arr, 18));

		System.out.println("interpolationSearch()");
		System.out.println(interpolationSearch(arr, 3));
		System.out.println(interpolationSearch(arr, 4));
		System.out.println(interpolationSearch(arr, 11));
		System.out.println(interpolationSearch(arr, 12));
		System.out.println(interpolationSearch(arr, 17));
		System.out.println(interpolationSearch(arr, 18));
	}
	
}
