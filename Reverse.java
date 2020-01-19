import java.util.*;

class Reverse{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of test-cases: ");
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			System.out.println("Enter the string: ");
			String input=sc.next();
			String res=reverseIt(input);
			System.out.print("Result==>"+res);
		}
		sc.close();
	}
	public static String reverseIt(String str){
		String s[]=str.split("\\.");
		String res="";
		for(int i=s.length-1;i>0;i--){
			res=res+s[i]+".";
		}
		res=res+s[0];
		return res;
	}
}