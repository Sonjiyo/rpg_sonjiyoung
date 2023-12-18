package rpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> inven;
	
	public Inventory() {
		inven = new ArrayList<Item>();
	}
	
	public void inventoryMenuPrint() {
		while(true) {
			System.out.println("====== [인벤토리] ======");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = InputData.getValue("입력", 0, 2);
			if(sel==0) return;
			
			if(sel==1) {
				
			} else {
				
			}
		}
	}
}
