package dzardo.exptojs;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ExpToJSTest {
	
	@Test
	void SuccessCalculatorTest() {
		String input = "a x * log10 PI * cos\r\n" + 
				"a = 2\r\n" + 
				"x = 50";
		Double expected = 1.0;
		Double actual = Calculator.Calculate(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Questo test fallisce perché non vengono fornite in input le valorizzazioni alle variabili
	void FailCalculatorTest1() {
		String input = "a x * log10 PI * cos\r\n";
		Double expected = 1.0;
		Double actual = Calculator.Calculate(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Questo test fallisce perché Math.PI è un'approssimazione a precisione Double
	//Il risultato è un numero minuscolo (1.2246467991473532E-16) ma non 0
	void FailCalculatorTest2() {
		String input = "PI sin";
		Double expected = 0.0;
		Double actual = Calculator.Calculate(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void SuccessParserTest() {
		String input = "a x * log10 PI * cos\r\n" + 
				"a = 2\r\n" + 
				"x = 50";
		String expected = "(cos ((log10 (a * x)) * PI))";
		String actual = Parser.ParseRPNToIN(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Questo test fallisce perché la espressione in input non è scritta correttamente (a causa del "/" finale)
	//corrrentemente non c'è un controllo sull'input che verifichi che l'espressione sia scritta correttamente
	void FailParserTest() {
		String input = "a x * log10 PI * cos /";
		String expected = "(cos ((log10 (a * x)) * PI))";
		String actual = Parser.ParseRPNToIN(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void SuccessEportJSTest() {
		String input = "a x * log10 PI * cos\r\n" + 
				"a = 2\r\n" + 
				"x = 50";
		String template = "OutputTemplate.txt";
		String expected = "var expression = function(variables) {\r\n" + 
				"	return (Math.cos ((Math.log10 (input.a * input.x)) * Math.PI));\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"var variables = {\r\n" + 
				"	a : 2,\r\n" + 
				"x : 50\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"console.log(expression(input));\r\n" + 
				"";
		String actual = ExportJS.BuildContent(template, input);
		
		assertEquals(expected, actual);
	}
}
