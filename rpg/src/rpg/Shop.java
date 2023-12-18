package rpg;

import java.util.ArrayList;

public class Shop {
	private ArrayList<Item> shopItem;
	
	public Shop() {
		shopItem = new ArrayList<Item>();
	}
	
	private void shopItemSetting() {
		shopItem.add(new Item(Item.getWeapon(),"나무검",3,1000));
		shopItem.add(new Item(Item.getWeapon(),"돌 검",5,2000));
		shopItem.add(new Item(Item.getWeapon(),"철 검",7,2500));
		shopItem.add(new Item(Item.getArmor(),"가죽 갑옷",1,300));
		shopItem.add(new Item(Item.getArmor(),"사슬 갑옷",4,800));
		shopItem.add(new Item(Item.getArmor(),"철 갑옷",7,1500));
		shopItem.add(new Item(Item.getRing(),"초급 반지",7,3000));
		shopItem.add(new Item(Item.getRing(),"중급 반지",17,6000));
		shopItem.add(new Item(Item.getRing(),"상급 반지",35,20000));
	}
	
	public void shopMenuPrint() {
		while(true) {
			System.out.println("====== [상점] ======");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");			
			int sel = InputData.getValue("입력", 0, 3);
			if(sel==0) return;
			
			if(sel==1) {
				System.out.println("====== [무기] ======");
			} else if(sel==2) {
				System.out.println("====== [갑옷] ======");
			} else {
				System.out.println("====== [반지] ======");
			}
			
			int cnt = 0;
			for(int i =0, j=0; i<shopItem.size(); i++) {
				if(shopItem.get(i).getKind()==sel) {
					System.out.printf("%d) ",cnt+1);
					System.out.println(shopItem.get(i));
					cnt++;
				}
			}
			
			sel = InputData.getValue("구매할 아이템 선택", 0, cnt);
			
			cnt = 0;
			for(int i =0, j=0; i<shopItem.size(); i++) {
				if(shopItem.get(i).getKind()==sel) {
					if(cnt==sel && Player.getMoney()>=shopItem.get(i).getPrice()) {
						Player.getInven().addinventory(shopItem.get(i));
						System.out.println("[구매 완료]");
						return;
					}else if(cnt==sel) {
						System.out.println("돈이 부족합니다.");
						return;
					}
					cnt++;
				}
			}
		}
	}
}
