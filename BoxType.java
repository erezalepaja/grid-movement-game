package oop_project;

public enum BoxType {
	EMPTY(" "),
	PLAYER("P"),
	OBSTACLE("X"),
	TREASURE("T"); 
	
	private final String symbol;
	
	BoxType(String symbol) {
		this.symbol = symbol;
	}
	
	public String toString() {
		return symbol;
	}
}
