package rpg;

public class Game {
	public Game() {
		while(true) {
			mainMenuPrint();
			int sel = InputData.getValue("입력", 0, 5);
			if(sel==0) return;
			if(sel==1) {
				
			}else if(sel==2) {
				
			}else if(sel==3) {
				
			}else if(sel==4) {
				
			}else {
				
			}
		}
	}
	
	private void mainMenuPrint() {
		System.out.println("=============== [메인메뉴] ================");
		System.out.println("[1.길드관리] [2.상점] [3.인벤토리]");
		System.out.println("[4.저장] [5.로드] [0.종료]");
	}
}
