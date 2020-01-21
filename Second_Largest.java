import java.util.Scanner;

class Second_Largest{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array:- ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		findSecondL(arr, n);
		sc.close();
	}
	public static void findSecondL(int arr[], int n){
		//Largest
		int max1=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]>max1){
				max1=arr[i];
			}
		}
		System.out.println("Largest - "+max1);

		//Second Largest
		int max2=Integer.MIN_VALUE;
		for(int j=0;j<n;j++){
			if(arr[j]>max2 && arr[j]!=max1){
				max2=arr[j];
			}
		}
		System.out.println("Second - "+max2);
	}
}