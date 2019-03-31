package dzardo.exptojs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputUtils {
	public static String LoadFile(String filename) {
		String input = new String();
		String line = new String();
		
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				input += line + System.lineSeparator();
			}
			
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		}
		catch(IOException e) {
			System.out.println("ERROR WHILE READING THE FILE");
		}
		
		return input;
	}
	
//	public static String UserInput() {
//		String input = new String();
//		List<String> variables = new ArrayList<String>();
//		Scanner reader = new Scanner(System.in);
//		
//		System.out.println("INPUT THE EXPRESSION");
//		input += InputExpression(reader);
//		
//		variables = Parser.GetVariables(input);
//		
//		for(String v : variables) {
//			System.out.println("INPUT VALUE FOR " + v);
//			String value = InputValue(reader);
//			if(Parser.IsValidNumber(value)) {
//				input += System.lineSeparator() + v + " = " + value;
//			}
//			else {
//				System.out.println("INVALID INPUT");
//				throw new NumberFormatException();
//			}
//		}
//		
//		reader.close();
//		
//		System.out.println("INPUT: \n" + input);
//		
//		return input;
//	}
//	
//	public static String InputExpression(Scanner reader) {
//		String expression = new String();
//		
//		expression += reader.nextLine();
//		
//		return expression;
//	}
//	
//	public static String InputValue(Scanner reader) {
//		String value = new String();
//		
//		value += reader.nextLine();
//		
//		return value;
//	}
}
