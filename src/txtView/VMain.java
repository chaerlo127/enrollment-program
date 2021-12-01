package txtView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VMain {

	private VInitial initial;
	
	public VMain(Scanner scanner) {	
		this.initial = new VInitial(scanner);
	}
	public void run() {
		
		this.initial.show();
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 수강신청 프로그램 시작합니다.");
		Date time = new Date();
		String onTime = sdf.format(time);
		System.out.println(onTime);
		VMain main = new VMain(scanner);
		main.run();
		scanner.close();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 수강신청 프로그램을 종료합니다.");
		Date time1 = new Date();
		String onTime1 = sdf1.format(time1);
		System.out.println(onTime1);
		long end = System.currentTimeMillis();// 분으로 측정 됨.
		System.out.println("프로그램 사용시간: " + ( end - start )/1000+"초");
		System.exit(0);
	}
}
