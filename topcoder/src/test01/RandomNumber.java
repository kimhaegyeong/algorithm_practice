package test01;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.printf("%f\t", random(0.0009, 0.001));
			if ( i % 5 == 4) {
				System.out.print("\n");
			}
		}
	}

	public static double random(double min, double max) {

		//(int)(Math.random() * [RANGE]) + [BEGIN]
		// int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound;// 
		
		//double randomNum = (Math.random() * (max - min) + min);
		
		double randomNum = (Math.random() * (max - min) + min);
		double pow = Math.pow(-1, (int)(Math.random() * 10) + 1);
		double randomTotoal = (Math.random() * (max - min) + min) * Math.pow(-1, (int)(Math.random() * 10) + 1);

		return randomTotoal;
	}
}
