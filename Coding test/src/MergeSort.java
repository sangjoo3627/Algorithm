import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[]arr){
		if(arr.length == 1) return;
		
		int arrSize = arr.length;
		int mid = arrSize/2;
		
		int [] leftArr = new int[mid];
		int [] rightArr = new int[arrSize-mid];
		
		for(int i=0; i<leftArr.length; i++) leftArr[i] = arr[i];
		for(int i=0; i<rightArr.length; i++) rightArr[i] = arr[mid+i];
		
		mergeSort(leftArr);
		mergeSort(rightArr);
		
		sort(leftArr, rightArr, arr);
	}
	
	public static void sort(int[] leftArr, int[] rightArr, int[] arr){
		int leftCnt = 0;
		int rightCnt = 0;
		int totalCnt = 0;
		
		while(leftArr.length != leftCnt && rightArr.length != rightCnt){
			if(leftArr[leftCnt] < rightArr[rightCnt])
				arr[totalCnt++] = leftArr[leftCnt++];
			else
				arr[totalCnt++] = rightArr[rightCnt++];
		}
		
		while(leftCnt != leftArr.length)
			arr[totalCnt++] = leftArr[leftCnt++];
			
		while(rightCnt != rightArr.length)
			arr[totalCnt++] = rightArr[rightCnt++];
		
	}
	
	public static void main(String[] args) {
		int [] arr = {3,2,9,5,10,15,40,1,22,2,99};
		mergeSort(arr);
		System.out.println("arr: " + Arrays.toString(arr));
	}

}
