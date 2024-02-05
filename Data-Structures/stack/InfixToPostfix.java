package stack;
import java.util.Stack;
public class InfixToPostfix {
	public static String infixToPostfix(String exp) {
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < exp.length(); i++){
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
                ans += ch;
            else if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && st.peek() != '(' && priority(ch) <= priority(st.peek())){
                    ans += st.pop();
                }
                st.push(ch);
            }

        }
        while(!st.isEmpty())
            ans += st.pop();
        return ans;

    }
    public static int priority(char ch){
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*' || ch == '/')
            return 2;
        else
            return 3;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String infixExpression = "3^(1+1)";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
        
        //Rules to convert infix to prefix 
        //need to reverse the infix expression 
        //then convert into string into postfix 
        //after that reverse the postfix expression will get prefix expression

	}

}
