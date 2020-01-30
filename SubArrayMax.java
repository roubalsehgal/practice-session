import java.util.Scanner;

class SubArrayMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the value of k: ");
		int k = sc.nextInt();
		if (k <= 0 || k > size) {
			System.out.println("INVALID INPUT!");
		} else {
			findMax(arr, k, 0);
		}
		sc.close();
	}

	public static void findMax(int arr[], int k, int si) {
		if ((si + k) > arr.length) {
			return;
		}
		int max = arr[si];
		for (int i = si; i < (si + k); i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.print(max + " ");
		findMax(arr, k, si + 1);
	}
}