package control;

import java.util.Vector;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;

public class CHwewonDeungrok {
	//계산이나 통계를 하는 곳 controller, logic이 들어가있음.
	private DHwewonDeungrok dHwewonDeungrok;
	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	//회원 정보 읽어오기
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}

	//회원정보 저장하기
	public boolean saveHwewon(OHwewon oHwewon) {
		boolean i = this.dHwewonDeungrok.save(oHwewon);
		return i;
		
	}

	public String idsearch(OHwewon oHwewon) {
		String id = this.dHwewonDeungrok.idsearch(oHwewon);
		return id;
	}

	public String passwordsearch(OHwewon oHwewon) {
		String password = this.dHwewonDeungrok.passwordsearch(oHwewon);
		return password;
	}

	public boolean DeleteHwewon(OHwewon oHwewon) {
		boolean i  = this.dHwewonDeungrok.DeleteHwewon(oHwewon);
		return i;
	}

	public Vector<OHwewon> readHwewonList() {
		Vector<OHwewon> hwewons = this.dHwewonDeungrok.showHwewonList();
		return hwewons;
	}
}
