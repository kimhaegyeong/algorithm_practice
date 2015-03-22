package test01;

import java.util.Random;

public class RandomNumber01 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.print(randInt(3, 10)+"\t");
			if ( i % 5 == 4) {
				System.out.print("\n");
			}
		}
	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
