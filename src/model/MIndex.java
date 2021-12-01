package model;

import java.util.Scanner;

public class MIndex {
	
	private String id;
	private String name;
	private String fileName;
	// setters & getters 필요하다.

	public MIndex() {
		
	}
	
	public boolean read(Scanner scanner) {
		if(scanner.hasNext())
		{//빈 파일일 수도 있기 때문에 읽을 것이 있는지 확인하는 것.
			this.id = scanner.next();
			this.name = scanner.next();
			this.fileName = scanner.next();
			return true;
		}
		return false;
	}
	
	//회원가입 화면에서 학과를 보기 위한 것. 
	public boolean readHakgwa(Scanner scanner) {
		if(scanner.hasNext())
		{
			this.name = scanner.next();
			return true;
		}
		return false;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}





}
