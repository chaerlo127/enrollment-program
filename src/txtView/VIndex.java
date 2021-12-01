package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import valueObject.OIndex;

public class VIndex {
	private Scanner scanner;
	private CIndex cIndex;

	public VIndex(Scanner scanner) {
		this.scanner = scanner;
	}
 
	public String show(String fileName, String message) {
		System.out.println(message + " 선택하세요.");
		cIndex = new CIndex();
		Vector<OIndex> indices = cIndex.getAll(fileName);
		
		for(OIndex index: indices)
		{
			System.out.println(index.getId() + " " + index.getName());
		}
		String id = this.scanner.next(); // 용인인지, 서울인지 읽어옴.
		
		for(OIndex index: indices)
		{
			if(index.getId().equals(id))
			{
				return index.getFileName();
			}
		}
		return null;
		
	}
	

}
