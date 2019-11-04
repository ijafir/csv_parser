package exercise.lisp;

import java.util.HashMap;
import java.util.Stack;

public class Parenthesis
{
    public static void main(String[] args){
        System.out.println(isValidString("((()))"));
    }
    public static boolean isValidString(String s)
    {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char current = s.charAt(i);

            if(map.keySet().contains(current)){
                stack.push(current);
            }
            else if (map.values().contains(current)){
                if(!stack.empty() && map.get(stack.peek())== current){
                    stack.pop();
                }else
                {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
