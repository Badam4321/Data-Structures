package stack;
import java.util.*;

public class EvaluationOfPostfixExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postfix = "4 13 5 / +";
		int res = EvaluationOfPostfixExpression(postfix);
		System.out.println(res);
		

	}

	private static int EvaluationOfPostfixExpression(String postfix) {
		// TODO Auto-generated method stub
		Deque<Integer> st = new ArrayDeque<>();
		for(int i = 0 ; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				st.push(ch- '0');
			}
			else {
				if(ch == '+') {
					int op1 = st.pop();
					int op2 = st.pop();
					st.push(op2 + op1);
				}
				else if(ch == '-') {
					int op1 = st.pop();
					int op2 = st.pop();
					st.push(op2 - op1);
				}
				else if(ch == '*') {
					int op1 = st.pop();
					int op2 = st.pop();
					st.push(op2 * op1);
				}
				else if (ch == '/') {
					int op1 = st.pop();
					int op2 = st.pop();
					st.push(op2 / op1);	
				}
			}
		}
		return st.peek();
	}

}
