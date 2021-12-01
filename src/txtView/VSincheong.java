package txtView;

import java.util.Scanner;
import java.util.Vector;

import control.CLecture;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSincheong {
	private CLecture cLecture;
	private Scanner scanner;
	private String FileName;
	private String MiriFile;
	private static final String MIRI = "M";
	private static final String SUGANG = "S";
	private static final int NUMCREDIT = 18;// 학점
	private int sum;
	private int remain;
	private float prSum;// 예상 학점 더한 값

	public VSincheong(Scanner scanner) {
		this.cLecture = new CLecture();
		this.scanner = scanner;
	}

	public void show(String id, OLecture oLecture, VSugangsincheon vSugangsincheon) {
		String input = null;
		this.FileName = id + SUGANG;
		this.MiriFile = id + MIRI;
		do {
			System.out.println("===================================================================");
			System.out.println("수강신청(1) 미리담기에 저장되어 있는 강좌 수강신청(2)");
			System.out.println("수강신청 철회(3) 내 수강신청 확인하기(4)  수강신청 내용 전체 지우기(5) 예상학점 계산기(6) 수강신청 끝내기(0)");
			System.out.println("====================================================================");
			input = this.scanner.next();

			// 수강신청
			if (input.equals("1")) {
				String id3 = null;
				do {
					System.out.println("수강신청을 시작합니다");
					boolean i = this.cLecture.ExistFile(this.FileName);
					if (i) {
						Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
						sum = this.cLecture.creditSum(lectures);
						if (sum < NUMCREDIT - 2)// 최대학점수 18
						{
							this.SugangSincheong(oLecture, input, vSugangsincheon);
						} else {
							System.out
									.println("=======================================================================");
							System.out.println(
									"신청할 수 있는 학점은 " + NUMCREDIT + "학점입니다. 학점이 초과되었습니다. 다른 강좌를 철회하고 다시 시도해주세요.");
							System.out
									.println("=======================================================================");
						}

					} else {
						this.SugangSincheong(oLecture, input, vSugangsincheon);
					}
					System.out.println("수강신청(1) 수강신청 끝내기(0)");
					id3 = this.scanner.next();
				} while (!id3.equals("0"));
			}

			// 미리담기 내에 있는 강좌 수강신청
			else if (input.equals("2")) {
				System.out.println("미리담기에 저장되어 있는 리스트 중에서 수강신청을 시작합니다.");
				System.out.println("미리담기 리스트");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(id + MIRI);
				if (exist) {
					Vector<OLecture> Mirilectures = this.cLecture.MSgetAll(this.MiriFile);
					this.List(Mirilectures);// 미리담기 전부다 읽어오기
					System.out.println("수강신청할 강좌를 선택해주세요:");
					String sugangid = this.scanner.next();
					for (OLecture lecture : Mirilectures) {//
						if (lecture.getId().equals(sugangid)) {
							boolean i = this.cLecture.ExistFile(this.FileName);
							if (i) {
								Vector<OLecture> Suganglectures = this.cLecture.MSgetAll(this.FileName);
								sum = this.cLecture.creditSum(Suganglectures);
								if (sum < NUMCREDIT - 2) {
									boolean a = this.Write(this.FileName, lecture);
									if (a) {
										System.out.println("============================");
										System.out.println(id + "님의 수강신청");
										Vector<OLecture> lectures1 = this.cLecture.MSgetAll(this.FileName);
										this.List(lectures1);
										this.sum = 0;
										this.sum = this.cLecture.creditSum(lectures1);
										System.out.println(id + "수강신청 총 학점: " + this.sum);
										System.out.println("============================");
										System.out.println("미리담기에 강좌 없애기(1) 미리담기 유지(2)");
										input = this.scanner.next();

										if (input.equals("1")) {
											this.Delete(Mirilectures, sugangid, this.MiriFile);
											break;
										}

										else if (input.equals("2")) {
											break;
										}
									} else {
										System.out.println("다시 입력해주세요.");
									}
								} else {
									System.out.println(
											"=======================================================================");
									System.out.println(
											"신청할 수 있는 학점은 " + NUMCREDIT + "학점입니다. 학점이 초과되었습니다. 다른 강좌를 철회하고 다시 시도해주세요.");
									System.out.println(
											"=======================================================================");
								}

							} else {
								boolean a = this.Write(this.FileName, lecture);
								if (a) {
									System.out.println("미리담기에 강좌 없애기(1) 미리담기 유지(2)");
									input = this.scanner.next();

									if (input.equals("1")) {
										this.Delete(Mirilectures, sugangid, this.MiriFile);
										break;
									}

									else if (input.equals("2")) {
										break;
									}
								}

							}

						}
					}
				} else
					System.out.println("책가방이 비어있습니다.");
			}

			// 수강신청 철회
			else if (input.equals("3")) {
				String id1 = "99999999999";
				System.out.println("수강신청 철회를 시작합니다.");
				System.out.println("============================");
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					do {
						System.out.println(id + "님의 수강신청");
						Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
						this.List(lectures);// 수강신청 리스트 전부 읽어오기
						System.out.println("====================================================");
						System.out.println("수강신청 철회(1) 미리담기로 변경(2)");
						String put = this.scanner.next();
						System.out.println("철회할 수강신청 강좌 번호를 하나 선택해주세요. 끝내려면 0번을 눌러주세요.");
						System.out.println("====================================================");
						// 수강 신청 철회
						if (put.equals("1")) {
							id1 = this.scanner.next();
							this.Delete(lectures, id1, this.FileName);
						}
						// 미리담기로 변경
						else if (put.equals("2")) {
							id1 = this.scanner.next();

							for (OLecture lecture : lectures) {
								if (lecture.getId().equals(id1)) {
									boolean i = this.Write(this.MiriFile, lecture);
									if (i) {
										this.Delete(lectures, id1, this.FileName);
										System.out.println("미리담기로 변경되었습니다.");
										break;
									} else {

									}

								}
							}
						} else {
							System.out.println("잘못 입력하셨습니다.");
						}
					} while (!id1.equals("0"));
				} else {
					System.out.println("수강신청 강좌가 비어있습니다");
				}
			}

			// 내 수강신청 확인하기
			else if (input.equals("4")) {
				System.out.println(id + "님의 수강신청");
				this.sum = 0;
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					this.sum = this.cLecture.creditSum(lectures);
					System.out.println(id + "님의 수강신청 학점: " + this.sum);
					this.remain = this.cLecture.remainCredit(NUMCREDIT);
					System.out.println("신청할 수 있는 학점: " + this.remain);
				} else {
					System.out.println("수강신청 강좌가 비어있습니다");
					System.out.println(id + "님의 수강신청 학점: " + this.sum);
					System.out.println("신청할 수 있는 학점: " + NUMCREDIT);
				}

			}

			// 수강신청 내용 전체 지우기
			else if (input.equals("5")) {
				System.out.println("정말로 전부 지우시겠습니까?");
				System.out.println("네(1) 아니오(2)");
				input = this.scanner.next();
				// 강좌 비우기
				if (input.equals("1")) {
					boolean i = this.cLecture.DeleteAll(this.FileName);
					if (i == true) {
						System.out.println("강좌를 모두 지웠습니다.");
					}
					// 수강신청이 비워져 있는 경우
					else if (i == false) {
						System.out.println("수강신청을 한 강좌가 없어, 지울 강좌가 없습니다.");
					}

				} else if (input.equals("2")) {
					System.out.println("강좌 지우기를 취소합니다.");
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
			// 수강신청 예상 학점 계산기
			else if (input.equals("6")) {
				boolean exist = this.cLecture.ExistFile(this.FileName);
				if (exist) {
					Vector<OLecture> lectures = this.cLecture.MSgetAll(this.FileName);
					this.List(lectures);
					int lectureNum = 0;// 강좌 학점 초기화, 프로그램 계속 실행 시, 누적되기 때문
					lectureNum = this.cLecture.NumCredit(lectures);
					if (lectureNum != 0) {
						System.out.println("예상 학점을 차례로 입력해주세요.");
						System.out.println("A+(4.5) A(4) B+(3.5) B(3) C+(2.5) C(2) D(1.5) D+(1) F(0)");
						
						for (int i = 0; i < lectureNum; i++) {
							String j = this.scanner.next();
							this.prSum = this.cLecture.predictCredit(j);
						}
						System.out.println(id + "님의 예상학점은 " + this.prSum / lectureNum + "입니다.");
						this.cLecture.prSumInitialization();//cLecture prsum 초기화
					} else {
						System.out.println("수강신청 내역이 비어있습니다.");
					}

				} else {
					System.out.println("수강신청 내역이 비어있습니다.");
				}

			}

			else {
				if (input.equals("0"))
					break;
				else
					System.out.println("잘못 입력하셨습니다.");
			}

		} while (!input.equals(null));// 수강신청 끝내기

		return;

	}

	public Vector<OLecture> List(Vector<OLecture> lectures)// 수강신청 리스트 전부 읽어오기
	{

		for (OLecture lecture : lectures) {
			System.out.println(lecture.getId() + " " + lecture.getName() + " " + lecture.getProfessor() + " "
					+ lecture.getCredit() + " " + lecture.getTime());
		}

		return lectures;
	}

	public void Delete(Vector<OLecture> lectures, String id1, String SugangFileName) {
		for (OLecture lecture : lectures) {
			if (lecture.getId().equals(id1)) {
				boolean exist = this.cLecture.MSWriteAll(id1, SugangFileName);
				if (exist) {
					System.out.println(lecture.getId() + "강좌가 삭제 되었습니다.");
				} else {
					System.out.println("강좌 내역이 비어있습니다.");
				}
			}
		}
	}

	// 중복된 강좌 있는지 확인하기
	public boolean Write(String fileName, OLecture oLecture) {
		boolean a = this.cLecture.Write(fileName, oLecture);
		if (a) {
			System.out.println("수강신청 되었습니다.");
		} else {
			System.out.println("강좌가 중복되었습니다.");
		}
		return a;
	}

	// 수강신청 하기
	public void SugangSincheong(OLecture oLecture, String input, VSugangsincheon vSugangsincheon) {
		oLecture = vSugangsincheon.sugang();
		System.out.println("수강신청 하겠습니까?");
		System.out.println("수강 신청(1) 취소(2)");
		input = this.scanner.next();
		if (input.equals("1")) {
			this.Write(this.FileName, oLecture);
		} else {
			System.out.println("수강 신청을 취소합니다.");
		}
	}

	// 파일 전부 다 지우기
	public void sDeleteAll(String id) {
		this.cLecture.DeleteAll(id + SUGANG);
	}

	// 회원 파일 이름 변경, 회원정보 변경 시
	public void changeFileName(OHwewon changeoHwewon, OHwewon oHwewon) {
		this.cLecture.changeFileName(changeoHwewon.getId() + SUGANG, oHwewon.getId() + SUGANG);
	}

}
