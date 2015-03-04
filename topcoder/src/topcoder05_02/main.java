package topcoder05_02;

public class main {

	public static void main(String[] args) {
		Cryptography test01 = new Cryptography();
		
		int[] numbers01 = {1, 2, 3};		
		test01.encrypt(numbers01);
		test01.printResult();
		
		int[] numbers02 = {1, 3, 2, 1, 1, 3};		
		test01.encrypt(numbers02);
		test01.printResult();
		
		int[] numbers03 = {1000, 999, 998, 997, 996, 995};		
		test01.encrypt(numbers03);
		test01.printResult();
		
		int[] numbers04 = {1, 1, 1, 1};		
		test01.encrypt(numbers04);
		test01.printResult();
	}

}
