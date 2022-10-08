package DS.stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean valid(String parentheses) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                characterStack.push(c);
            } else if (c == ')') {
                Character pop = characterStack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (c == ']') {
                Character pop = characterStack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (c == '}') {
                Character pop = characterStack.pop();
                if (pop != '{') {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static void main(String[] args) {
        String string = "[]{{([])}}";
        System.out.println(valid(string));
    }
}
