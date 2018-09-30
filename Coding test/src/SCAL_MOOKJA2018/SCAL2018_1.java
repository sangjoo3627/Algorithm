package SCAL_MOOKJA2018;
import java.util.*;

/*
 * Problem #16165 �ɱ׷� ������ �ؼ���
 * 
 * ����� �ҹ��� �ɱ׷� �����̴�. ������ ģ�� �ؼ��̵� �ɱ׷��� ���������� �̸��� �� �ܿ��� ���Ѵٴ� ������ �־���. ����� ģ���� ���� �ɱ׷� ���ΰ� ���� �̸��� �˻��Ͽ� �ܿ�� �ϴ� ���� ���α׷��� ������� �Ѵ�.
 * 
 * �Է�
 * ��� ���� �Է��� ���� �ҹ����̴�. ù ��° �ٿ��� �� �Է� ���� �ɱ׷��� �� N(0<M<100)�� ����� �� ������ �� M(0<N<100)�� �Է��Ѵ�. 
 * �� ��° �ٿ��� �ɱ׷� ���� �̸��� �Է� �ް� �ش� �ɱ׷��� �ο� ���� �Է� �ް�, �ɱ׷� ����� �̸��� �Է� �޴´�. �ɱ׷� ���� ����� �̸��� �ִ� ���̴� 100���̴�. 
 * ���� �׷��� �ٸ����� �̸��� ���� ����� ���� ���� ����. �� ��° �ٿ��� ������ ���� M���� �ɱ׷� ������ �̸��̳� ���� �̸��� �Բ� ������ ������ �Է����� ���´�. 
 * ������ �� 2������, �Է����� ������ ������ ������ ���� �̸��� �־����� ���, 0���� �Է��ϸ� �ɱ׷� ����� �̸��� �־����� ���, 1�� �Է��Ͽ� �Ǵ��Ѵ�. 
 * ���� �̸��� �־����� ���, �� ���� ���� ��� �ɱ׷� ����� �̸��� ����ؾ� �Ѵ�. ���� �ɱ׷� ������ �̸��� �־����� ���, �� ����� ���� ���� �̸��� ����ؾ� �Ѵ�.
 * 
 * ���
 * ù ��° �ٺ��� ���ʴ�� M���� �ٿ� ������ ������ ���� ���� ���� ���ϸ� �ȴ�. �Է����� ���� ������ ������ 0�̰� ���� �̸��� �־����� ���, �� ���� ���� ��� �ɱ׷� ����� �̸��� ����Ѵ�. 
 * ���� �Է� ���� ������ �ƴ�, �ɱ׷� ����� �̸��� ���� ���� ������ �����Ͽ� ����Ѵ�. �Է����� ���� ������ ������ 1�̰� �ɱ׷� ����� �̸��� �־����� ���, �� ����� ���� ���� �̸��� ����Ѵ�.
 */

public class SCAL2018_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List <List<String>> teams = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			String teamName = sc.next();
			int teamNum = sc.nextInt();
			
			List<String> team = new LinkedList<>();
			
			for(int j=0; j<teamNum; j++)
				team.add(sc.next());
			
			Collections.sort(team);
			team.add(0, teamName);
			teams.add(team);
		}
		
		for(int i=0; i<M; i++) {
			String name = sc.next();
			int type = sc.nextInt();
			
			// ���̸� 
			if(type == 0) {
				for(List<String> team : teams) {
					if(team.get(0).equals(name)) {
						for(String member : team) {
							if(!member.equals(team.get(0)))
								System.out.println(member);
						}
					}
				}
			}
			// ����̸�
			else {
				for(List<String> team : teams) {
					for(String member : team) {
						if(member.equals(name))
							System.out.println(team.get(0));
					}
				}
			}
		}
	}

}
