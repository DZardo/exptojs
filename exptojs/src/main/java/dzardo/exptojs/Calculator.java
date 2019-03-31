package dzardo.exptojs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
	public static Double Calculate(final String input) {
		String expression = Parser.GetExpression(input);
		List<String> variables = Parser.GetVariables(input);
		final String[] tokens = Parser.GetTokens(expression);
		final Deque<Double> stack = new LinkedList<>();
        
        for (final String token : tokens) {
        	if(Parser.IsOperator(token)) {
        		Operate(token, stack);
        	}
        	else {
        		Double value;
        		if(variables.contains(token)) {
        			value = ParseDouble(Parser.GetVariableValue(token, input));
        		}
        		else {
        			if(Constants.GetAllConstants().contains(token)) {
            			value = GetConstantValue(token);
            		}
        			else {
        				value = ParseDouble(token);
        			}
        		}
        		
        		if(value != null) {
        			stack.push(value);
        		}
        	}
        }
        
        return stack.pop(); 
    }

    private static void Operate(final String operator, final Deque<Double> stack) {
        switch(operator) {
	        case Operators.ADD:
	            stack.push(stack.pop() + stack.pop());
	            break;
	        case Operators.SUB:
	            final Double subtrahend = stack.pop();
	            stack.push(stack.pop() - subtrahend);
	            break;
	        case Operators.MLT:
	            stack.push(stack.pop() * stack.pop());
	            break;
	        case Operators.DIV:
	            final Double denominator = stack.pop();
	            stack.push(stack.pop() / denominator);
	            break;
	        case Operators.SIN:
	        	stack.push(Math.sin(stack.pop()));
	        	break;
	        case Operators.COS:
	        	stack.push(Math.cos(stack.pop()));
	        	break;
	        case Operators.TAN:
	        	stack.push(Math.tan(stack.pop()));
	        	break;
	        case Operators.LOG:
	        	stack.push(Math.log10(stack.pop()));
	        	break;
	        default:
	            throw new IllegalStateException("INVALID OPERATOR: " + operator);
        }
    }
    
    private static Double GetConstantValue(final String constant) {
    	switch(constant) {
    		case Constants.PI:
    			return Math.PI;
    		default:
    			throw new IllegalStateException("INVALID CONSTANT: " + constant);
    	}
    }
    
    private static Double ParseDouble(final String value) {
    	try {
    		return Double.parseDouble(value);
		}
		catch(NumberFormatException e) {
			return null;
		}
    }
}
