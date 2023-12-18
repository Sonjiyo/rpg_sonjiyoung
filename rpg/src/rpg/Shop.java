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
}
