import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class String_Permutations {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of testcases:- ");
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			System.out.println("\nEnter the string:- ");
			String str=sc.next();
			if(str.length()<=0 || str.length()>5){
				System.out.print("INVALID STRING!!!");
			}else{
				ArrayList<String> res=getPermutations(str);
				Collections.sort(res);
				display(res);
			}
		}
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
	public static void display(ArrayList<String> res){
		for(int j=0;j<res.size();j++){
			System.out.print(res.get(j)+" ");
		}
	}
}
