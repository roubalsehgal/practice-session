import java.util.*;

class Anagram{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//input
		System.out.println("Enter string one: ");
		String a=sc.nextLine().toLowerCase();
		System.out.println("Enter string two: ");
		String b=sc.nextLine().toLowerCase();

		//check
		boolean res=checkAnagram(a, b);
		if(res){
			System.out.println("Anagrams");
		}else{
			System.out.println("Not Anagrams");
		}
		sc.close();
	}

	public static boolean checkAnagram(String a, String b){
		if(a.length()!=b.length()){
			return false;
		}
		ArrayList<Character> list1=new ArrayList<>();
		ArrayList<Character> list2=new ArrayList<>();

		for (Character c : a.toCharArray()) {
			list1.add(c);
		}
		for (Character c : b.toCharArray()) {
			list2.add(c);
		}

		Collections.sort(list1);
		Collections.sort(list2);

		if(list1.equals(list2)){
			return true;
		}else{
			return false;
		}
	}
}