package control;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;
import valueObject.OLogin;

public class CLogin {
//계산이나 통계를 하는 곳 controller, logic이 들어가있음.
	private DHwewonDeungrok dHwewonDeungrok;

	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}

	public OHwewon validate(OLogin oLogin) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		// 해당 아이디 = key
		if (oHwewon != null) {
			if (oLogin.getPassword().equals(oHwewon.getPassword())) {
				return oHwewon;
			}
		}
		return null;
	}

}
