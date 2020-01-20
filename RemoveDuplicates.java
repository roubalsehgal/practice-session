import java.util.Scanner;

public class RemoveDuplicates {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your input:- ");
		String input=sc.next();
		String res = removeDup(input);
		System.out.println("Output ==>"+res);
		sc.close();
	}
	public static String removeDup(String input) {
		if(input.length()<=1) {
			return input;
		}
		if(input.charAt(0)==input.charAt(1)) {
			int i=0;
			while(i<input.length()-1 && input.charAt(0)==input.charAt(i+1)) {
				i++;
			}
			return removeDup(input.substring(i+1));
		}
		else {
			return input.charAt(0)+removeDup(input.substring(1));
		}
	}
}
