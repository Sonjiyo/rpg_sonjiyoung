package rpg;

public class Item {
	private static final int WEAPON = 1;
	private static final int ARMOR = 2;
	private static final int RING = 3;
	private int kind;
	private String name;
	private int power;
	private int price;
	public int getKind() {
		return kind;
	}
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	public int getPrice() {
		return price;
	}
	
	public static int getWeapon() {
		return WEAPON;
	}
	public static int getArmor() {
		return ARMOR;
	}
	public static int getRing() {
		return RING;
	}
	public Item(int kind, String name, int power, int price) {
		super();
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
	@Override
	public String toString() {
		return "[이름 : "+name+"] [능력 : "+power+"] [가격 : "+price+"]";
	}
	
	
}
