import java.util.Scanner;
import java.util.Arrays;

class Pythagorean_triplet{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int j=0;j<n;j++){
				arr[j]=sc.nextInt();
			}
			boolean res=checkTriplets(arr, n);
			if(res)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
	public static boolean checkTriplets(int arr[], int n){
		Arrays.sort(arr);
		boolean res=false;
		for(int i=0;i<n;i++){
			int a=arr[i]*arr[i];
			for(int j=0;j<n-1;j++) {
				if((arr[j]*arr[j])+(arr[j+1]*arr[j+1])==a) {
					res=true;
				}
			}
		}
		return res;
	}
}