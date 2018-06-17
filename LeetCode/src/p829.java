/*
 * Problem #829
 * 
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * 
 * Example :
 * input : 5
 * output : 2
 * Explanation : 5=5=2+3
 * 
 * Note : 1 <= N <= 10^9
 * 
 * 26.1%
 */

public class p829 {
	
	/*
	 * 접근방법 : 
	 * 수학식으로 해결
	 * 총 elements의 값을 nums으로 두면 nums*(nums+1)/2 값이 N보다 크거나 같을때 최소 개수의 element값이라고 볼수있다.
	 * 그 후 nums값을 하나씩 줄이면서 j값이 정수인지 아닌지 판별하고 j가 정수이면 cnt를 증가시킨다
	 * j라는 것은 j, j+1, j+2, ... , j+(nums-1) 식으로 연속된 정수를  나타낸다.
	 * 즉 위의 연속된 값들의 합은 nums*j + nums*(nums-1)/2 라고 볼수 있고 이 값이 N과 같을때 j값이 존재하고 또한 연속된 정수의 subset이 존재한다는 것을 의미한다.
	 * j에 대해 식을 정리하면 j = N/nums - (nums-1)/2 이고 
	 * 구현할때에는 nums 값을 줄이면서 j값을 구하고 j가 정수이면 카운트 해주는 방식으로 구현
	 */
	
	public static boolean check(double n){
		if(n <= 0) return false;
		int ip;
		double fp;
		
		ip = (int) n;
		fp = n-(int)n;
		
		if(fp == 0.0) return true;
		else return false;
	}
	
	public static int consecutiveNumbersSum(int N) {
        int cnt = 0;
        
        // 최대 nums 값을 구하기
        int nums = 1;
        while(true) {
        	if(nums*(nums+1) < 2*N) nums++;
        	else break;
        }
        
        for(int i=nums; i>0; i--){
        	double t1 = (double)N/(double)i;
        	double t2 = ((double)i-1.0)/2.0;
        	double j = t1 - t2;		// j값 구하기
        	if(check(j))	cnt++;	// j가 0보다 큰 정수일때 존재한다고 판단하고 cnt값을 증가
        }
        return cnt;
    }

	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(0));
	}

}