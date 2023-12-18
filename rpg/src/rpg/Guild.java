package rpg;

import java.util.ArrayList;

import _rpg.MainGame;

public class Guild {
	private final int PARTY_SIZE = 4;
	private ArrayList<Unit> guildList;
	private Unit[] partyList;
	
	public Guild() {
		guildList = new ArrayList<Unit>();
		partyList = new Unit[PARTY_SIZE];
	}
	
	public void guildSetting() {
		guildList.add( new Unit("호랑이", 1, 100, 10, 5, 0) );
		guildList.add(new Unit("강아지", 1, 80, 7, 3, 0));
		guildList.add(new Unit("사슴", 1, 50, 3, 1, 0));
		guildList.add(new Unit("두더지", 1, 70, 5, 2, 0));
		guildList.add(new Unit("돼지", 1, 200, 4, 8, 0));
		guildList.add(new Unit("사자", 1, 120, 11, 7, 0));
		
		for(int i =0; i<partyList.length; i++) {
			guildList.get(i).setParty(true);
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

			} else if (sel==3) {
				removeGuildMember();
			} else{
				guildMemberChange();
			}
		}
	}
	
	private void guildMemberPrint() {
		System.out.println("====== [길드원 목록] ======");
		for(Unit g : guildList) {
			System.out.println(g);
		}
	}
	
	public void partyMemberPrint() {
		System.out.println("====== [파티원 목록] ======");
		for(Unit g : guildList) {
			if(g.isParty()) {
				System.out.println(g);				
			}
		}
	}
	
	private void guildMemberChange() {
		partyMemberPrint();
		int sel1 = InputData.getValue("파티에서 제외할 길드원 선택", 0, PARTY_SIZE-1);
		
		guildMemberPrint();
		int sel2 = InputData.getValue("파티에 넣을 길드원 선택", 0, guildList.size());
		
		if(guildList.get(sel2).isParty()) {
			System.out.println("해당 길드원은 이미 파티에 소속되어 있습니다.");
			return;
		}
		
		guildList.get(sel1).setParty(false);
		guildList.get(sel2).setParty(true);
	}
	
	private void removeGuildMember() {
		guildMemberPrint();
		int sel = InputData.getValue("삭제할 길드원을 선택하세요", 0, guildList.size());
		
		guildList.remove(sel);
		System.out.println("[삭제 되었습니다.]");
	}
}
