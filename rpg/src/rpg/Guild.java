package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Guild {
	private final int PARTY_SIZE = 4;
	private ArrayList<Unit> guildList;
	private Unit[] partyList;
	private Random rd;
	public int getPARTY_SIZE() {
		return PARTY_SIZE;
	}

	public Guild() {
		guildList = new ArrayList<Unit>();
		partyList = new Unit[PARTY_SIZE];
		rd = new Random();
	}
	
	public void guildSetting() {
		guildList.add( new Unit("호랑이", 1, 100, 10, 5, 0) );
		guildList.add(new Unit("강아지", 1, 80, 7, 3, 0));
		guildList.add(new Unit("사슴", 1, 50, 3, 1, 0));
		guildList.add(new Unit("두더지", 1, 70, 5, 2, 0));
		guildList.add(new Unit("돼지", 1, 200, 4, 8, 0));
		guildList.add(new Unit("사자", 1, 120, 11, 7, 0));
		
		for(int i =0; i<partyList.length; i++) {
			guildList.get(i).setParty();
		}
		
		int idx = 0;
		for(Unit g : guildList) {
			if(g.isParty()) {
				partyList[idx] = g;
			}
		}
	}
	
	public void guildMenu() {
		while (true) {
			System.out.println("====== [길드관리] ======");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [0.뒤로가기]");
			int sel = InputData.getValue("입력", 0, 5);
			
			if(sel==0) return;
			
			if (sel==1) {
				guildMemberPrint();
			} else if (sel==2) {
				inputGuildMember();
			} else if (sel==3) {
				removeGuildMember();
			} else{
				guildMemberChange();
			}
		}
	}
	
	public void guildMemberPrint() {
		System.out.println("====== [길드원 목록] ======");
		int i =0;
		for(Unit g : guildList) {
			System.out.printf("%d) ",i+1);
			System.out.println(g);
			i++;
		}
	}
	
	public void partyMemberPrint() {
		System.out.println("====== [파티원 목록] ======");
		int i=0;
		for(Unit g : guildList) {
			if(g.isParty()) {
				System.out.printf("%d) ",i+1);
				System.out.println(g);		
				i++;
			}
		}
	}
	
	private void guildMemberChange() {
		partyMemberPrint();
		int sel1 = InputData.getValue("파티에서 제외할 길드원 선택", 1, PARTY_SIZE)-1;
		
		guildMemberPrint();
		int sel2 = InputData.getValue("파티에 넣을 길드원 선택", 1, guildList.size())-1;
		
		if(guildList.get(sel2).isParty()) {
			System.out.println("해당 길드원은 이미 파티에 소속되어 있습니다.");
			return;
		}
		
		guildList.get(sel1).setParty();
		guildList.get(sel2).setParty();
	}
	
	private void removeGuildMember() {
		guildMemberPrint();
		int sel = InputData.getValue("삭제할 길드원을 선택하세요", 1, guildList.size())-1;
		
		if(guildList.get(sel).isParty()) {
			System.out.println("파티중인 길드원은 삭제할 수 없습니다.");
			return;
		}
		
		guildList.remove(sel);
		System.out.println("[삭제 되었습니다.]");
	}
	
	private void inputGuildMember() {
		int price = 5000;
		System.out.println("파티원 추가 비용 : "+price+"원 [1.계속] [0.돌아가기]");
		int sel = InputData.getValue("입력", 0, 1);
		
		if(sel==0) return;
		
		if(Player.getMoney()<price) {
			System.out.println("돈이 부족합니다.");
			return;
		}
		
		String name = InputData.getValue("길드원의 이름을 정해주세요");
		int ran = rd.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		guildList.add(new Unit(name, 1, hp, att, def, 0));
		
		System.out.println("===== ["+name+"이 새로 길드에 합류했습니다] =====");
		System.out.println(guildList.get(guildList.size()-1));
	}
	
	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public String saveGuildData() {
		if(guildList.size()==0) return "0\n";
		String data = guildList.size()+"\n";
		for(Unit g : guildList) {
			data += g.saveStatePattern();
			data += g.savaItemPattern();
		}
		return data;
	}
}
