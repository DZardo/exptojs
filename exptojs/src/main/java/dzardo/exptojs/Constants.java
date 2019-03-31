package dzardo.exptojs;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String PI = "PI";
	
	public static List<String> GetAllConstants() {
		List<String> constants = new ArrayList<String>();
		
		//Constants
		constants.add(PI);
		
		return constants;
	}
}
