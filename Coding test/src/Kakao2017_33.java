
public class Kakao2017_33 {
	
	public static void solution(String [] files){
		// 안정정렬인 버블소트 이용
		boolean sort = false;
		
		while(!sort){
			sort = true;
			for(int i=0; i<files.length-1; i++){
				if(Compare(files[i], files[i+1]) > 0){
					String temp = files[i];
					files[i] = files[i+1];
					files[i+1] = temp;
					sort = false;
				}
			}
		}
	}
	
	public static int Compare(String arr1, String arr2){
		int result = 0;
		
		String [] parr1 = parsing(arr1);
		String [] parr2 = parsing(arr2);
		
		return result;
	}
	
	public static String [] parsing (String str){
		String [] parse = new String[3];
		
		int numIndex = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
				numIndex = i;
				break;
			}
		}
		
		
		
		
		return parse;
	}
	
	public static void main(String[] args) {
		String [] arr1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String [] arr2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
	
		solution(arr1);
		solution(arr2);
	}

}
