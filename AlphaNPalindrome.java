import java.util.Scanner;

class AlphaNPalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of test cases: ");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println("Enter the string: ");
			String str = sc.next();
			str = str + sc.nextLine();
			boolean res = checkPalin(str);
			if (res)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

	public static boolean checkPalin(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			} else if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			} else {
				if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				}
				i++;
				j--;
			}
		}
		return true;
	}
}