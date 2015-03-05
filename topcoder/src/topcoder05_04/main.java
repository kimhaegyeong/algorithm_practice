package topcoder05_04;

public class main {

	public static void main(String[] args) {
		ThePalindrome test = new ThePalindrome();
		test.find("abab");
		test.printResult();
		
		test.find("abacaba");
		test.printResult();
		
		test.find("qwerty");
		test.printResult();
		
		test.find("abdfhdyrbdbsdfghjkllkjhgfds");
		test.printResult();
		}
}
