package rpg;

public class Player {
	private static int money;
	private static Guild guild;
	private static Inventory inven;
	private static Player instance = new Player();

	private Player(){
		money = 100000;
		guild = new Guild();
		inven = new Inventory();
		guild.guildSetting();
	}
	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}
	public static Guild getGuild() {
		return guild;
	}

	public static void setGuild(Guild guild) {
		Player.guild = guild;
	}

	public static Inventory getInven() {
		return inven;
	}
	
	public static void GuildMenu() {
		guild.guildMenu();
	}
	
	public static void inventoryMenu() {
		inven.inventoryMenuPrint();
	}
}
