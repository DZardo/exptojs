package dzardo.exptojs;

import java.util.List;

public class Input {
	public String expressionStr;
	public String variablesStr;
	public List<InputVar> variables;
	
	public Input(String expressionStr, String variablesStr, List<InputVar> variables) {
		this.expressionStr = expressionStr;
		this.variablesStr = variablesStr;
		this.variables = variables;
	}

	public String getExpressionStr() {
		return expressionStr;
	}

	public void setExpressionStr(String expressionStr) {
		this.expressionStr = expressionStr;
	}

	public String getVariablesStr() {
		return variablesStr;
	}

	public void setVariablesStr(String variablesStr) {
		this.variablesStr = variablesStr;
	}

	public List<InputVar> getVariables() {
		return variables;
	}

	public void setVariables(List<InputVar> variables) {
		this.variables = variables;
	}
}
