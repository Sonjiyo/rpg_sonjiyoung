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
	
	public Unit(String name, int level, int hp, int maxHp, int att, int def, int exp, boolean party) {
		super();
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.party = party;
	}
	
	public void itemEquip(Item weapon, Item armor, Item ring) {
		this.weapon = weapon;
		this.armor = armor;
		this.ring = ring;
	}

	public void statusPrint() {
		System.out.print("[이름 : " + name + "]");
		System.out.print("[레벨 : " + level + "]");
		
		System.out.print("[체력 : ");
		System.out.print(hp);
		System.out.print(ring != null ? " + " + ring.getPower()+" / ": " / ");
		
		System.out.print(maxHp);
		System.out.print(ring != null ? " + " + ring.getPower()+"]" : "]");
		
		System.out.print("[공격력 : ");
		System.out.print(att);
		System.out.print(weapon!=null ? " + " + weapon.getPower()+"]" : "]");

		System.out.print("[방어력 : ");
		System.out.print(att);
		System.out.print(armor!=null ? " + " + armor.getPower()+"]" : "]");
		
		System.out.println(party ? "[파티에 들어가있습니다.]" : "[파티에 들어가있지 않습니다.]");
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
}
