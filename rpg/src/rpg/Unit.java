package rpg;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Item getWeapon() {
		return weapon;
	}
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	public Item getArmor() {
		return armor;
	}
	public void setArmor(Item armor) {
		this.armor = armor;
	}
	public Item getRing() {
		return ring;
	}
	public void setRing(Item ring) {
		this.ring = ring;
	}
	public Unit(String name, int level, int maxHp, int att, int def, int exp) {
		super();
		this.name = name;
		this.level = level;
		hp = maxHp;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
	}
	public boolean isParty() {
		return party;
	}
	public void setParty() {
		party = !party;
	}

	public void itemEquip(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}
	
	@Override
	public String toString() {
		return statusPrint();
	}
	
	private String statusPrint() {
		String data = "";
		data += "[이름 : " + name + "]";
		data += "[레벨 : " + level + "]\n";
		
		data += "[체력 : ";
		data += hp;
		data += ring != null ? " + " + ring.getPower()+" / ": " / ";
		
		data += maxHp;
		data += ring != null ? " + " + ring.getPower()+"]" : "]";
		
		data += "[공격력 : ";
		data += att;
		data += weapon!=null ? " + " + weapon.getPower()+"]" : "]";

		data += "[방어력 : ";
		data += def;
		data += armor!=null ? " + " + armor.getPower()+"]\n" : "]\n";
		
		data += party ? "[파티에 들어가있습니다.]\n" : "[파티에 들어가있지 않습니다.]\n";
		
		return data;
	}
	
	public void itemPrint() {
		System.out.print("[무기 : ");
		System.out.print(weapon!=null ? weapon.getName() : "없음");
		System.out.println("]");
		
		System.out.print("[방어구 : ");
		System.out.print(armor!=null ? armor.getName() : "없음");
		System.out.println("]");
		
		System.out.print("[반지 : ");
		System.out.print(ring!=null ? ring.getName() : "없음");
		System.out.println("]");
	}
	
	public String saveStatePattern() {
		return name+"/"+level+"/"+maxHp+"/"+att+"/"+def+"/"+exp+"/"+party+"\n";
	}
	
	public String savaItemPattern() {
		String data = "";
		
		data += weapon==null ? weapon+"/" : weapon.saveItemPattern()+"/";
		data += ring==null ? ring+"/" : ring.saveItemPattern()+"/";
		data += armor==null ? armor+"\n" : armor.saveItemPattern()+"\n";
		
		return data;
	}
}
