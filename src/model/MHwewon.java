package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.OHwewon;

public class MHwewon {
	// data를 읽고 쓰는 역할만 함.
	// 하나의 데이터를 읽고 쓰는 것
	// dao는 뭉텅이
	private String id;
	private String password;
	private String name;
	private String address;
	private String hwakgwa;
	private String campus;

	public MHwewon() {
		// TODO Auto-generated constructor stub
	}

	private void set(OHwewon oHwewon) {
		this.id = oHwewon.getId();
		this.password = oHwewon.getPassword();
		this.name = oHwewon.getName();
		this.address = oHwewon.getAddress();
		this.hwakgwa = oHwewon.getHwakgwa();
		this.campus = oHwewon.getCampus();
	}
	
	public void save(FileWriter filewriter, OHwewon oHwewon) {
		this.set(oHwewon);
		//  별개의 업무이므로 try에 넣어주지 않음.
		try {
			filewriter.write(id);
			filewriter.write("\n");
			filewriter.write(password);
			filewriter.write("\n");
			filewriter.write(name);
			filewriter.write("\n");
			filewriter.write(address);
			filewriter.write("\n");
			filewriter.write(hwakgwa);
			filewriter.write("\n");
			filewriter.write(campus);
			filewriter.write("\n");
			
			//hexa를 쓰던지, 아니면 line field를 써도 된다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean read(Scanner scanner) {
		if (scanner.hasNext()) {// 빈 파일일 수도 있기 때문에 읽을 것이 있는지 확인하는 것.
			this.id = scanner.next();
			this.password = scanner.next();
			this.name = scanner.next();
			this.address = scanner.next();
			this.hwakgwa = scanner.next();
			this.campus = scanner.next();
			return true;
		}
		return false;
	}
	
	
	public void WriteAll(FileWriter filewriter, Vector<OHwewon> hwewons) {
		for(OHwewon hwewon :hwewons)
		{
			try {
				filewriter.write(hwewon.getId());
				filewriter.write("\n");
				filewriter.write(hwewon.getPassword());
				filewriter.write("\n");
				filewriter.write(hwewon.getName());
				filewriter.write("\n");
				filewriter.write(hwewon.getAddress());
				filewriter.write("\n");
				filewriter.write(hwewon.getHwakgwa());
				filewriter.write("\n");
				filewriter.write(hwewon.getCampus());
				filewriter.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
