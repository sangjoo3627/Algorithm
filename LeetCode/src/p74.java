import java.util.*;

/*
 * Problem #74 Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 * 
 * 34%
 */

public class p74 {
	
	/*
	 * 접근방법
	 * target을 기준으로 row의 마지막 값과 비교해서 이 값보다 크면 해당 row를 탐색하지 않고 다음 row로 넘어간다
	 * 그리고 범위내의 row를 찾았으면 탐색하면서 target을 발견하면 true를 return하고
	 * 해당 row에서 찾지못했으면 다음 row로 넘어가기 전에 false를 return
	 */

	public static void main(String[] args) {
		int [][] arr = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,50}
		};
		
		System.out.println(searchMatrix(arr, 13));
	}

	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        
        if(row == 0) return false;
        
        for(int i=0; i<row; i++) {
        	int col = matrix[i].length;
        	if(col == 0) continue;
        	if(matrix[i][col-1] < target) continue;
        	
        	boolean find = false;
        	for(int j=0; j<col; j++) {
        		if(matrix[i][j] == target)
        			return true;
        	}
        	return false;
        }
        return false;
    }
}
