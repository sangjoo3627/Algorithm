package NHN2018;
import java.util.*;

/*
 * NHN 모의테스트 1
 * 
 * 	"NHN엔터의 모험"이라는 롤플레잉 게임을 출시하였습니다.
	이 게임에는 6개의 아이템이 나오며,
	이 게임의 주인공은 아이템을 3개까지 넣을 수 있는 주머니를 가지고 있습니다.
	
	퀘스트를 수행하면 이 여섯 가지의 아이템 중에 하나를 습득하게 됩니다.
	주인공은 여러 퀘스트를 수행하면서 아이템을 계속 주머니에 담습니다.
	
	이때, 주머니에 빈 자리가 있을 때는 아이템을 순서대로 주머니에 넣습니다.
	주머니가 가득 찬 상태에서 아이템을 얻게 되면,
	
	주머니에 없는 아이템이라면 가장 오래 전에 습득한 아이템을 버리고 주머니에 담습니다.
	이미 주머니에 들어 있는 아이템이라면 주머니에 새로 담고, 
	기존 아이템은 동료 캐릭터에게 선물합니다. 
	이 경우 주머니에서 아이템은 빠져 나오지만, 버려지는 아이템은 없습니다.
	
	
	주어진 입력 대로 아이템을 습득하였을 때, 버리게 된 아이템은 무엇일까요?
	아이템을 버린 순서대로 출력하세요. 
	
	아이템의 이름은 구현 편의상 1, 2, 3, 4, 5, 6으로 정합니다.
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
