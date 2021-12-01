package txtView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonChangeDelete {

	private Scanner scanner;
	private CHwewonDeungrok cHwewonDeungrok;
	private boolean i;
	
	public VHwewonChangeDelete(Scanner scanner) {
		this.scanner = scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}

	public OHwewon showChange(OHwewon oHwewon) {
		System.out.println("회원정보 변경을 하시겠습니까?");
		System.out.println("네(1) 아니오(2)");
		String input = this.scanner.next();
		//회원정보 변경
		if(input.equals("1"))
		{
			this.i = this.cHwewonDeungrok.DeleteHwewon(oHwewon);
			if(i)
			{
				oHwewon = new OHwewon();
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

				boolean j = this.cHwewonDeungrok.saveHwewon(oHwewon);
				if (j == true) {
					System.out.println("회원 등록되었습니다.");
				} else {
					System.out.println("중복된 아이디 입니다. 아이디를 다시 설정하세요.");
				}
			}
		}
		else {
			System.out.println("회원정보 변경을 취소합니다.");
		}
		return oHwewon;
	}
	
	public boolean showDelete(OHwewon oHwewon) {
		System.out.println("정말 회원을 탈퇴하시겠습니까?");
		System.out.println("네(1) 아니오(2)");
		String input = this.scanner.next();
		if(input.equals("1"))
		{
			this.i = this.cHwewonDeungrok.DeleteHwewon(oHwewon);			
		}
		else
		{
			System.out.println("회원탈퇴를 취소합니다.");
		}
		return this.i;
	}
	
}
