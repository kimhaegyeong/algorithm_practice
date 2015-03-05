package topcoder05_05;

public class main {

	public static void main(String[] args) {
		FriendScore test = new FriendScore();
		
		String[] friends01 =  {
				"NNN",
				"NNN",
				"NNN"
		};
		
		String[] friends02 =  {
				"NYY",
				"YNY",
				"YYN"
		};
		
		String[] friends03 =  {
				"NYNNN",
				"YNYNN",
				"NYNYN",
				"NNYNY",
				"NNNYN"
		};
	
		String[] friends04 =  {
				"NNNNYNNNNN",
				"NNNNYNYYNN",
				"NNNYYYNNNN",
				"NNYNNNNNNN",
				"YYYNNNNNNY",
				"NNYNNNNNYN",
				"NYNNNNNYNN",
				"NYNNNNYNNN",
				"NNNNNYNNNN",
				"NNNNYNNNNN"
		};
		
		test.highestScore(friends01);
		test.printResult();		

		test.highestScore(friends02);
		test.printResult();		

		test.highestScore(friends03);
		test.printResult();		

		test.highestScore(friends04);
		test.printResult();		
		}
}
