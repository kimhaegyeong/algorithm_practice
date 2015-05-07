import java.util.ArrayList;


public class Account {
	private int num;
	private String name;
	private String bankName;
	private String bankPhone;
	private int balance;
	private ArrayList<History> Histroys;
	
	Account() {
		balance = 0;
		Histroys = new ArrayList<History>();
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankPhone() {
		return bankPhone;
	}
	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}	
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void plusBalance(int charge) {
		Histroys.add(new History(true));		
		this.balance += charge;
		
		System.out.println("입금이 완료되셨습니다.");
	}	
	
	public void minusBalance(int charge) {
		Histroys.add(new History(false));
		this.balance -= charge;
	
		System.out.println("출금이 완료되셨습니다.");
	}	
	
	public ArrayList<History> getHistroys() {
		return Histroys;
	}

	public void setHistroys(ArrayList<History> histroys) {
		Histroys = histroys;
	}

	@Override
	public String toString() {
		return "Account [num=" + num + ", name=" + name + ", bankName="
				+ bankName + ", bankPhone=" + bankPhone + ", deposit="
				+ balance + "]";
	}

	
	
}
