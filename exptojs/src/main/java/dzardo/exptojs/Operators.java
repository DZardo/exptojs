package dzardo.exptojs;

import java.util.ArrayList;
import java.util.List;

public class Operators {
	public static final String ADD = "+";
	public static final String SUB = "-";
	public static final String MLT = "*";
	public static final String DIV = "/";
	public static final String SIN = "sin";
	public static final String COS = "cos";
	public static final String TAN = "tan";
	public static final String LOG = "log10";
	
	public static List<String> GetAllOperators() {
		List<String> operators = new ArrayList<String>();
		
		//Operators
		operators.add(ADD);
		operators.add(SUB);
		operators.add(MLT);
		operators.add(DIV);
		operators.add(SIN);
		operators.add(COS);
		operators.add(TAN);
		operators.add(LOG);
		
		return operators;
	}
}
