import java.util.*;

public class BracketChecker {

    static Boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if( ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;

                char open = stack.pop();
                if(!isMatchingPair(open,ch)) return false;
            }
        }
        return stack.isEmpty();
    }
    static boolean isMatchingPair(char open,char close){
        return (open=='[' && close ==']') || (open=='{' && close =='}') || (open=='(' && close ==')');
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isBalanced(s));
    }
}
