package rpg;

public class FileData {
	private String path = "gameData.txt";
	private static String filePath = System.getProperty("user.dir") + "\\src\\";
	private static FileData instance = new FileData();
	
	private FileData(){
		filePath += this.getClass().getPackageName()+"\\";
	}
}
