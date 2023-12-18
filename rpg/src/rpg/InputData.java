package rpg;

import java.util.Scanner;

public class InputData {
	private static Scanner sc;
	private static InputData instance = new InputData();
	
	private InputData() {
		sc = new Scanner(System.in);
	}
	
	public static int getValue(String msg, int start, int end) {
		while(true) {
			try {
				System.out.print(msg+"["+start+"~"+end+"] : ");
				int sel = sc.nextInt();
				if(sel<start || sel>end) {
					System.out.println("범위 오류");
					continue;
				}
				return sel;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정수로 입력해주세요");
			}
		}
	}
}
