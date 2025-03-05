package oop_project;

public class Box {
	private BoxType type;
	
	public Box() {
		type = BoxType.EMPTY;
	}
	
	public void clear() {
		type = BoxType.EMPTY;
	}
	
	public boolean isEmpty() {
		return type == BoxType.EMPTY;
	}
	
	public void setObstacle() {
	    type = BoxType.OBSTACLE;
	}

	public void setPlayer() {
	    type = BoxType.PLAYER;
	}
	
	public boolean isObstacle() {
		return type == BoxType.OBSTACLE;
	}

	public void setTreasure() {
	    type = BoxType.TREASURE;
	}

	public BoxType getType() {
	    return type;
	}
	
	public String toString() {
		return type.toString();
	}
}