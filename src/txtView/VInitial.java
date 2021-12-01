package txtView;

import java.util.Scanner;

import valueObject.OHwewon;

public class VInitial {

	private Scanner scanner;
	private VHwewonDeungrok hwewonDeungrok;
	private VHwewonDeungrok searchId;
	private VHwewonDeungrok searchPassword;
	private VHwewonDeungrok vHakgwaList;
	private VLogin login;
	private VSugangsincheon vSugangsincheon;
	

	public VInitial(Scanner scanner) {
		this.scanner = scanner;
		this.hwewonDeungrok = new VHwewonDeungrok(scanner);
		this.login = new VLogin(scanner);
		this.vHakgwaList = new VHwewonDeungrok(scanner);
		this.searchId = new VHwewonDeungrok(scanner);
		this.searchPassword = new VHwewonDeungrok(scanner);
	}

	public void show() {
		String input = null;

		do {
			System.out.println("다음 기능을 선택 하세요");
			System.out.println("로그인(1), 회원등록(2), 아이디 찾기(3), 비밀번호 찾기(4), 회원가입 인원 리스트(5), 학교 학과 리스트(6)");
			input = scanner.next();

			// 로그인
			if (input.equals("1")) {
				// login dialog show
				OHwewon OHwewon = this.login.show();
				// 비밀번호가 맞을 시
				if (OHwewon != null) {
					this.vSugangsincheon = new VSugangsincheon(this.scanner);
					this.vSugangsincheon.show(OHwewon);
				}
				// 비밀번호가 맞지 않을 시
				else if (OHwewon == null) {
					System.out.println("회원등록을 하시겠습니까?");
					System.out.println("네(1) 아니요(2)");

					input = this.scanner.next();
					if (input.equals("1")) {
						this.hwewonDeungrok.show();
					}
				}
			}

			// 회원등록
			else if (input.equals("2")) {
				this.hwewonDeungrok.show();
			}

			// 아이디 찾기
			else if (input.equals("3")) {
				this.searchId.idsearch();
			}

			// 비밀번호 찾기
			else if (input.equals("4")) {
				this.searchPassword.passwordsearch();
			}

			// 회원 등록한 학생 리스트 확인
			else if (input.equals("5")) {
				this.hwewonDeungrok.showHwewonList();
			}
			//학교 학과 리스트
			else if (input.equals("6")) {
				this.vHakgwaList.showHakgwaList();
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println("===========================================");
			System.out.println("수강신청 프로그램 계속하기(1) 끝내기(0)");
			input = this.scanner.next();

		} while (!input.equals("0"));

		return;
	}

}
