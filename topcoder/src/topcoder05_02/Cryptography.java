package topcoder05_02;

public class Cryptography {
	long max;
	int[] numbers;
	
	public void encrypt (int[] numbers) {
		this.numbers = numbers;
		
		long max = 0;		
		long tempResult;
		for (int i = 0; i < numbers.length; i++) {
			tempResult = 1;
			
			for (int j = 0; j < numbers.length; j++) {
				tempResult *= numbers[j];
			}
			
			tempResult = tempResult / numbers[i] * (numbers[i] + 1);	
			
			if ( tempResult > max) {
				max  = tempResult;
			}
		}	
		
		this.max = max;
	}
	
	public void printResult () {
		System.out.print("numbers = {");
		for (int i = 0; i < numbers.length - 1; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println(numbers[numbers.length - 1] + "}");
		System.out.println("Return : " + max);
	}	
}
