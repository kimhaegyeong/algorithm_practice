package topcoder05_04;

public class ThePalindrome {
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

		// i 증가되는 숫자
		// j 검색되는 기준
		outerloop: for (int i = 0; i < stringSplit.length; i++) {
			/*System.out.println("<< returns : " + (stringSplit.length + i)
					+ " >>");*/
			for (int j = 0; j < stringSplit.length; j++) {
				// System.out.println("--------  비교 대상  -----------");
				// System.out.print((i + j) + ", ");
				// System.out.println((stringSplit.length - j - 1));

				if ((i + j) >= (stringSplit.length - j - 1)) {
					setReturnResult((stringSplit.length + i));
					break outerloop;
				}
				if (!stringSplit[i + j].equals(stringSplit[stringSplit.length
						- j - 1])) {
					break;
				}
			}
		}
	}

	public void printResult() {
		System.out.println("s = \"" + s + "\"");
		System.out.println("Returns : " + getReturnResult());
	}
}
