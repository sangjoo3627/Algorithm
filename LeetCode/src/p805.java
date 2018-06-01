/*
 * Problem #805
 * 
 * In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)
 * Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.
 * 
 * Example:
 * Input:
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation : we can split the array into [1,4,5,8] and [2,3,6,7] and both of them have the average of 4.5
 */

import java.util.*;
import java.awt.Point;

public class p805 {
	
	/*
	 * ���ٹ��:
	 * split �ؾ��ϴ� B,C array�� ArrayList�� �����ϰ� B�� A�� ������ �״�� ����
	 * B�� C�� ��հ��� A�� ��հ��� �Ȱ��� �����ϸ鼭 B�� �ִ� element�� C�� �ű�
	 * �� A�� ��հ��� average�� �Ҷ�, target���� average*2�̰�
	 * B���� �ΰ��� ���� target�� element �ΰ��� ã�� �����ϰ� C�� �߰��Ѵ�.
	 * while���� �����鼭 ��հ��� ������ �ȵǰ� B�� ���̻� �ű���ִ� element�� ���ٸ� false,
	 * �ƴϸ� true ��ȯ
	 */
	public static boolean splitArraySameAverage(int[] A) {
		Arrays.sort(A);
		int sum = 0;
		ArrayList<Integer> B = new ArrayList();
		ArrayList<Integer> C = new ArrayList();
		
		// B�� A�� ���� ����, sum of elements ���
		for(int i=0; i<A.length; i++) {
			sum += A[i];
			B.add(A[i]);
		}
		
		double average = (double)sum/(double)A.length;
		double target = average*2;	// target�� ����
		boolean flag = false;
		
		do{
			flag = false;
			
			// B�� average ���� ���� element�� �����ϸ� �ѱ�
			Iterator <Integer> itr = B.iterator();
			while(itr.hasNext()){
				double temp = itr.next();
				if(temp == average){
					itr.remove();
					flag = true;
					break;
				}
			}
			
			// �� ���� ���� target ���� element�� ã���� B���� �����ϰ� C�� �߰�
			
			
		}while(flag && average != getAVG(B) && average != getAVG(C));
		
		return true;
	}
	
	/*
	 * array���� ��հ� ��ȯ
	 */
	public static double getAVG(ArrayList<Integer> T){
		double sum = 0;
		for(int i=0; i<T.size(); i++) sum += T.get(i);
		double result = sum/(double)T.size();
		return result;
	}

	/*
	 * Main function
	 */
	public static void main(String[] args) {
		int [] A = {1,2,3,4,5,6,7,8};
		System.out.println(splitArraySameAverage(A));
	}

}
