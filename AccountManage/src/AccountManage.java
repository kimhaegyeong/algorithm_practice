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
			System.out.println("<<���� ���� �ý���>>");
			System.out.println("1. ���� ���� ���");
			System.out.println("2. ���� ��� ���");
			System.out.println("3. ���� ���� ����");
			System.out.println("4. ���� ���� ����");
			System.out.println("5. �����");
			System.out.println("6. ����� �����丮 ��� ���");

			System.out.print("�̿��� ���� �Է� : ");
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
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				break;
			}
		}

	}

	private static void printAccountHistory() {
		System.out.println("-------- �����丮 ��� -------");
		System.out.println("1. �ϳ��� ���� �����丮 ���");
		System.out.println("2. ��� ���� �����丮 ���");
		System.out.println("3. �ϳ��� ���� �����丮 ���� ����(CSV)");
		System.out.println("4. �ϳ��� ���� �����丮 ���� ����(EXCEL)");

		System.out.print("�̿��� ���� �Է� : ");
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
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			break;
		}

		System.out.print("\n");
	}

	// jexcelapi ���
	// jxl
	private static void saveAccountHistoryEXCEL() {
		Account account = null;
		String path = "c:\\";

		System.out.print("�����Ͻ� ���� ��ȣ�� �Է��ϼ��� : ");
		msgInt = scan.nextInt();
		scan.nextLine();
		account = findAccount(msgInt);

		System.out.print("�����Ͻ� ���� ��ġ�� �Է��ϼ��� : ex) d:/");
		path = scan.nextLine();
		String fileName = path + "/" + msgInt + "AccountHistory.xls";

		// ���� �Է�
		try {
			WritableWorkbook wworkbook;
			wworkbook = Workbook.createWorkbook(new File("fileName"));
			WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);

			String temp;
			temp = msgInt + "���� ���" + "\n";
			try {
				wsheet.addCell(new Label(0, 0, temp));

				for (int i = 0; i < account.getHistroys().size(); i++) {
					wsheet.addCell(new Label(i, 0, account.getHistroys().get(i)
							.getStatue()));
					wsheet.addCell(new Label(i, 1, account.getHistroys().get(i)
							.getTime()));

				}

				temp = "���� �ܾ� : " + account.getBalance() + "\n";
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

		System.out.print("�����Ͻ� ���� ��ȣ�� �Է��ϼ��� : ");
		msgInt = scan.nextInt();
		scan.nextLine();
		account = findAccount(msgInt);

		System.out.print("�����Ͻ� ���� ��ġ�� �Է��ϼ��� : ex) d:/");
		path = scan.nextLine();
		String fileName = path + "/" + msgInt + "AccountHistory.csv";

		// ���� �Է�
		try {
			FileWriter writer = new FileWriter(fileName);
			String temp;

			temp = msgInt + "���� ���" + "\n";
			writer.append(temp);

			for (History one : account.getHistroys()) {
				temp = one.getStatue() + ", " + one.getTime() + "\n";
				writer.append(temp);
			}

			temp = "���� �ܾ� : " + account.getBalance() + "\n";
			writer.append(temp);

			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printAllAccountHistory() {
		System.out.println("------------ ��� ���� ��� ------------");

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

		System.out.print("����Ͻ� ���� ��ȣ�� �Է��ϼ��� : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		temp = findAccount(msgInt);
		for (History one : temp.getHistroys()) {
			System.out.println(one.getStatue() + "\t" + one.getTime());
		}
		System.out.println("���� �ܾ� : " + temp.getBalance());
	}

	private static void doAccount() {

		System.out.println("1. �Ա�");
		System.out.println("2. ���");
		System.out.print("ó���Ͻ� ������ �����ϼ��� : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		if (msgInt == 1) {
			depositAccount();
		} else if (msgInt == 2) {
			withdrawAccount();
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	private static void withdrawAccount() {
		Account temp = null;

		do {
			System.out.print("�Ա��� ���¹�ȣ�� �Է��ϼ��� :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		System.out.print("����� �ݾ��� �Է��ϼ��� : ");
		msgInt = scan.nextInt();
		scan.nextLine();

		if ((temp.getBalance() - msgInt) < 0) {
			System.out.println("�ܾ��� �����Ͽ� ����� �� �����ϴ�.");
		} else {
			temp.minusBalance(msgInt);
			System.out.print("������ �Ϸ�Ǿ����ϴ�. : ");
		}
	}

	private static void depositAccount() {
		Account temp = null;

		do {
			System.out.print("�Ա��� ���¹�ȣ�� �Է��ϼ��� :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		System.out.print("�Ա��� �ݾ��� �Է��ϼ��� : ");
		temp.plusBalance(scan.nextInt());
		scan.nextLine();
	}

	private static void deleteAccount() {
		int temp = 0;

		do {
			System.out.print("������ ���¹�ȣ�� �Է��ϼ��� :");
			msgInt = scan.nextInt();
			scan.nextLine();

		} while (findAccount(msgInt) == null);

		System.out.println("���� �����Ͻ� �ǰ���? y/n");
		msgString = scan.nextLine();

		if ("y".equalsIgnoreCase(msgString)) {
			if (findAccount(msgInt).getBalance() == 0) {
				list.remove(findIndexNum(msgInt));
				System.out.println("���¸� �����Ͽ����ϴ�.");
			} else {
				System.out.println("�ܾ��� ���� ���� �� �� �����ϴ�");
			}

			System.out.println("���� ������ �Ϸ��Ͽ����ϴ�.");
		} else if ("n".equalsIgnoreCase(msgString)) {
			System.out.println("���� ������ ����մϴ�.");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
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
			System.out.print("������ ���¹�ȣ�� �Է��ϼ��� :");
			msgInt = scan.nextInt();
			scan.nextLine();

			temp = findAccount(msgInt);
		} while (temp == null);

		do {
			System.out.println("���¹�ȣ : ");
			msgInt = scan.nextInt();
			scan.nextLine();
		} while (isValidateNum(msgInt));

		temp.setNum(msgInt);

		System.out.println("�����̸� : ");
		temp.setName(scan.nextLine());

		System.out.println("�����");
		temp.setBankName(scan.nextLine());

		System.out.println("������ȭ��ȣ");
		temp.setBankPhone(scan.nextLine());

	}

	private static Account findAccount(int msgInt2) {
		// find account
		for (Account account : list) {
			if (account.getNum() == msgInt) {
				return account;
			}
		}

		System.out.println("�����ϴ� ���¹�ȣ�� �Է��ϼ���.");
		return null;
	}

	private static void createAccount() {
		Account temp = new Account();

		System.out.println("���������� �Է��մϴ�");

		do {
			System.out.print("���¹�ȣ : ");
			msgInt = scan.nextInt();
			scan.nextLine();
		} while (isValidateNum(msgInt));
		temp.setNum(msgInt);

		System.out.print("�����̸� : ");
		temp.setName(scan.nextLine());

		System.out.print("����� : ");
		temp.setBankName(scan.nextLine());

		do {
			System.out.print("������ȭ��ȣ(���ڸ� �����ϰ� �Է��ϼ���) : ");
			msgString = scan.nextLine();
		} while (isValidatePhoneNum(msgString));
		temp.setBankPhone(msgString);

		list.add(temp);

		System.out.print("\n\n");
	}

	private static boolean isValidatePhoneNum(String phoneNum) {
		// ���ڸ� �Է��ϴ��� Ȯ��
		if (phoneNum.matches("[0-9]+")) {
			return false;
		}
		System.out.println("���ڸ� �Է����ּ���.");
		return true;
	}

	private static boolean isValidateNum(int num) {
		if (num > 0 & num < 1000) {
			return false;
		} else {
			System.out.println("���ڸ� ���ڸ� �Է��ϼ���.");
			return true;
		}
	}

	private static void printAccount() {
		System.out.println("------------- ���� ��� ----------------");
		System.out.println("��ȭ��ȣ	�����̸�	�����		������ȭ��ȣ	���� �ܾ�");

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
 * �̸� ��������
 * 
 * @author falbb
 *
 */
class NameAscCompare implements Comparator<Account> {

	/**
	 * ��������(ASC)
	 */
	@Override
	public int compare(Account arg0, Account arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
