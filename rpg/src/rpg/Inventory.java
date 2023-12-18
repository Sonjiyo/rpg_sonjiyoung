package rpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> inven;
	
	public Inventory() {
		inven = new ArrayList<Item>();
	}
	
	public void addinventory(Item item) {
		inven.add(item);
	}
	
	public void inventoryMenuPrint() {
		while(true) {
			System.out.println("====== [인벤토리] ======");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = InputData.getValue("입력", 0, 2);
			if(sel==0) return;
			
			if(sel==1) {
				
			} else {
				itemSell();
			}
		}
	}
	
	private void inventoryPrint() {
		System.out.println("===== [인벤토리 목록] =====");
		int n = 0;
		for(Item i : inven) {
			System.out.printf("%d) ",n+1);
			System.out.println(i);
			n++;
		}
	}
	
	private void itemEquip() {
		if(inven.size()==0) {
			System.out.println("가지고 있는 아이템이 없습니다.");
			return;
		}
		Player.getGuild().partyMemberPrint();
		int sel1 = InputData.getValue("아이템을 장착할 파티원을 선택해주세요", 1, Player.getGuild().getPARTY_SIZE())-1;
		
		inventoryPrint();
		int sel2 = InputData.getValue("장착할 아이템을 선택해주세요", 1, inven.size())-1;
		
		int selKind = inven.get(sel2).getKind();
		
		if(selKind==inven.get(sel2).getWeapon()) {
			
		}else if(selKind==inven.get(sel2).getRing()) {
			
		}else {
			
		}
	}
	
	private void itemSell() {
		if(inven.size()==0) {
			System.out.println("가지고 있는 아이템이 없습니다.");
			return;
		}
		inventoryPrint();
		System.out.println("*주의* 판매는 구매 가격의 50% 가격을 받게 됩니다.");
		int idx = InputData.getValue("판매할 아이템을 선택해주세요", 1, inven.size())-1;
		int sel = InputData.getValue(inven.get(idx).getName()+"을 판매하시겠습니까? [1.예] [2.아니오]", 0, 1);
		
		if(sel==2) return;
		
		Player.setMoney(inven.get(idx).getPrice()/2*-1);
		inven.remove(idx);
	}
}
