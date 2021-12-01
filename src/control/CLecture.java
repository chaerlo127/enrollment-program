package control;

import java.util.Vector;

import dataAccessObject.DLecture;
import valueObject.OLecture;

public class CLecture {

	private DLecture dLecture;
	private int sum;
	private float prSum;
	private int remain;
	private int lectureNum;

	public CLecture() {
		this.dLecture = new DLecture();
	}

	// 수강신청(캠퍼스, 학과, 학부 등) 강좌 전부 가져오기
	public Vector<OLecture> getAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.readAll(fileName);
		return lectures;
	}

	// 미리담기, 수강신청 강좌 전부 가져오기
	public Vector<OLecture> MSgetAll(String fileName) {
		Vector<OLecture> lectures = this.dLecture.MSreadAll(fileName);
		return lectures;
	}

	// 미리담기에 강좌 쓰기
	public boolean Write(String FileName, OLecture oLecture) {
		boolean i = this.dLecture.Write(FileName, oLecture);
		return i;
	}

	public boolean MSWriteAll(String id1, String FileName) {
		boolean exist = this.dLecture.MSWriteAll(id1, FileName);
		return exist;
	}

	// 수강신청, 미리담기 총 신청 학점 확인하기
	public int creditSum(Vector<OLecture> lectures) {
		this.sum = 0;
		for (OLecture lecture : lectures) {
			this.sum += Integer.parseInt(lecture.getCredit());
		}

		return this.sum;
	}

	// 수강 가능 학점
	public int remainCredit(int numcredit) {
		this.remain = numcredit - this.sum;
		return remain;
	}

	
	// 예측 평균 학점
	public float predictCredit(String j) {
		this.prSum += Float.parseFloat(j);
		return this.prSum;
	}

	// 파일 전부 다 지우기
	public boolean DeleteAll(String fileName) {
		boolean i = this.dLecture.DeleteAll(fileName);
		return i;
	}

	// 파일 존재하는 지 확인
	public boolean ExistFile(String fileName) {
		boolean exist = this.dLecture.ExistFile(fileName);
		if (exist) {
			return true;
		}
		return false;
	}
	
	//강좌 수 세기
	public int NumCredit(Vector<OLecture> lectures) {
		this.lectureNum = 0;
		for (OLecture lecture : lectures) {
			this.lectureNum++;
		}
		return lectureNum;
	}
	
	//회원 정보 변경 시, 회원 파일 내용 변경
	public void changeFileName(String id, String originid) {
		this.dLecture.changeFileName(id, originid);
	}

	public void prSumInitialization()//prsum 초기화
	{
		this.prSum = 0;
	}
}
