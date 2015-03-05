package topcoder05_05;

public class FriendScore {
	String[] friends;
	int returnResult;

	public String[] getFriends() {
		return friends;
	}

	public void setFriends(String[] friends) {
		this.friends = friends;
	}

	public int getReturnResult() {
		return returnResult;
	}

	public void setReturnResult(int returnResult) {
		this.returnResult = returnResult;
	}

	public void printResult() {
		System.out.println("-------------------------------");
		System.out.println("friends = { ");

		for (int i = 0; i < friends.length - 1; i++) {
			System.out.println("\"" + friends[i] + "\",");
		}
		System.out.println("\"" + friends[friends.length - 1] + "\" }");
				
		System.out.println("Returns : " + getReturnResult());
	}

	public void highestScore(String[] friends) {
		setFriends(friends);

		// 이차원 배열 사용
		// 글자 쪼개기
		String[][] splitChars = new String[friends.length][];

		for (int i = 0; i < friends.length; i++) {
			splitChars[i] =  friends[i].split("(?!^)");
		}
		
		//printSplitCharTable(splitChars);
		
		int[] count = new int[friends.length];
		int sum = 0;
		int max = 0;
		
		for (int i = 0; i < friends.length; i++) {
			for (int j = 0; j < friends[i].length(); j++) {		
				// 직접 친구
				if (splitChars[i][j].equals("Y")) {
					count[i]++;
					
					// 간접 친구
					for (int k = 0; k < friends[i].length(); k++) {
						if (splitChars[j][k].equals("Y") && k != i ) {
							count[i]++;
						}
					}
				}				
			}
			
			//System.out.println(count[i]);
			max = Math.max(max, count[i]);
		}
		
		setReturnResult(max);
	}
	
	public void printSplitCharTable (String[][] splitChars) {
		for (int i = 0; i < friends.length; i++) {
			splitChars[i] =  friends[i].split("(?!^)");
			
			if (i == 0) {
				System.out.print("\t| ");
				for (int j = 0; j < splitChars[0].length; j++) {
					System.out.print(j + "\t| ");
				}
				System.out.print("\n");
			}
			System.out.print(i + "\t| ");

			for (int j = 0; j < friends[i].length(); j++) {		
				System.out.print(splitChars[i][j] + "\t| ");
			}
			
			System.out.print("\n");
		}
	}
}
