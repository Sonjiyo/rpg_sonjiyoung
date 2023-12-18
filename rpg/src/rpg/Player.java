package rpg;

public class Player {
	private static int money;
	private static Guild guild;
	private static Inventory inven;
	
	public Player(){
		money = 100000;
		guild = new Guild();
		inven = new Inventory();
	}
}
