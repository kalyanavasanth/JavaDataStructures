/**
 * @author SESA366034
 * 
 *
 */
public class Parenthesis {
	/**
	 * @param input
	 *            inputs the parenthesis string to be processed
	 * @return returns true if the parenthesis is balanced. Else it returns
	 *         false.
	 */
	public boolean process(String input) {
		String parenthesis_string = input;
		char[] char_array = parenthesis_string.toCharArray();
		Stack<Character> st1 = new Stack<Character>();
		for (int count = 0; count < char_array.length; ++count) {
			if (st1.numElements() == 0) { // push element to stack if stack is empty
				st1.push(char_array[count]);
			} else { // if stack is not empty
				if (char_array[count] == ')' && st1.getTop() == '(') {
					/* if matching close bracket is found, pop the top element */
					st1.pop();
				}
				// In all other cases push to stack
				else if (char_array[count] == ')' && st1.getTop() == ')') {
					st1.push(char_array[count]);
				} else {
					st1.push(char_array[count]);
				}
			}
		}
		if (st1.numElements() == 0) {
			return true;
		} else {
			return false;
		}
	}
}