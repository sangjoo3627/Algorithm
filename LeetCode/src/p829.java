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
	 * ���ٹ�� : 
	 * ���н����� �ذ�
	 * �� elements�� ���� nums���� �θ� nums*(nums+1)/2 ���� N���� ũ�ų� ������ �ּ� ������ element���̶�� �����ִ�.
	 * �� �� nums���� �ϳ��� ���̸鼭 j���� �������� �ƴ��� �Ǻ��ϰ� j�� �����̸� cnt�� ������Ų��
	 * j��� ���� j, j+1, j+2, ... , j+(nums-1) ������ ���ӵ� ������  ��Ÿ����.
	 * �� ���� ���ӵ� ������ ���� nums*j + nums*(nums-1)/2 ��� ���� �ְ� �� ���� N�� ������ j���� �����ϰ� ���� ���ӵ� ������ subset�� �����Ѵٴ� ���� �ǹ��Ѵ�.
	 * j�� ���� ���� �����ϸ� j = N/nums - (nums-1)/2 �̰� 
	 * �����Ҷ����� nums ���� ���̸鼭 j���� ���ϰ� j�� �����̸� ī��Ʈ ���ִ� ������� ����
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
        
        // �ִ� nums ���� ���ϱ�
        int nums = 1;
        while(true) {
        	if(nums*(nums+1) < 2*N) nums++;
        	else break;
        }
        
        for(int i=nums; i>0; i--){
        	double t1 = (double)N/(double)i;
        	double t2 = ((double)i-1.0)/2.0;
        	double j = t1 - t2;		// j�� ���ϱ�
        	if(check(j))	cnt++;	// j�� 0���� ū �����϶� �����Ѵٰ� �Ǵ��ϰ� cnt���� ����
        }
        return cnt;
    }

	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(0));
	}

}