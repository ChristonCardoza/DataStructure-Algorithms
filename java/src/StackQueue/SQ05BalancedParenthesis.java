package StackQueue;

import java.util.Map;
import java.util.Stack;

public class SQ05BalancedParenthesis {

    public static void main(String[] args) {
        String s1 = "()[{}[]]";
        System.out.println(s1 + ": " + isParenthesisBalanced(s1));

        String s2 = "()[{}(]]";
        System.out.println(s2 + ": " + isParenthesisBalanced(s2));

    }

    public static boolean isParenthesisBalanced(String str) {

        Stack<Character> st = new Stack<>();
        Map<Character, Character> counterPart = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );

        for( int i=0; i< str.length() ; i++) {

            char ch = str.charAt(i);

            if( ch == '(' ||ch == '[' || ch == '{') {
                st.push(ch);
            } else {

                if(st.isEmpty()) return false;

                char parChar = st.pop();
                if(ch != counterPart.get(parChar)) return false;
            }
        }

        return st.isEmpty();
    }
}
