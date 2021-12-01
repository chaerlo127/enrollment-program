package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CHwewonDeungrok;
import control.CIndex;
import valueObject.OHwewon;
import valueObject.OIndex;

public class VHwewonDeungrok {

	private Scanner scanner;
	private CIndex cIndex;
	private CHwewonDeungrok cHwewonDeungrok;
	private static final String FIRSTFILENAME = "List";

	public VHwewonDeungrok(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
		this.cIndex = new CIndex();
	}

	public void show() {
		System.out.println("회원정보를 입력하세요.");
		OHwewon oHwewon = new OHwewon();
		System.out.print("아이디 입력: ");
		String id = scanner.next();
		oHwewon.setId(id);

		System.out.print("비밀번호: ");
		String password = scanner.next();
		oHwewon.setPassword(password);

		System.out.print("이름: ");
		String name = scanner.next();
		oHwewon.setName(name);

		System.out.print("주소: ");
		String address = scanner.next();
		oHwewon.setAddress(address);

		System.out.print("학과(Full Name을 적어주세요): ");
		String hwakgwa = scanner.next();
		oHwewon.setHwakgwa(hwakgwa);

		System.out.print("캠퍼스(용인/서울, 두글자로 써주세요): ");
		String campus = scanner.next();
		oHwewon.setCampus(campus);

		boolean i = this.cHwewonDeungrok.saveHwewon(oHwewon);
		if (i == true) {
			System.out.println("회원 등록되었습니다.");
		} else {
			System.out.println("중복된 아이디 입니다. 아이디를 다시 설정하세요.");
		}
	}

	// 아이디 찾기
	public void idsearch() {
		System.out.println("이름, 학과, 캠퍼스를 적어주세요.");

		OHwewon oHwewon = new OHwewon();
		System.out.print("이름:");
		String name = this.scanner.next();
		oHwewon.setName(name);

		System.out.print("학과:");
		String hwakgwa = this.scanner.next();
		oHwewon.setHwakgwa(hwakgwa);

		System.out.print("캠퍼스:");
		String campus = this.scanner.next();
		oHwewon.setCampus(campus);

		String id = this.cHwewonDeungrok.idsearch(oHwewon);
		if (id != null) {
			System.out.println(oHwewon.getName() + "님의 아이디: " + id);
		} else {
			System.out.println("회원정보가 잘못되었습니다. 다시 입력해주세요.");
		}
	}

	// 비밀번호 찾기
	public void passwordsearch() {
		System.out.println("아이디, 이름, 학과, 캠퍼스를 적어주세요.");

		OHwewon oHwewon = new OHwewon();
		System.out.print("아이디:");
		String id = this.scanner.next();
		oHwewon.setId(id);

		System.out.print("이름:");
		String name = this.scanner.next();
		oHwewon.setName(name);

		System.out.print("학과:");
		String hwakgwa = this.scanner.next();
		oHwewon.setHwakgwa(hwakgwa);

		System.out.print("캠퍼스:");
		String campus = this.scanner.next();
		oHwewon.setCampus(campus);

		String password = this.cHwewonDeungrok.passwordsearch(oHwewon);
		if (password != null) {
			System.out.println(oHwewon.getName() + "님의 비밀번호: " + password);
		} else {
			System.out.println("회원정보가 잘못되었습니다. 다시 입력해주세요.");
		}
	}

	//회원등록 리스트
	public void showHwewonList() {
		Vector<OHwewon> hwewons = this.cHwewonDeungrok.readHwewonList();
		if (hwewons != null) {
			System.out.println("확인하고, 자신이 회원 리스트에 없다면 회원가입을 진행해주세요.");
			System.out.println("===========================================");
			System.out.println("수강신청 프로그램 회원가입 리스트");
			for (OHwewon oHwewon : hwewons) {
				System.out.println("아이디: " + oHwewon.getId() + " 이름: " + oHwewon.getName());
			}
		}
		else
		{
			System.out.println("회원등록한 학생이 없습니다.");
		}
	}
	
	
	//학과 리스트
	public void showHakgwaList() {
		Vector<OIndex> indices = cIndex.HakgwaGetAll(FIRSTFILENAME);
		for (OIndex oIndex : indices) {
			System.out.println(oIndex.getId() + " " + oIndex.getName());
		}
		System.out.println("회원가입 전, 학교에 있는 학과를 찾아보시길 바랍니다.");
		System.out.println("자신이 속해있는 학과의 Full Name을 적어주세요. Ex) 컴퓨터공학과");
		System.out.println("보고싶은 학과를 선택해주세요.");
		String input = this.scanner.next();
		System.out.println("===========================================");
		for (OIndex oIndex : indices) {
			if (oIndex.getId().equals(input)) {
				Vector<OIndex> indices2 = cIndex.HakgwaGet(oIndex.getFileName());
				for (OIndex oIndex1 : indices2)
				{
					System.out.println(oIndex1.getName());
				}
			}
		}
	}
}
