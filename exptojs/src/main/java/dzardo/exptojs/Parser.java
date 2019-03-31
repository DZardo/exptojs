package dzardo.exptojs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	public static String ParseRPNToIN(String input) {
		String expression = GetExpression(input);
		String[] tokens = GetTokens(expression);
		Stack<String> stack = new Stack<String>();

		for(String token : tokens) {
			if(IsOperator(token)) {
				String i = stack.pop();
				if(token.equals(Operators.SIN) || token.equals(Operators.COS) || token.equals(Operators.TAN) || token.equals(Operators.LOG)) {
					stack.push("(" + token + " " + i + ")");
				}
				else {
					String k = stack.pop();
					stack.push("(" + k + " " + token + " " + i + ")");
				}
            }
			else {
				stack.push(token);
			}
        }
	
		return stack.pop();
	}
	
	public static String[] GetTokens(String expression) {
		String[] operands = expression.split(" ");
		
		return operands;
	}
	
	public static Boolean IsConstant(String token) {
		return Constants.GetAllConstants().contains(token);
	}
	
	public static Boolean IsOperator(String token) {
		return Operators.GetAllOperators().contains(token);
	}
	
	public static Boolean IsValidNumber(String token) {
		try {
			Double.parseDouble(token);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static String GetExpression(String input) {
		if(input.indexOf(System.lineSeparator()) != -1) {
			return input.substring(0, input.indexOf(System.lineSeparator()));
		}
		else {
			return input;
		}
	}
	
	public static List<String> GetVariables(String input) {
		List<String> matches = new ArrayList<String>();
		Matcher m = Pattern.compile("\\b[a-zA-Z]+\\b").matcher(GetExpression(input));
		
		while(m.find()) {
			matches.add(m.group());
		}

		matches.removeAll(Constants.GetAllConstants());
		matches.removeAll(Operators.GetAllOperators());
		
		return matches;
	}
	
	public static String GetVariableValue(String variable, String input) {
		String selector = variable + " = ";
		String value = input.substring(input.indexOf(selector) + selector.length());
		if(value.indexOf(System.lineSeparator()) != -1) {
			value = value.substring(0, value.indexOf(System.lineSeparator()));
		}
		
		return value;
	}
}
