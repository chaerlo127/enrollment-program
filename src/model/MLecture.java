package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.OLecture;

public class MLecture {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	// setters & getters 필요하다.

	public MLecture() {	}
	
	public boolean read(Scanner scanner) {
		if(scanner.hasNext())
		{//빈 파일일 수도 있기 때문에 읽을 것이 있는지 확인하는 것.
			this.id = scanner.next();
			this.name = scanner.next();
			this.professor = scanner.next();
			this.credit = scanner.next();
			this.time = scanner.next();
			return true;
		}
		return false;
	}
	
	
	public void set(OLecture oLecture)
	{
		this.id = oLecture.getId();
		this.name = oLecture.getName();
		this.professor = oLecture.getProfessor();
		this.credit = oLecture.getCredit();
		this.time = oLecture.getTime();
	}
	
	
	

	public void Write(FileWriter filewriter, OLecture oLecture) {
		this.set(oLecture);
		try {
			filewriter.write(this.id);
			filewriter.write(" ");
			filewriter.write(this.name);
			filewriter.write(" ");
			filewriter.write(this.professor);
			filewriter.write(" ");
			filewriter.write(this.credit);
			filewriter.write(" ");
			filewriter.write(this.time);
			filewriter.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MWriteAll(FileWriter filewriter, Vector<OLecture> lectures1) {
		for(OLecture lecture :lectures1)
		{
		try {
			filewriter.write(lecture.getId());
			filewriter.write(" ");
			filewriter.write(lecture.getName());
			filewriter.write(" ");
			filewriter.write(lecture.getProfessor());
			filewriter.write(" ");
			filewriter.write(lecture.getCredit());
			filewriter.write(" ");
			filewriter.write(lecture.getTime());
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
