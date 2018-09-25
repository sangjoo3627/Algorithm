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
	 * ���ٹ��
	 * target�� �������� row�� ������ ���� ���ؼ� �� ������ ũ�� �ش� row�� Ž������ �ʰ� ���� row�� �Ѿ��
	 * �׸��� �������� row�� ã������ Ž���ϸ鼭 target�� �߰��ϸ� true�� return�ϰ�
	 * �ش� row���� ã���������� ���� row�� �Ѿ�� ���� false�� return
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
