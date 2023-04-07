package Quiz_04_07;

import java.util.*;

class Q2 {
	public int solution(int[] keypad, String password){
		int answer = 0;
		String place[] = new String[password.length()];
		String buttons[] = {"134", "02345", "145", "01467", "01235678", "12478", "347", "34568", "457"};
		String passWs[] = password.split("");
		
		int passWd[] = new int[passWs.length];

		for (int i = 0; i < passWs.length; i++) {
			passWd[i] = Integer.parseInt(passWs[i]);
		}


		for (int i = 0; i < password.length(); i++) {
			for (int j = 0; j < keypad.length; j++) {
				if (passWd[i] == keypad[j]) {
					place[i] = Integer.toString(j);
				}
			}
		}
		
		System.out.print("place Value : ");
		for (String x : place) {
			System.out.print(" " + x + " ");
		}
		System.out.println();

		int cnt = 0;
		for (int i = 0; i < place.length - 1; i++) {
			if (buttons[Integer.parseInt(place[i])].contains(place[i+1]) == true) {
				cnt++;
			} else if (place[i].equals(place[i+1]) == true) {
				//cnt = cnt;
			}
			else {
				cnt +=2;
			}
		}

		answer = cnt;

		return answer;
	}

	public static void main(String[] args){
		Q2 T = new Q2();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}