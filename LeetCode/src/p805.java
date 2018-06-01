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
	 * 접근방법:
	 * split 해야하는 B,C array를 ArrayList로 선언하고 B에 A의 값들을 그대로 복사
	 * B와 C의 평균값을 A의 평균값과 똑같이 유지하면서 B에 있는 element를 C에 옮김
	 * 즉 A의 평균값이 average라 할때, target값은 average*2이고
	 * B에서 두값의 합이 target인 element 두개를 찾아 제거하고 C에 추가한다.
	 * while문을 돌리면서 평균값이 유지가 안되고 B에 더이상 옮길수있는 element가 없다면 false,
	 * 아니면 true 반환
	 */
	public static boolean splitArraySameAverage(int[] A) {
		Arrays.sort(A);
		int sum = 0;
		ArrayList<Integer> B = new ArrayList();
		ArrayList<Integer> C = new ArrayList();
		
		// B에 A의 값을 복사, sum of elements 계산
		for(int i=0; i<A.length; i++) {
			sum += A[i];
			B.add(A[i]);
		}
		
		double average = (double)sum/(double)A.length;
		double target = average*2;	// target값 설정
		boolean flag = false;
		
		do{
			flag = false;
			
			// B에 average 값과 같은 element가 존재하면 넘김
			Iterator <Integer> itr = B.iterator();
			while(itr.hasNext()){
				double temp = itr.next();
				if(temp == average){
					itr.remove();
					flag = true;
					break;
				}
			}
			
			// 두 값의 합이 target 값인 element를 찾으면 B에서 제거하고 C에 추가
			
			
		}while(flag && average != getAVG(B) && average != getAVG(C));
		
		return true;
	}
	
	/*
	 * array에서 평균값 반환
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
