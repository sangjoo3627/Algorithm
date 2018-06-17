import java.util.*;

public class CutBar {

	public static class Bar {
		public int number;
		public int raser;
		public boolean open;
		
		Bar (int x){
			number = x;
			raser = 0;
			open = true;
		}
		
		void addRaser (){
			raser++;
		}
		
		void openBar () {
			open = true;
		}
		
		void closeBar (){
			open = false;
		}
		
		int getBars(){
			return raser+1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String input = sc.nextLine();
		sc.close();
		
		int result = 0;
		int number = 0;
		ArrayList <Bar> list = new ArrayList<Bar>();
		Stack <Integer> stack = new Stack<Integer>();
		
		for (int i=0; i<input.length(); i++){
			if(input.charAt(i) == '('){
				if(input.charAt(i+1) == ')'){
					// if it is meaning for raser
					for(int j=0; j<list.size(); j++){
						// increase number of raser in each of open Bar
						if(list.get(j).open)
							list.get(j).addRaser();
					}
					i++;
				}
				else {
					// if it is start of Bar
					number++;
					list.add(new Bar(number));
					stack.push(number);
				}
			}
			else if(input.charAt(i) == ')'){
				int n = stack.pop();
				for(int j=0; j<list.size(); j++){
					if(list.get(j).number == n)
						list.get(j).closeBar();
				}
			}
		}
		
		for(int j=0; j<list.size(); j++){
			result += list.get(j).getBars();
		}
		
		System.out.println(result);

	}

}
