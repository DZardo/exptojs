package dzardo.exptojs;

public class InputVar {
	public String name;
	public Double value;
	
	public InputVar(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
}
