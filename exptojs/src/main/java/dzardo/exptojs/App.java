package dzardo.exptojs;

public class App 
{
    public static void main( String[] args )
    {
    	String inputFilename = "Input.txt";
    	String outputFilename = "Output.js";
        String input = InputUtils.LoadFile(inputFilename);
        
        System.out.println("RESULT: " + Calculator.Calculate(input));
        System.out.println("INPUT FORMATTED AS INFIX NOTATION: " + Parser.ParseRPNToIN(input));
        
        ExportJS.OutputFile(outputFilename, input);
    }
}
