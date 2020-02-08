import java.util.Scanner;

class TreeNode {
	char val;
	TreeNode left;
	TreeNode right;

	public TreeNode(char val) {
		this.val = val;
	}
}

public class TernaryToBinaryTree {
	static String str;

	public static TreeNode build(String s) {
		str = s;
		return buildIt();
	}

	public static TreeNode buildIt() {
		if (str == null || str.isEmpty())
			return null;

		char ch = str.charAt(0);
		TreeNode tn = new TreeNode(ch);

		if (str.length() > 1 && str.charAt(1) == '?') {
			str = str.substring(2);
			tn.left = build(str);
			tn.right = build(str);
		} else if (str.length() > 1 && str.charAt(1) == ':') {
			str = str.substring(2);
		}
		return tn;
	}

	public static void preOrder(TreeNode Node) {
		if (Node == null)
			return;
		System.out.print(Node.val + " ");
		preOrder(Node.left);
		preOrder(Node.right);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression: ");
		String s = sc.next();
		TreeNode treeNode = build(s);
		preOrder(treeNode);
		sc.close();
	}
}