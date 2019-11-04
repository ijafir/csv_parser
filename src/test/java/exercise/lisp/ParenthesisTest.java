package exercise.lisp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParenthesisTest
{

    @Test
    public void isValidParenthesis() throws Exception {
        assertEquals(true, Parenthesis.isValidString("((()))"));
        assertEquals(true, Parenthesis.isValidString("(((abc)))"));
        assertEquals(false, Parenthesis.isValidString("((())"));
        assertEquals(false, Parenthesis.isValidString("((()"));
    }
}
