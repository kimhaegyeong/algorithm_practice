package topcoder05_04;

public class ThePalindrome01 {
	String s;
	int returnResult;

	public void setS(String s) {
		this.s = s;
	}

	public int getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(int returnResult) {
		this.returnResult = returnResult;
	}

	public void find(String s) {
		setS(s);

		String[] stringSplit = s.split("(?!^)");
		boolean flag = true;
		int addLength = 0;
		
		while (flag) {
			System.out.println("<< returns : " + (stringSplit.length + addLength) + " >>");
			
			for (int i = 0; i < (stringSplit.length + addLength) / 2; i++) {
				System.out.println("--------  비교 대상  -----------");
				System.out.print((addLength + i) + ", ");
				System.out.println((stringSplit.length + addLength) -  (addLength + i) - 1);
				
				if ((addLength + i) >= ((stringSplit.length + addLength) -  (addLength + i) - 1)) {
					flag = false;
					break;
				}
				
				if (!stringSplit[addLength + i].equals(stringSplit[(stringSplit.length + addLength) -  (addLength + i) - 1])	) {
					flag = true;
					addLength++;
					break;
				}					
				
	 			flag = false;
			}			
		}
		
		setReturnResult(stringSplit.length + addLength);
	}

	public void printResult() {
		System.out.println("s = \"" + s + "\"");
		System.out.println("Returns : " + getReturnResult());
	}
}
