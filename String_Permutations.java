import java.util.ArrayList;
import java.util.Scanner;

public class String_Permutations {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string:- ");
		String str=sc.next();
		System.out.print(getPermutations(str));
		sc.close();
	}
	public static ArrayList<String> getPermutations(String str){
		if(str.length()==0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> rr=getPermutations(ros);
		ArrayList<String> mr=new ArrayList<String>();
		for(String rrs : rr) {
			for(int i=0;i<=rrs.length();i++) {
				String value=rrs.substring(0, i)+ch+rrs.substring(i);
				mr.add(value);
			}
		}
		return mr;
	}
}
