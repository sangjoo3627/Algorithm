public class BinarySearchTree {
	
	public static boolean search(int i, int [] array){
		boolean result = false;
		int left = 0;
		int right = array.length-1;
		int mid = 0;
		
		while(left<=right){
			mid = (left+right)/2;
			
			if(array[mid] == i){
				result = true;
				break;
			}
			else if (array[mid] > i){
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int [] array = {1,5,7,8,12,17,23,25};
		System.out.println(search(8, array));

	}

}
