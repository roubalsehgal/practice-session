import java.util.ArrayList;
import java.util.Scanner;

public class GetPath {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of test-cases: ");
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			System.out.println("\nEnter the starting index coordinates: ");
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int end_x = 0;
			int end_y = 0;

			//To print full path
			//System.out.print(getMazePath(start_x, start_y, end_x, end_y));
			ArrayList<String> res=getPath(start_x, start_y, end_x, end_y);
			System.out.print("Total ways: "+res.size());
		}
		sc.close();
	}

	public static ArrayList<String> getPath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (cr < er || cc < ec) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<String>();
		ArrayList<String> rrh = getPath(cr, cc - 1, er, ec);
		for (String rrhs : rrh) {
			mr.add("H" + rrhs);
		}
		ArrayList<String> rrv = getPath(cr - 1, cc, er, ec);
		for (String rrhv : rrv) {
			mr.add("V" + rrhv);
		}
		return mr;
	}
}
