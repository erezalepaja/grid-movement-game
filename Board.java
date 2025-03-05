package oop_project;

import java.util.Scanner;

public class Board {
    private Scanner scan;
    private Box[][] boxes;
    private Display display;
    private Position currentPosition;
    public static int rows;
    public static int cols;
    private boolean foundTreasure = false;

    public Board(Display display) {
    	this.display = display;
    	scan = new Scanner(System.in);
    	display.showMessage("Inicializo tabelen: ");
        
        checkBoardInput();

        boxes = new Box[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boxes[row][col] = new Box();
            }
        }
    }
    
    private void checkBoardInput() {
        while (true) {
            String hyrja = scan.nextLine().trim();
            String [] parts = hyrja.split(" ");
            
            if(parts.length == 2) {
                try {
                    rows = Integer.parseInt(parts[0]);
                    cols = Integer.parseInt(parts[1]);
                    
                    if(rows > 0 && cols > 0) {
                        break;
                    } else {
                        display.showMessage("Numrat duhet te jene me te medhenj se 0: ");
                    }
                } catch (NumberFormatException e) {
                	display.showMessage("Vendos vetem dy numra! Provo perseri: ");
                }
            } else {
            	display.showMessage("Vendos dy numra te ndare me hapesire! Provo perseri: ");
            }
        }
    }

    public void placePlayer(Position position) {
        if (!areInsideBounds(position.getX(), position.getY())) {
        	display.showMessage("Pozita jashte kufijve te tabeles!");
            return;
        }
//        if(!getBox(position).isEmpty()) {
//        	display.showMessage("Pozita nuk eshte e zbrazet!");
//        	return;
//        }
        getBox(position).setPlayer();
        this.currentPosition = position;
        display.showMessage("Tabela " + rows + "x" + cols + " u ndertua dhe lojtari u vendos ne poziten " + (position.getX() + 1) + "x" + (position.getY() + 1) + "\n");
    }

    public Box getBox(Position position) {
        return boxes[position.getX()][position.getY()];
    }
    
    public Box getBox(int x, int y) {
        return boxes[x][y];
    }
    
    public Position getCurrentPosition() {
    	return currentPosition;
    }

    public void updatePosition(Position newPosition) {
        if(newPosition.getX() < 0 || newPosition.getX() >= rows || newPosition.getY() < 0 || newPosition.getY() >= cols) {
        	display.showMessage("Levizje jashte kufijve te tabeles!\n");
            return;
        }
        Box newBox = getBox(newPosition);
        
        if(newBox.getType() == BoxType.OBSTACLE) {
        	display.showMessage("Ka pengese ne kete pozite!\n");
        	return;
        }
        
        if(newBox.getType() == BoxType.TREASURE) {
        	display.showMessage("Sapo gjetet nje thesar! +5 pike.\n");
        	foundTreasure = true;
        }
        
        getBox(currentPosition).clear();
        newBox.setPlayer();
        this.currentPosition = newPosition;
    }
    
    public boolean hasFoundTreasure() {
        return foundTreasure;
    }
    
    public void resetFoundTreasure() {
        foundTreasure = false;
    }

    public static boolean areInsideBounds(int xPosition, int yPosition) {
    	return xPosition >= 0 && xPosition < rows && yPosition >= 0 && yPosition < cols;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("-".repeat((4 * cols) + 1));
            sb.append("\n");
            for (int j = 0; j < cols; j++) {
                sb.append("| ").append(getBox(i, j).toString());
                sb.append(" ");
            }
            sb.append("|\n");
        }
        sb.append("-".repeat((4 * cols) + 1));
        sb.append("\n");
        return sb.toString();
    }
}
