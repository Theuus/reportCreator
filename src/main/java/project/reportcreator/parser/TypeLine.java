package project.reportcreator.parser;

public enum TypeLine {

	SALESMAN("001", new ParserSalesman()),
	CLIENT("002", new ParserClient()),	
	SALE("003", new ParserSale());

	private String identificador;
	
	private Parse type;

	private TypeLine(String identificador, Parse type) {
		this.identificador = identificador;
		this.type = type;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public Parse getType() {
		return type;
	}
	
	public static TypeLine getTypeLine(String string) {
		for(TypeLine typeLine : values()) {
			if(typeLine.getIdentificador().equals(string)) {
				return typeLine;
			}
		}
		return null;
	}
}
