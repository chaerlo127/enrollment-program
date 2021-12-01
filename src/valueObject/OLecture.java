package valueObject;

import model.MLecture;

public class OLecture {

	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	private String FileName;
	
	// setters & getters 필요하다.
//	public OIndex() {
//		
//	}



	public void set(MLecture mlecture) {
		this.id = mlecture.getId();
		this.name = mlecture.getName();
		this.professor = mlecture.getProfessor();
		this.credit = mlecture.getCredit();
		this.time = mlecture.getTime();
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
	
	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}
}
