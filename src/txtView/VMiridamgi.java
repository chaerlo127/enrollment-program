package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VMiridamgi {
	private CLecture cLecture;
	private Scanner scanner;
	private String FileName;
	private String SugangFile;
	private int sum;
	private int remain;
	private static final int NUMCREDIT = 24;
	private static final String MIRI = "M";
	private static final String SUGANG = "S";

	public VMiridamgi(Scanner scanner) {
		this.cLecture = new CLecture();
		this.scanner = scanner;
	}

	public void show(String id, OLecture oLecture, VSugangsincheon vSugangsincheon) {
		String input = "99";
		String id1 = "99";
		this.FileName = id + MIRI;
		this.SugangFile = id + SUGANG;
		do {
			System.out.println("미리담기 신청(1) 미리담기 철회(2) 내 미리담기 확인하기(3) ");
			System.out.println("수강신청 강좌 철회 후, 미리담기로 변경(4) 미리담기 내용 전체 지우기(5) 미리담기 끝내기(0)");
			input = this.scanner.next();

			// 미리담기 신청
			if (input.equals("1")) {
				System.out.println("미리담기를 시작합니다.");
				// 학점 초과 시 미리담기 못하게 하기
				boolean i = this.cLecture.ExistFile(this.FileName);
				if (i) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					sum = this.cLecture.creditSum(lectures);
					if (sum < NUMCREDIT-2)// 마지막으로 할 수 있는 학점이 24학점이므로 2학점 혹은 3학점을 받는 경우 21+2 or 3 이므로 24 이내가 된다.
					{
						this.MiriSugang(oLecture, vSugangsincheon);
					} else {
						System.out.println("=======================================================================");
						System.out.println("신청할 수 있는 학점은 "+NUMCREDIT +"학점입니다. 학점이 초과되었습니다. 다른 강좌를 철회하고 다시 시도해주세요.");
						System.out.println("=======================================================================");
					}
				} else {
					this.MiriSugang(oLecture, vSugangsincheon);
				}

			}

			// 미리담기 철회
			else if (input.equals("2")) {
				System.out.println("미리담기 철회를 시작합니다.");
				System.out.println(id + "님의 미리담기");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					System.out.println("============================");
					System.out.println("철회할 미리담기 강좌 번호를 하나 선택해주세요");
					id1 = this.scanner.next();
					System.out.println("============================");
					this.Delete(lectures, id1, this.FileName);
				} else
					System.out.println("책가방이 비어있습니다.");
			}

			// 내 미리담기 확인하기
			else if (input.equals("3")) {
				System.out.println(id + "님의 미리담기");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				this.sum = 0;
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					this.sum = this.cLecture.creditSum(lectures);
					System.out.println(id + "님의 미리담기 학점: " + this.sum);
					this.remain = this.cLecture.remainCredit(NUMCREDIT);
					System.out.println("신청할 수 있는 학점: " + this.remain);
				} else
				{
					System.out.println("책가방이 비어있습니다.");
					System.out.println(id + "님의 미리담기 학점: " + this.sum);
					System.out.println("신청할 수 있는 학점: " + NUMCREDIT);
				}
			}

			// 수강신청 강좌 미리담기로 변경
			else if (input.equals("4")) {
				System.out.println(id + "님의 수강신청 리스트");
				boolean exist = this.cLecture.ExistFile(this.SugangFile);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.SugangFile);
					this.List(lectures);
					System.out.println("수강신청을 철회하고 미리담기로 옮길 강좌를 선택해주세요");
					String id2 = this.scanner.next();

					for (OLecture lecture : lectures) {
						if (lecture.getId().equals(id2)) {
							boolean i = this.cLecture.ExistFile(this.FileName);
							if (i)// true
							{
								Vector<OLecture> Mirilectures = this.cLecture.MSgetAll(this.FileName);// 변경 전
								sum = this.cLecture.creditSum(Mirilectures);
								if (sum < NUMCREDIT-2) {
									oLecture = lecture;
									boolean a = this.Write(this.FileName, oLecture);
									if (a) {
										this.Delete(lectures, id2, this.SugangFile);
										System.out.println(id + "님의 미리담기");
										Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
										this.List(lectures1);
									} else {
										//강좌 중복
										System.out.println("다시 시도하세요.");
									}

								} else {
									System.out.println(
											"=======================================================================");
									System.out.println("신청할 수 있는 학점은 "+NUMCREDIT +"학점입니다. 학점이 초과되었습니다. 다른 강좌를 철회하고 다시 시도해주세요.");
									System.out.println(
											"=======================================================================");
								}

							} else {
								oLecture = lecture;
								boolean a = this.Write(this.FileName, oLecture);
								if (a) {
									this.Delete(lectures, id2, this.SugangFile);
									System.out.println(id + "님의 미리담기");
									Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
									this.List(lectures1);
								} else {
									System.out.println("다시 시도하세요.");
								}

							}

						}
					}

				} else
					System.out.println("수강신청 내역이 비어있습니다.");
			}
			// 미리담기 전체 지우기
			else if (input.equals("5")) {
				System.out.println("정말로 전부 지우시겠습니까?");
				System.out.println("네(1) 아니오(2)");
				input = this.scanner.next();
				if (input.equals("1")) {
					boolean i = this.cLecture.DeleteAll(this.FileName);
					if (i == true) {
						System.out.println("강좌를 모두 지웠습니다.");
					} else if (i == false) {
						System.out.println("책가방이 비어져있어, 지울 강좌가 없습니다.");
					}

				} else if (input.equals("2")) {
					System.out.println("강좌 지우기를 취소합니다.");
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} else {
				if (input.equals("0")) {
					break;
				} else
					System.out.println("잘못 입력하셨습니다.");
			}

		} while (!input.equals("99"));// 미리담기 끝내기

		return;
	}

	//신청 리스트 전부 읽어오기
	public void List(Vector<OLecture> lectures)
	{
		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}
	}

	public boolean Delete(Vector<OLecture> lectures, String id1, String MIRIfileName) {// 특정 강좌 지우기
		for (OLecture lecture : lectures) {
			if (lecture.getId().equals(id1)) {
				boolean exist = this.cLecture.MSWriteAll(id1, MIRIfileName);
				if (exist) {
					System.out.println(lecture.getId() + "강좌가 삭제 되었습니다.");
					return true;
				}
			}
		}
		return false;
	}
	
	//미리담기파일에 강좌 쓰기
	public boolean Write(String fileName, OLecture oLecture) {
		boolean a = this.cLecture.Write(fileName, oLecture);
		if (a) {
			System.out.println("미리담기 되었습니다.");
		} else {
			System.out.println("강좌가 중복되었습니다.");
		}
		return a;
	}

	//미리담기 수강신청
	public void MiriSugang(OLecture oLecture, VSugangsincheon vSugangsincheon)
	{
		oLecture = vSugangsincheon.sugang();
		System.out.println("미리담기 하겠습니까?");
		System.out.println("미리담기 신청(1) 취소(2)");
		String input = this.scanner.next();
		if(input.equals("1"))
		{
			this.Write(this.FileName, oLecture);
		}
		else {
			System.out.println("미리담기 신청을 취소합니다.");
		}
	}
	
	//회원 탈퇴 시, 미리담기에 있는 내용 다 지우기
	public void mDeleteAll(String id)
	{
		this.cLecture.DeleteAll(id+MIRI);
	}

	
	//회원 정보 변경 시, 회원의 미리담기 강좌 이름도 변경
	public void changeFileName(OHwewon changeoHwewon, OHwewon oHwewon) {
		this.cLecture.changeFileName(changeoHwewon.getId()+MIRI, oHwewon.getId()+MIRI);
	}
}
