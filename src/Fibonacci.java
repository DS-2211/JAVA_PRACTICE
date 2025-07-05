import java.util.*;
public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        while(c<n) {
            System.out.print(" "+fib(c));
            c++;
        }
    }

//    static void Fib(int n){
//        System.out.print("0, 1");
//        int i=0,j=1,k=0,c=3;
//        while(c<n+1){
//            k=i+j;
//            System.out.print(", " + k);
//            i=j;
//            j=k;
//            c++;
//        }
//    }

    static int fib(int n) {
        if (n <= 1) return n; // base case
        return fib(n - 1) + fib(n - 2); // recursive case
    }
}
