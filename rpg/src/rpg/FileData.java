package rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileData {
	private static String curPath = "src\\";
	private static FileData instance = new FileData();
	private static Charset charset = StandardCharsets.UTF_8; 
	
	private FileData(){
		Path path = Paths.get(curPath,"gameData.txt");
		try {
			Files.createFile(path);
		} catch (IOException e) {
			//System.out.println("파일이 이미 있음");
		}
	}
	
	static void saveData(String data) {
		Path path = Paths.get(curPath,"gameData.txt");

		try (FileOutputStream fos = new FileOutputStream(path.toString());
			OutputStreamWriter ow = new OutputStreamWriter(fos, charset);
			BufferedWriter bw = new BufferedWriter(ow);){
			
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[저장 성공]");
	}
	
	private static String loadFile() {
		Path path = Paths.get(curPath,"gameData.txt");
		
		StringBuilder data = new StringBuilder();
		
		try(FileInputStream fis = new FileInputStream(path.toString());
			InputStreamReader ir = new InputStreamReader(fis, charset);
			BufferedReader br = new BufferedReader(ir);){
			String line = "";
			while((line=br.readLine())!=null) {
				data.append(line);
				data.append("\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data.toString().substring(0,data.length()-1);
	}
	
	static void loadData() {
		String data = loadFile();
		
		String[] temp = data.split("\n");
		Player.setMoney(Integer.parseInt(temp[0]));
		int cnt = Integer.parseInt(temp[1]);
		for(int i =0; i<cnt; i++) {
			
		}
		
	}
}
