package oop_project;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
 
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj == null) {
        	return false;
        }
        
        if(obj instanceof Position ) {
            Position that = (Position) obj;
            return this.x == that.x && this.y == that.y;
        }
        return false;
    }
}
