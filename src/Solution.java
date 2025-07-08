import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        Stack<Character> chrstk = new Stack<>();
        for(char c : s.toCharArray()){
            if(isValidChar(c)){
                if(c == '[' ||c == '(' ||c == '{') chrstk.push(c);
                else{
                    if(!chrstk.isEmpty()){
                        char ans = chrstk.pop();
                        if((c == ']' && ans != '[' || c == '}' && ans != '{' ||c == ')' && ans != '(')) return false;
                    }
                }
            }
        }
        return chrstk.isEmpty();
    }

    private boolean isValidChar(char c) {
        return (c == '[' ||c == ']' ||c == '{' ||c == '}' ||c == '(' ||c == ')');
    }
}