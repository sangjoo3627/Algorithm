import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int[] arr, int low, int high){
		if(low >= high) return;
		
		int left = low;
		int right = high;
		int pivot = arr[(left+right)/2];
		
		while(left < right) {
			while(arr[left] < pivot) left++;
			while(arr[right] > pivot) right--;
			
			if(left<= right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		if(low < right) quickSort(arr,low,right);
		if(high > left) quickSort(arr, left, high);
	}
	
	public static void main(String[] args) {
		int[] arr = {4,7,1,2,3,10,23,13,19,100};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

}
