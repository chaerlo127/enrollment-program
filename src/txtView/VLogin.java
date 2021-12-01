package txtView;

import java.util.Scanner;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {

	private Scanner scanner;
	private CLogin clogin;
	
	public VLogin(Scanner scanner) {
		this.scanner = scanner;
		this.clogin = new CLogin();
	}

	public OHwewon show() {
		
		System.out.println("아이디와 비밀번호를 입력하세요");
		OLogin oLogin = new OLogin();
		System.out.print("아이디 입력: ");
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.print("비밀번호: ");
		String password = scanner.next();
		oLogin.setPassword(password);
		
		OHwewon ohwewon = this.clogin.validate(oLogin);
		//validate는 확인하는 것임
		
		if(ohwewon != null) {
			return ohwewon;			
		}else 
		{
			System.out.println("아이디와 비밀번호가 올바르지 않습니다");
			System.out.println("다시 입력해주세요");//새 기능
			return null;
		}
	}
	
}
