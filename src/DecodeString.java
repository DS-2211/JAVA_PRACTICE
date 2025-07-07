// leetcode 394

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[b]]"));
    }
        public static String decodeString(String s) {
            int num=0;
            StringBuilder ans = new StringBuilder();

            Stack<Integer> numstk = new Stack<>();
            Stack<StringBuilder> strstk = new Stack<>();
            for(char c : s.toCharArray()){

                if(Character.isDigit(c)){
                    num = (num*10) + (c - '0');
                }
                else if(c == '['){
                    numstk.push(num);
                    num=0;

                    strstk.push(ans);
                    ans = new StringBuilder();
                }
                else if(c == ']'){
                    String str = ans.toString();
                    ans = new StringBuilder(str.repeat(numstk.pop()));
                    ans = new StringBuilder(strstk.pop().append(ans));

                }
                else{
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
