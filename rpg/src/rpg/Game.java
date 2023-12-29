package rpg;

public class Game {
	Shop shop = new Shop();
	
	public Game() {
		while(true) {
			mainMenuPrint();
			int sel = InputData.getValue("입력", 0, 5);
			if(sel==0) return;
			if(sel==1) {
				Player.GuildMenu();
			}else if(sel==2) {
				shop.shopMenuPrint();
			}else if(sel==3) {
				Player.inventoryMenu();
			}else if(sel==4) {
				FileData.saveData(Player.saveGameData());
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
