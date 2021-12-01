package valueObject;

import model.MHwewon;

public class OHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;
	private String campus;

	// setters & getters 필요하다.
	// source => setters getters
	// 노출되면 안되기 때문에 겟과 셋을 통해서 써야함. public으로 쓰면 절대로 안됨.
	public OHwewon() {

	}

	public void set(MHwewon mHwewon) {
		this.id = mHwewon.getId();
		this.password = mHwewon.getPassword();
		this.name = mHwewon.getName();
		this.address = mHwewon.getAddress();
		this.hwakgwa = mHwewon.getHwakgwa();
		this.campus = mHwewon.getCampus();
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id2) {
		this.id = id2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password2) {
		this.password = password2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHwakgwa() {
		return hwakgwa;
	}

	public void setHwakgwa(String hwakgwa) {
		this.hwakgwa = hwakgwa;
	}
	public String getCampus() {
		return campus;
	}

	public void setCampus(String capmus) {
		this.campus = capmus;
	}

}
