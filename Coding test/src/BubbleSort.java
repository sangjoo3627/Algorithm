import java.util.Arrays;

public class BubbleSort {

	public static void Bubblesort(int [] arr){
		boolean sort = false;
		
		while(!sort){
			sort = true;
			for(int i=0; i<arr.length-1; i++){
				if(arr[i] > arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					sort = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {3,2,9,5,10,15,40,1,22,2,99};
		Bubblesort(arr);
		System.out.println("arr: " + Arrays.toString(arr));

	}

}
