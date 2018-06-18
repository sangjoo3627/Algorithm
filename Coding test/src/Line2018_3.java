import java.io.*;
import java.util.*;

/*
 * 	¿¹Á¦
6|00:01:00
00:00:50|I|abcde01|9
00:00:55|I|cbcde02|1
00:00:59|O|cbcde02|1
00:00:59|I|c1cce03|3
00:01:05|O|abcde01|9
00:01:09|O|c1cce03|3
 */

class TASK {
	String ID;
	boolean state;	// if true, working
	int start;
	int end;
	
	TASK (String id, int time){
		this.ID = id;
		this.start = time;
		this.end = Integer.MAX_VALUE;
		this.state = true;
	}
	
	void finish (int time){
		this.end = time;
	}
	
	boolean check (int time){
		if(time >= start){
			if(end > time) return true;
			else return false;
		}
		else return false;
	}
}

class Line2018_3 {
	
	public static int getTime (String str){
		int time = 0;
		
		String hour = str.substring(0, 2);
		String min = str.substring(3, 5);
		String sec = str.substring(6, 8);
		
		time = Integer.parseInt(sec) + Integer.parseInt(min)*60 + Integer.parseInt(hour)*360;
		
		return time;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		
		String log = sc.nextLine();
		int N = Integer.parseInt(log.substring(0, 1));
		int T = getTime(log.substring(2));
		
		ArrayList<TASK> [] arr = new ArrayList [10];
		for(int i=0; i<10; i++)
			arr[i] = new ArrayList();
		
		
		for(int i=0; i<N; i++){
			String line = sc.nextLine();
			int time = getTime(line.substring(0, 8));
			String type = line.substring(9, 10);
			String id = line.substring(11, 18);
			int client = Integer.parseInt(line.substring(19));
			
			if(type.equals("I"))
				arr[client].add(new TASK(id,time));
				
			else if (type.equals("O")){
				for(int j =0; j<arr[client].size(); j++){
					TASK temp = arr[client].get(j);
					if(temp.ID.equals(id))
						temp.finish(time);
				}
			}
		}
		
		//print
		for(int i=0; i<10; i++){
			System.out.print(i + " ");
			
			int sum = 0;
			for(int j =0; j<arr[i].size(); j++){
				TASK temp = arr[i].get(j);
				if(temp.check(T)) sum++;
			}
			System.out.print(sum);
			System.out.println();
		}
		
	}
}