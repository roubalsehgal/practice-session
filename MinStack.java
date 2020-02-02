import java.util.Scanner;

class Elem{
	int value;
	int min;
	Elem next;
	public Elem(int val, int min){
		this.value=val;
		this.min=min;
	}
}

class MinStack{
	public Elem top;
	public void push(int x){
		if(top==null){
			top=new Elem(x, x);
			return;
		}else{
			Elem e=new Elem(x, Math.min(x, top.min));
			e.next=top;
			top=e;
		}
	}

	public void pop(){
		if(top==null){
			return;
		}else{
			Elem temp=top.next;
			top.next=null;
			top=temp;
		}
	}

	public int top(){
		if(top==null){
			return -1;
		}else{
			return top.value;
		}
	}

	public int getMin(){
		if(top==null){
			return -1;
		}else{
			return top.min;
		}
	}

	public static void main(String[] args) {
		MinStack stack=new MinStack();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of stack: ");
		int size=sc.nextInt();
		System.out.println("Enter the elements: ");
		for(int i=0;i<size;i++){
			int data=sc.nextInt();
			stack.push(data);
		}
		int min=stack.getMin();
		System.out.print(min);
		sc.close();
	}
}