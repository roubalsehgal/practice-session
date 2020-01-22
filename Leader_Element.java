import java.util.Scanner;

class Leader_Element{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array:- ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the array elements:- ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Leader Elements in the given array are:- ");
		printLeader(arr, n);
		sc.close();
	}
	public static void printLeader(int arr[], int n){
		for(int i=0;i<n-1;i++){
			int flag=0;
			for(int j=i+1;j<n;j++){
				if(arr[j]>arr[i]){
					flag=1;
					break;
				}
			}
			if(flag==0){
				System.out.print(arr[i]+" ");
			}
		}
		System.out.print(arr[n-1]);
	}
}