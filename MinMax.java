import java.util.Scanner;

class MinMax{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size: ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		printMinMax(arr);
		sc.close();
	}

	//Print Min-Max
	public static void printMinMax(int arr[]){
		int n=arr.length;		
		sortIt(arr, 0, n-1);
		for(int i=0;i<n;i++){
			if(i!=(n-1)){
				System.out.print(arr[i]+" "+arr[n-1]+" ");
			}else{
				System.out.print(arr[i]);
			}
			n--;
		}
	}

	//Merge Sort
	public static void sortIt(int arr[], int l, int r) {
		if(l<r) {
			int mid=(l+r)/2;
			
			sortIt(arr, l, mid);
			sortIt(arr, mid+1, r);
			
			merge(arr, l, mid, r);
		}
	}
	public static void merge(int arr[], int l, int m, int r) {
		int n1=m-l+1;
		int n2=r-m;
		
		int left[]=new int[n1];
		int right[]=new int[n2];
		
		for(int i=0;i<n1;i++) {
			left[i]=arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			right[j]=arr[m+1+j];
		}
		
		int a=0, b=0, c=l;
		while(a<n1 && b<n2) {
			if(left[a]<=right[b]) {
				arr[c++]=left[a++];
			}
			else {
				arr[c++]=right[b++];
			}
		}
		while(a<n1) {
			arr[c++]=left[a++];
		}
		while(b<n2) {
			arr[c++]=right[b++];
		}
	}
}