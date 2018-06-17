import java.util.*;

public class Work {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		
		Node [] arr = new Node[N+1];

		boolean [] check = new boolean[N+1];
		
		// Set input
		for(int i=1; i<=N; i++){
			int remain = sc.nextInt();
			arr[i] = new Node(remain);
			
			int num = sc.nextInt();
			if(num != 0) {
				for(int j=0; j<num; j++){
					int add = sc.nextInt();
					arr[i].addNode(add);
				}
			}
		}
		
		int time = 1;
		
		
		while(true){
			boolean end = false;
			
			for(int i=1; i<=N; i++){
				if(arr[i].exec == 0 && arr[i].remain > 0){
					end = true;
					arr[i].remain--;
					if(arr[i].remain == 0)
						check[i] = true;
				}
			}
			
			for(int i=1; i<=N; i++){
				for(int j=0; j<arr[i].exec; j++){
					if(check[arr[i].pre.get(j)] == true){
						end = true;
						arr[i].pre.remove(j);
					}
				}
			}
			
			if(end)
				time++;
			else
				break;
		}
		
		System.out.println(time);
	}

}

class Node {
	int exec;					// 선행작업의 개수 (0이면 실행상태)
	int remain;					// 남아있는 실행시간
	ArrayList <Integer> pre;	// 선행작업 list
	
	Node(int x){
		remain = x;
		pre = new ArrayList <Integer>();
		exec = pre.size();
	}
	
	void addNode (int x){
		pre.add(x);
	}
}
