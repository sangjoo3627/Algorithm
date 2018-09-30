package SCAL_MOOKJA2018;
import java.util.*;

/*
 * Problem #16165 걸그룹 마스터 준석이
 * 
 * 정우는 소문난 걸그룹 덕후이다. 정우의 친구 준석이도 걸그룹을 좋아하지만 이름을 잘 외우지 못한다는 문제가 있었다. 정우는 친구를 위해 걸그룹 개인과 팀의 이름을 검색하여 외우게 하는 퀴즈 프로그램을 만들고자 한다.
 * 
 * 입력
 * 모든 문자 입력은 전부 소문자이다. 첫 번째 줄에는 총 입력 받을 걸그룹의 수 N(0<M<100)과 맞춰야 할 문제의 수 M(0<N<100)을 입력한다. 
 * 두 번째 줄에는 걸그룹 팀의 이름을 입력 받고 해당 걸그룹의 인원 수를 입력 받고, 걸그룹 멤버의 이름을 입력 받는다. 걸그룹 팀과 멤버의 이름의 최대 길이는 100자이다. 
 * 또한 그룹은 다르지만 이름이 같은 멤버가 있을 경우는 없다. 세 번째 줄에는 문제를 위해 M개의 걸그룹 개인의 이름이나 팀의 이름과 함께 문제의 종류가 입력으로 들어온다. 
 * 문제는 총 2종류로, 입력으로 들어오는 문제의 종류는 팀의 이름이 주어졌을 경우, 0으로 입력하며 걸그룹 멤버의 이름이 주어졌을 경우, 1로 입력하여 판단한다. 
 * 팀의 이름이 주어졌을 경우, 그 팀에 속한 모든 걸그룹 멤버의 이름을 출력해야 한다. 또한 걸그룹 개인의 이름이 주어졌을 경우, 그 멤버가 속한 팀의 이름을 출력해야 한다.
 * 
 * 출력
 * 첫 번째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 각각 말하면 된다. 입력으로 들어온 문제의 종류가 0이고 팀의 이름이 주어졌을 경우, 그 팀에 속한 모든 걸그룹 멤버의 이름을 출력한다. 
 * 또한 입력 받은 순서가 아닌, 걸그룹 멤버의 이름을 영어 사전 순으로 정렬하여 출력한다. 입력으로 들어온 문제의 종류가 1이고 걸그룹 멤버의 이름이 주어졌을 경우, 그 멤버가 속한 팀의 이름을 출력한다.
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
			
			// 팀이름 
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
			// 멤버이름
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
