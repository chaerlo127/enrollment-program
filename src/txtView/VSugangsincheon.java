package txtView;

import java.util.Scanner;

import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugangsincheon {
	private Scanner scanner;

	private VIndex vcampus;
	private VIndex vCollege;
	private VIndex vdepartment;
	private VLecture vLecture;
	private VMiridamgi vMiridamgi;
	private VSincheong vSincheong;
	private VHwewonChangeDelete vhwewonDelete;
	private VHwewonChangeDelete vHwewonChange;
	private static final String FIRSTFILENAME = "root";

	public VSugangsincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vcampus = new VIndex(this.scanner);
		this.vCollege = new VIndex(this.scanner);
		this.vdepartment = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.vMiridamgi = new VMiridamgi(this.scanner);
		this.vSincheong = new VSincheong(this.scanner);
		this.vhwewonDelete = new VHwewonChangeDelete(this.scanner);
		this.vHwewonChange = new VHwewonChangeDelete(this.scanner);

	}

	public OLecture sugang() {// data file 읽기
		String campusFileName = this.vcampus.show(FIRSTFILENAME, "캠퍼스를");
		OLecture oLecture = new OLecture();
		if (campusFileName != null) {
			
			String collegeFileName = this.vCollege.show(campusFileName, "대학을");
			if (collegeFileName != null) {
				String departmentFileName = this.vdepartment.show(collegeFileName, "학과를");
				if (departmentFileName != null) {
					oLecture = this.vLecture.show(departmentFileName, "강좌를");
					
				}
			}
		}
		return oLecture;
	}

	public void show(OHwewon oHwewon) {// 수강신청 화면
		String input = null;
		do {
			System.out.println(oHwewon.getName() + "님 안녕하세요");
			System.out.println("==========================================");
			System.out.println(oHwewon.getName() + "님의 회원정보");
			System.out.println("아이디:" + oHwewon.getId() + " 주소:" + oHwewon.getAddress());
			System.out.println("학과:" + oHwewon.getHwakgwa() + " 소속캠퍼스:" + oHwewon.getCampus() + "캠퍼스");
			System.out.println("==========================================");
			System.out.println("다음 기능을 선택하세요");
			System.out.println("미리담기(1) 수강신청(2) 회원 탈퇴(3) 회원정보 변경(4) 강좌 둘러보기(5) 로그아웃(0)");
			input = this.scanner.next();
			OLecture oLecture = new OLecture();
			// 미리담기
			if (input.equals("1")) {
				oLecture = new OLecture();
				this.vMiridamgi.show(oHwewon.getId(), oLecture, this);
			}
			// 수강신청
			else if (input.equals("2")) {
				oLecture = new OLecture();
				this.vSincheong.show(oHwewon.getId(), oLecture, this);
			}
			// 회원 탈퇴
			else if (input.equals("3")) {
				boolean i = this.vhwewonDelete.showDelete(oHwewon);
				if (i) {
					this.vMiridamgi.mDeleteAll(oHwewon.getId());
					this.vSincheong.sDeleteAll(oHwewon.getId());
				}
				return;
			}
			// 회원정보 변경
			else if (input.equals("4")) {
				OHwewon changeoHwewon = this.vHwewonChange.showChange(oHwewon);
				this.vMiridamgi.changeFileName(changeoHwewon, oHwewon);
				this.vSincheong.changeFileName(changeoHwewon, oHwewon);
				oHwewon = changeoHwewon;
			}
			//강좌 둘러보기
			else if (input.equals("5"))
			{
				this.sugang();
			}
			// 로그아웃
			else {
				if (input.equals("0"))
					break;
				// 그 외의 숫자 입력시
				else
					System.out.println("잘못 입력하셨습니다.");
			}

		} while (!input.equals("0"));// 수강 신청 끝내기

		return;
	}
}
