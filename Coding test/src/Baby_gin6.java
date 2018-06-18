/*
 * baby_gin(6계단)
 * 
 * 0에서 9까지의 수가 쓰여져있는 카드로 게임을 한다.
 * 게이머는 6장의 카드를 받고 받은 카드가 baby gin을 가진다면 이 게이머가 이긴다.
 * baby gin을 가지기 위해서는 모든 6장의 카드가 런(runs)이거나 트리플리트(tripletes)이여야한다.
 * 	runs : 3장의 카드가 연속적인 번호	ex) 345, 789,... (901는 제외)
 *  tripletes : 같은 번호를 가지는 3장의 카드	ex) 000, 444...
 *  
 *  input : 0에서 9 사이의 6개의 숫자가 입력으로 주어짐
 *  output : baby gin이면 gin, 아니면 lose 출력
 *  
 *  Example:
 *  6 6 7 7 6 7	-> gin
 *  1 0 1 1 2 3 -> lose
 *  
 *  출처 : https://blog.naver.com/PostView.nhn?blogId=joonzzang90&logNo=220329719799&parentCategoryNo=&categoryNo=33&viewDate=&isShowPopularPosts=true&from=search
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
