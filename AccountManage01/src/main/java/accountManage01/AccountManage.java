package accountManage01;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AccountManage {
	static ArrayList<Account> list = new ArrayList<Account>();

	static Scanner scan = new Scanner(System.in);
	static String msgString;
	static int msgInt;

	public static void main(String[] args) {
		while (true) {
			System.out.println("<<계좌 관리 시스템>>");
			System.out.println("1. 계좌 정보 등록");
			System.out.println("2. 계좌 목록 출력");
			System.out.println("3. 계좌 정보 수정");
			System.out.println("4. 계좌 정보 삭제");
			System.out.println("5. 입출금");
			System.out.println("6. 입출금 히스토리 목록 출력");

			System.out.print("이용할 서비스 입력 : ");
			msgInt = scan.nextInt();
			System.out.print("\n");

			switch (msgInt) {
			case 1:
				createAccount();
				break;
			case 2:
				printAccount();
				break;
			case 3:
				updateAccount();
				break;
			case 4:
				deleteAccount();
				break;
			case 5:
				doAccount();
				break;
			case 6:
				printAccountHistory();
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}

	}

	private static void printAccountHistory() {
		System.out.println("-------- 히스토리 출력 -------");
		System.out.println("1. 하나의 계좌 히스토리 출력");
		System.out.println("2. 모든 계좌 히스토리 출력");
		System.out.println("3. 하나의 계좌 히스토리 파일 저장(CSV)");
		System.out.println("4. 하나의 계좌 히스토리 파일 저장(EXCEL)");

		System.out.print("이용할 서비스 입력 : ");
		msgInt = scan.nextInt();

		switch (msgInt) {
		case 1:
			printOneAccountHistory();
			break;
		case 2:
			printAllAccountHistory();
			break;
		case 3:
			saveAccountHistoryCSV();
			break;
		case 4:
			saveAccountHistoryEXCEL();
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}

		System.out.print("\n");
	}

	// jexcelapi 사용
	// jxl
	private static void saveAccountHistoryEXCEL() {
		Account account = null;
		String path = "c:\\";

		System.out.print("저장하실 계좌 번호를 입력하세요 : ");
		msgInt = scan.nextInt();
		scan.nextLine();
		account = findAccount(msgInt);

		System.out.print("저장하실 파일 위치를 입력하세요 : ex) d:/");
		path = scan.nextLine();
		String fileName = path + "/" + msgInt + "AccountHistory.xls";

		// 파일 입력
		try {
			WritableWorkbook wworkbook;
			wworkbook = Workbook.createWorkbook(new File("fileName"));
			WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);

			String temp;
			temp = msgInt + "계좌 기록" + "\n";
			try {
				wsheet.addCell(new Label(0, 0, temp));

				for (int i = 0; i < account.getHistroys().size(); i++) {
					wsheet.addCell(new Label(i, 0, account.getHistroys().get(i)
							.getStatue()));
					wsheet.addCell(new Label(i, 1, account.getHistroys().get(i)
							.getTime()));

				}

				temp = "최종 잔액 : " + account.getBalance() + "\n";
				wsheet.addCell(new Label(account.getHistroys().size(), 0, temp));

				wworkbook.write();
				wworkbook.close();
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void saveAccountHistoryCSV() {
		Account account = null;
		String path = "c:\\";

		System.out.print("저장하실 계좌 번호를 입력하세요 : ");
		msgInt = scan.nextInt();
		scan.nextLine();
		account = findAccount(msgInt);

		System.out.print("저장하실 파일 위치를 입력하세요 : ex) d:/");
		path = scan.nextLine();
		String fileName = path + "/" + msgInt + "AccountHistory.csv";

		// 파일 입력
		try {
			FileWriter writer = new FileWriter(fileName);
			String temp;

			temp = msgInt + "계좌 기록" + "\n";
			writer.append(temp);

			for (History one : account.getHistroys()) {
				temp = one.getStatue() + ", " + one.getTime() + "\n";
				writer.append(temp);
			}

			temp = "최종 잔액 : " + account.getBalance() + "\n";
			writer.append(temp);

			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printAllAccountHistory() {
		System.out.println("------------ 모든 계좌 출력 ------------");

		for (Account oneAccount : list) {
			for (History oneHistory : oneAccount.getHistroys()) {
				System.out.printf("%03d\t%s\t", oneAccount.getNum(),
						oneAccount.getName());

				System.out.println(oneHistory.getStatue() + "\t"
						+ oneHistory.getTime());
			}
		}

		System.out.println("\n");

	}

	private static void printOneAccountHistory() {
		Account temp = null;

		System.out.print("출력하실 계좌 번호를 입력하세요 : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		temp = findAccount(msgInt);
		for (History one : temp.getHistroys()) {
			System.out.println(one.getStatue() + "\t" + one.getTime());
		}
		System.out.println("최종 잔액 : " + temp.getBalance());
	}

	private static void doAccount() {

		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.print("처리하실 업무를 선택하세요 : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		if (msgInt == 1) {
			depositAccount();
		} else if (msgInt == 2) {
			withdrawAccount();
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	private static void withdrawAccount() {
		Account temp = null;

		do {
			System.out.print("입금할 계좌번호를 입력하세요 :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		System.out.print("출금할 금액을 입력하세요 : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		if ((temp.getBalance() - msgInt) < 0) {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
		} else {
			temp.minusBalance(msgInt);
			System.out.print("인출이 완료되었습니다. : ");
		}
	}

	private static void depositAccount() {
		Account temp = null;

		do {
			System.out.print("입금할 계좌번호를 입력하세요 :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		System.out.print("입금할 금액을 입력하세요 : ");
		temp.plusBalance(scan.nextInt());
		scan.nextLine();
	}

	private static void deleteAccount() {
		int temp = 0;

		do {
			System.out.print("삭제할 계좌번호를 입력하세요 :");
			msgInt = scan.nextInt();
			scan.nextLine();

		} while (findAccount(msgInt) == null);

		System.out.println("정말 삭제하실 건가요? y/n");
		msgString = scan.nextLine();

		if ("y".equalsIgnoreCase(msgString)) {
			if (findAccount(msgInt).getBalance() == 0) {
				list.remove(findIndexNum(msgInt));
				System.out.println("계좌를 삭제하였습니다.");
			} else {
				System.out.println("잔액이 남아 삭제 할 수 없습니다");
			}

			System.out.println("계좌 삭제를 완료하였습니다.");
		} else if ("n".equalsIgnoreCase(msgString)) {
			System.out.println("계좌 삭제를 취소합니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	private static int findIndexNum(int num) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == num) {
				return i;
			}
		}

		return 0;
	}

	private static void updateAccount() {
		Account temp = null;

		do {
			System.out.print("수정할 계좌번호를 입력하세요 :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		do {
			System.out.println("계좌번호 : ");
			msgInt = scan.nextInt();
			scan.nextLine();
		} while (isValidateNum(msgInt));

		temp.setNum(msgInt);

		System.out.println("계좌이름 : ");
		temp.setName(scan.nextLine());

		System.out.println("은행명");
		temp.setBankName(scan.nextLine());

		System.out.println("은행전화번호");
		temp.setBankPhone(scan.nextLine());

	}

	private static Account findAccount(int msgInt2) {
		// find account
		for (Account account : list) {
			if (account.getNum() == msgInt) {
				return account;
			}
		}

		System.out.println("존재하는 계좌번호를 입력하세요.");
		return null;
	}

	private static void createAccount() {
		Account temp = new Account();

		System.out.println("계좌정보를 입력합니다");

		do {
			System.out.print("계좌번호 : ");
			msgInt = scan.nextInt();
			scan.nextLine();
		} while (isValidateNum(msgInt));
		temp.setNum(msgInt);

		System.out.print("계좌이름 : ");
		temp.setName(scan.nextLine());

		System.out.print("은행명 : ");
		temp.setBankName(scan.nextLine());

		do {
			System.out.print("은행전화번호(숫자를 제외하고 입력하세요) : ");
			msgString = scan.nextLine();
		} while (isValidatePhoneNum(msgString));
		temp.setBankPhone(msgString);

		list.add(temp);

		System.out.print("\n\n");
	}

	private static boolean isValidatePhoneNum(String phoneNum) {
		// 숫자만 입력하는지 확인
		if (phoneNum.matches("[0-9]+")) {
			return false;
		}
		System.out.println("숫자만 입력해주세요.");
		return true;
	}

	private static boolean isValidateNum(int num) {
		if (num > 0 & num < 1000) {
			return false;
		} else {
			System.out.println("세자리 숫자만 입력하세요.");
			return true;
		}
	}

	private static void printAccount() {
		System.out.println("------------- 계좌 목록 ----------------");
		System.out.println("계화번호	계좌이름	은행명		은행전화번호	현재 잔액");

		Collections.sort(list, new NameAscCompare());

		for (Account account : list) {

			System.out.printf("%03d\t%s\t%s\t%s\t%s", account.getNum(),
					account.getName(), account.getBankName(),
					account.getBankPhone(), account.getBalance());
		}

		System.out.println("");

	}
}

/**
 * 이름 오름차순
 * 
 * @author falbb
 *
 */
class NameAscCompare implements Comparator<Account> {

	/**
	 * 오름차순(ASC)
	 */
	@Override
	public int compare(Account arg0, Account arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}