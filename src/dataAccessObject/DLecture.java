package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OLecture;

public class DLecture {

	private static final String PATHNAME = "data/";
	private static final String PATHNAME2 = "user/";
	private MLecture mLecture;

	public DLecture() {
	}

	public Vector<OLecture> readAll(String fileName) {
		// 수강신청 할 강좌 가져오기
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			// 아이디가 맞는 mMember를 찾아야 하는 것임.
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);
			this.mLecture = new MLecture();
			while (this.mLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(this.mLecture);
				lectures.add(oLecture);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lectures;
	}

	public Vector<OLecture> MSreadAll(String fileName) {
		// 미리담기, 수강 신청 된 강좌 가져오기
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			// 아이디가 맞는 mMember를 찾아야 하는 것임.
			File file = new File(PATHNAME2 + fileName);
			boolean exist = file.exists();
			this.mLecture = new MLecture();
			if (exist) {
				Scanner scanner = new Scanner(file);
				while (this.mLecture.read(scanner))
				// read 함수는 true false 함수를 return해주는 것임.
				{
					OLecture oLecture = new OLecture();
					oLecture.set(this.mLecture);
					lectures.add(oLecture);
				}
				scanner.close();
				return lectures;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	public Vector<OLecture> Delete(String id1, String FileName) {
		// 미리담기, 수강신청 강좌 삭제하기 위한 함수
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME2 + FileName);
			boolean exist = file.exists();
			if (exist) {
				file.canWrite();
				Scanner scanner = new Scanner(file);
				this.mLecture = new MLecture();
				while (this.mLecture.read(scanner)) {
					if (this.mLecture.getId().equals(id1)) {
						continue;
					} else {
						OLecture oLecture = new OLecture();
						oLecture.set(this.mLecture);
						lectures.add(oLecture);
					}
				}
				scanner.close();
				file.delete();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lectures;
	}

	public boolean MSWriteAll(String id1, String fileName) {
		// 전부 다 읽어오기
		Vector<OLecture> lectures = this.Delete(id1, fileName);
		try {
			File file = new File(PATHNAME2 + fileName);
			boolean exist = file.exists();
			if (!exist) {
				FileWriter Filewriter = new FileWriter(file, true);
				mLecture.MWriteAll(Filewriter, lectures);
				Filewriter.close();
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean Write(String FileName, OLecture oLecture) {
		// 미리담기 강좌 쓰기
		try {
			File file = new File(PATHNAME2 + FileName);
			boolean i = file.exists();
			if (i) {
				Scanner scanner = new Scanner(file);
				this.mLecture = new MLecture();
				while (this.mLecture.read(scanner)) {
					if (mLecture.getId().equals(oLecture.getId())) {// 강좌 중복확인
						i = false;
					}
				}
				scanner.close();
				if(i == false)
				{
					return i;
				}
				else {
					FileWriter Filewriter = new FileWriter(file, true);
					this.mLecture.Write(Filewriter, oLecture);
					Filewriter.close();
				}
				
			} else {
				FileWriter Filewriter = new FileWriter(file, true);
				this.mLecture = new MLecture();
				this.mLecture.Write(Filewriter, oLecture);
				Filewriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean DeleteAll(String fileName) {
		// 파일 전부 다 지우기
		File file = new File(PATHNAME2 + fileName);
		boolean exist = file.exists();
		if (exist) {
			file.delete();
			return true;
		} else
			return false;
	}

	//파일 존재여부 확인
	public boolean ExistFile(String fileName) {
		File file = new File(PATHNAME2 + fileName);
		boolean exist = file.exists();
		if (exist) {
			return true;
		}
		return false;
	}

	//회원정보 변경 시, 미리담기, 수강신청 파일 이름 변경
	public void changeFileName(String id, String originid) {
		File file = new File(PATHNAME2+originid);//원래 파일
		File fileNew = new File(PATHNAME2+id);//새로운 파일
		boolean exist = file.exists();
		if (exist)
			file.renameTo(fileNew);
	}

}
