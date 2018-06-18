/*
 * baby_gin(6���)
 * 
 * 0���� 9������ ���� �������ִ� ī��� ������ �Ѵ�.
 * ���̸Ӵ� 6���� ī�带 �ް� ���� ī�尡 baby gin�� �����ٸ� �� ���̸Ӱ� �̱��.
 * baby gin�� ������ ���ؼ��� ��� 6���� ī�尡 ��(runs)�̰ų� Ʈ���ø�Ʈ(tripletes)�̿����Ѵ�.
 * 	runs : 3���� ī�尡 �������� ��ȣ	ex) 345, 789,... (901�� ����)
 *  tripletes : ���� ��ȣ�� ������ 3���� ī��	ex) 000, 444...
 *  
 *  input : 0���� 9 ������ 6���� ���ڰ� �Է����� �־���
 *  output : baby gin�̸� gin, �ƴϸ� lose ���
 *  
 *  Example:
 *  6 6 7 7 6 7	-> gin
 *  1 0 1 1 2 3 -> lose
 *  
 *  ��ó : https://blog.naver.com/PostView.nhn?blogId=joonzzang90&logNo=220329719799&parentCategoryNo=&categoryNo=33&viewDate=&isShowPopularPosts=true&from=search
 */

public class Baby_gin6 {

	public static void main(String[] args) {
		
		//int [] card = {6,6,7,7,6,7};
		//int [] card = {1,0,1,1,2,3};
		int [] card = {1,0,1,1,2,3};
		
		int [] a = new int [10];
		for(int i=0; i<6; i++){
			a[card[i]]++;
		}

		for(int i=0; i<10; i++)
			if(a[i] >= 3) a[i] -= 3;
		
		for(int i=1; i<9; i++){
			if(a[i-1] != 0 && a[i] != 0 && a[i+1] != 0) {
				a[i-1]--;
				a[i]--;
				a[i+1]--;
			}
		}
		
		int cnt=0;
		for(int i=0; i<10; i++) cnt += a[i];
		if(cnt == 0) System.out.println("gin");
		else System.out.println("lose");
	}

}
