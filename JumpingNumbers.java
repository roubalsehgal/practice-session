import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class JumpingNumbers {

    static ArrayList<Integer> al = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no: ");
        int num = sc.nextInt();
        printNum(num);
        Collections.sort(al);
        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void bfs(int x, int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            num = q.peek();
            q.poll();
            if (num <= x) {
                al.add(num);
                int last_digit = num % 10;

                if (last_digit == 0) {
                    q.add((num * 10) + (last_digit + 1));
                }

                else if (last_digit == 9) {
                    q.add((num * 10) + (last_digit - 1));
                }

                else {
                    q.add((num * 10) + (last_digit - 1));
                    q.add((num * 10) + (last_digit + 1));
                }
            }
        }
    }

    public static void printNum(int x) {
        al.add(0);
        for (int i = 1; i <= 9 && i <= x; i++) {
            bfs(x, i);
        }
    }

}