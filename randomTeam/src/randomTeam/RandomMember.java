package randomTeam;

import java.util.Random;

public class RandomMember {

	public static void main(String args[]) {
		String[] member = {  "사과", "포도", "양파", "과자", "얼음", "팥빙수" };

		shuffleArray(member);
		for (int i = 0; i < member.length; i++) {
			System.out.print(member[i] + " ");
			
			if (i % 2 == 1) {
				System.out.print("\n");
			}
		}
		System.out.println();
	}

	// Implementing Fisher–Yates shuffle
	static void shuffleArray(String[] ar) {
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			String a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
}