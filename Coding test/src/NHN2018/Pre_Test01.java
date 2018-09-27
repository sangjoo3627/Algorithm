package NHN2018;
import java.util.*;

/*
 * NHN �����׽�Ʈ 1
 * 
 * 	"NHN������ ����"�̶�� ���÷��� ������ ����Ͽ����ϴ�.
	�� ���ӿ��� 6���� �������� ������,
	�� ������ ���ΰ��� �������� 3������ ���� �� �ִ� �ָӴϸ� ������ �ֽ��ϴ�.
	
	����Ʈ�� �����ϸ� �� ���� ������ ������ �߿� �ϳ��� �����ϰ� �˴ϴ�.
	���ΰ��� ���� ����Ʈ�� �����ϸ鼭 �������� ��� �ָӴϿ� ����ϴ�.
	
	�̶�, �ָӴϿ� �� �ڸ��� ���� ���� �������� ������� �ָӴϿ� �ֽ��ϴ�.
	�ָӴϰ� ���� �� ���¿��� �������� ��� �Ǹ�,
	
	�ָӴϿ� ���� �������̶�� ���� ���� ���� ������ �������� ������ �ָӴϿ� ����ϴ�.
	�̹� �ָӴϿ� ��� �ִ� �������̶�� �ָӴϿ� ���� ���, 
	���� �������� ���� ĳ���Ϳ��� �����մϴ�. 
	�� ��� �ָӴϿ��� �������� ���� ��������, �������� �������� �����ϴ�.
	
	
	�־��� �Է� ��� �������� �����Ͽ��� ��, ������ �� �������� �����ϱ��?
	�������� ���� ������� ����ϼ���. 
	
	�������� �̸��� ���� ���ǻ� 1, 2, 3, 4, 5, 6���� ���մϴ�.
 */

public class Pre_Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String [] arr = str.split(" ");
		int [] input = Arrays.asList(arr).stream().mapToInt(Integer::parseInt).toArray();
		
		List<Integer> bag = new LinkedList<>();
		List<Integer> trash = new LinkedList<>();
		
		for(int i : input) {
			if(bag.size() < 3) 
				bag.add(i);
			else {
				if(bag.contains(i)) {
					int idx = bag.indexOf(i);
					bag.remove(idx);
					bag.add(i);
				}
				else {
					int t = bag.get(0);
					bag.remove(0);
					trash.add(t);
					bag.add(i);
				}
			}
		}
		if(trash.isEmpty()) System.out.println(0);
		else {
			for(int t=0; t<trash.size(); t++) {
				System.out.println(trash.get(t));
				
			}
		}
	}

}
