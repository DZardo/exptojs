package dzardo.exptojs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportJS {
	public static void OutputFile(String filename, String input) {
		try {
			String template = "OutputTemplate.txt";
			String content = BuildContent(template, input);
			
			File output = new File(filename);
			
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(content);
			
			bw.close();
			fw.close();
		}
		catch(IOException e) {
			System.out.println("ERROR WHILE WRITING ON FILE");
		}
	}
	
	public static String BuildContent(String filename, String input) {
		String template = InputUtils.LoadFile(filename);
		List<String> variables = Parser.GetVariables(input);
		List<String> constants = Constants.GetAllConstants();
		List<String> operators = Operators.GetAllOperators();
		String expression = Parser.ParseRPNToIN(input);
		String JSvariables = new String();
		String JSexpression = expression;
		String lineEnd = "," + System.lineSeparator();
		
		for(String v : variables) {
			JSexpression = JSexpression.replace(v, "input." + v);
			JSvariables += v + " : " + Parser.GetVariableValue(v, input) + lineEnd;
		}
		for(String c : constants) {
			if(c.equals(Constants.PI)) {
				JSexpression = JSexpression.replace(Constants.PI, "Math.PI");
			}
		}
		for(String o : operators) {
			if(o.equals(Operators.SIN) || o.equals(Operators.COS) || o.equals(Operators.TAN) || o.equals(Operators.LOG)) {
				JSexpression = JSexpression.replace(o, "Math." + o);
			}
		}
		
		if(!JSvariables.equals("")) {
			JSvariables = JSvariables.substring(0, JSvariables.lastIndexOf(lineEnd));
		}

		template = template.replace("$expression", JSexpression);
		template = template.replace("$variables", JSvariables);
		
		return template;
	}
}
