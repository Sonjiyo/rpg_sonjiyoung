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
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
			int sel = InputData.getValue("입력", 0, 5);
			
			if(sel==0) return;
			
			if (sel==1) {

			} else if (sel==2) {

			} else if (sel==3) {

			} else{

			}
		}
	}
	
	public void guildMemberPrint() {
		System.out.println("====== [길드원 목록] ======");
		for(Unit g : guildList) {
			System.out.println(g);
		}
	}
	
	private void guildMemberChange() {
		
	}
}
