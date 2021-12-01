package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	private MHwewon mHwewon;
	private static final String HWEWON = "hwewon/Hwewon";

	public DHwewonDeungrok() {
	}

	
	//회원정보 저장
	public boolean save(OHwewon oHwewon) {

		try {
			File file = new File(HWEWON);
			if(file.exists()) {
				boolean i = this.savecorrect(oHwewon, file);
				if (i) {
					FileWriter Filewriter = new FileWriter(file, true);
					this.mHwewon = new MHwewon();
					this.mHwewon.save(Filewriter, oHwewon);
					Filewriter.close();
					return true;
				}
			}
			else {
				FileWriter Filewriter = new FileWriter(file, true);
				this.mHwewon = new MHwewon();
				this.mHwewon.save(Filewriter, oHwewon);
				Filewriter.close();
				return true;
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	// id 중복 확인
	public boolean savecorrect(OHwewon oHwewon, File file) {
		try {
			if(file.exists())
			{
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner)) {
					if (this.mHwewon.getId().equals(oHwewon.getId())) {
						return false;
					}
				}
				scanner.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public OHwewon read(String id) {
		// mHwewon을 통해 Data read
		// oHwewon 생성
		// mHwewon에서 oHwewon으로 데이터 이동
		try {
			File file = new File(HWEWON);
			OHwewon oHwewon = new OHwewon();
			boolean i = file.exists();
			if (i) {
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner))
				// read 함수는 true false 함수를 return해주는 것임.
				{
					if (this.mHwewon.getId().equals(id)) {
						oHwewon.set(mHwewon);
					}
				}
				scanner.close();
				return oHwewon;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 회원 내용 다 읽어오기
	public Vector<OHwewon> getAll() {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		try {
			// 아이디가 맞는 mMember를 찾아야 하는 것임.
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner))
			// read 함수는 true false 함수를 return해주는 것임.
			{
				OHwewon oHwewon = new OHwewon();
				oHwewon.set(this.mHwewon);
				hwewons.add(oHwewon);
				// n개의 원소를 저장할 수 있는 집합적 저장 바구니,
				// 한꺼번에 n개의 원소를 전달 할 수 있음.
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return hwewons;
	}

	public String idsearch(OHwewon oHwewon) {

		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner)) {

				if (this.mHwewon.getName().equals(oHwewon.getName())) {
					if (this.mHwewon.getHwakgwa().equals(oHwewon.getHwakgwa())) {
						if (this.mHwewon.getCampus().equals(oHwewon.getCampus())) {
							return this.mHwewon.getId();
						}
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String passwordsearch(OHwewon oHwewon) {
		// TODO Auto-generated method stub
		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			while (this.mHwewon.read(scanner)) {
				if (this.mHwewon.getId().equals(oHwewon.getId())) {
					if (this.mHwewon.getName().equals(oHwewon.getName())) {
						if (this.mHwewon.getHwakgwa().equals(oHwewon.getHwakgwa())) {
							if (this.mHwewon.getCampus().equals(oHwewon.getCampus())) {
								return this.mHwewon.getPassword();
							}
						}
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//회원 탈퇴에서, 회원 탈퇴할 정보만 지우고 vector에 저장
	public Vector<OHwewon> Delete(OHwewon oHwewon) {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		//oHwewon에 나머지 그릇을 담기 위해, 가져온 oHwewon의 값을 미리 담아 두어야 함.
		String id = oHwewon.getId();
		String password = oHwewon.getPassword();
		String name = oHwewon.getName();
		String address = oHwewon.getAddress();
		String hwakgwa = oHwewon.getHwakgwa();
		String campus = oHwewon.getCampus();
		
		try {
			File file = new File(HWEWON);
			Scanner scanner = new Scanner(file);
			this.mHwewon = new MHwewon();
			
			while (this.mHwewon.read(scanner)) {
				if (mHwewon.getId().equals(id)) {
					if (mHwewon.getPassword().equals(password)) {
						if (mHwewon.getName().equals(name)) {
							if (mHwewon.getAddress().equals(address)) {
								if (mHwewon.getHwakgwa().equals(hwakgwa)) {
									if (mHwewon.getCampus().equals(campus)) {
										continue;
									}
								}
							}
						}
					}
				}
				else {
					oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					hwewons.add(oHwewon);
				}
			}
			scanner.close();
			file.delete();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return hwewons;
	}

	public boolean DeleteHwewon(OHwewon oHwewon) {
		Vector<OHwewon> hwewons = this.Delete(oHwewon);
	
		try {
			File file = new File(HWEWON);
			boolean exist = file.exists();
			if(!exist)
			{
				FileWriter filewriter = new FileWriter(file, true);
				this.mHwewon.WriteAll(filewriter, hwewons);
				filewriter.close();
				return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Vector<OHwewon> showHwewonList() {
		Vector<OHwewon> hwewons = new Vector<OHwewon>();
		try {
			File file = new File(HWEWON);
			if(file.exists())
			{
				Scanner scanner = new Scanner(file);
				this.mHwewon = new MHwewon();
				while (this.mHwewon.read(scanner))
				{
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(this.mHwewon);
					hwewons.add(oHwewon);
				}
				scanner.close();
			}
			}
		 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return hwewons;
	}

}
