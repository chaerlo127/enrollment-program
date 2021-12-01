package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {
	
	private MIndex mIndex;
	public DIndex() {
	}
	
	private static final String PATHNAME = "data/";
	private static final String PATHNAME2 = "HakgwaList/";

	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			//아이디가 맞는 mMember를 찾아야 하는 것임. 
			File file = new File(PATHNAME + fileName);
			//이름에 데이터를 붙여아함. scanner가 아니라
			//스트링을 이대로 쓰면 좋지 않기 때문에 따로 써줘야함.
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.read(scanner))
				//read 함수는 true false 함수를 return해주는 것임.
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
				//n개의 원소를 저장할 수 있는 집합적 저장 바구니, 
				//한꺼번에 n개의 원소를 전달 할 수 있음. 
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return indices;
	}

	public Vector<OIndex> HakgwareadAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		
		try {
			File file = new File(PATHNAME2 + fileName);
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.read(scanner))
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indices;
	}

	public Vector<OIndex> HakgwaGet(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME2 + fileName);
			Scanner scanner = new Scanner(file);
			this.mIndex = new MIndex();
			while(mIndex.readHakgwa(scanner))
			{
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();
			return indices;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
