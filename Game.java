package oop_project;

import java.util.Scanner;

public class Game {
    private Board board;
    private Display display;
    private Scanner scan;
    private int totalScore = 0;

    public Game() {
        scan = new Scanner(System.in);
        display = new Display();
        board = new Board(display);
        initializeBoard();
    }
    
    private void initializeBoard() {
        Position startPosition = setPlayerStartPosition();
        Position obstaclePosition = setObstaclePosition(startPosition);
        placeTreasure(startPosition, obstaclePosition);
        display.showMessage(board.toString());
    }

    private Position setPlayerStartPosition() {
        display.showMessage("Vendos poziten fillestare te lojtarit: ");
        Position startPosition = display.readPosition();
        board.placePlayer(startPosition);
        return startPosition;
    }

    private Position setObstaclePosition(Position startPosition) {
        display.showMessage("Vendos pengese (shtyp Enter per te vazhduar pa pengesa): ");
        Position obstaclePosition = display.readPosition();
        
        while (obstaclePosition != null && obstaclePosition.equals(startPosition)) {
            display.showMessage("Pengesa nuk mund te vendoset mbi lojtarin. Vendos pengese tjeter ose shtyp Enter: ");
            obstaclePosition = display.readPosition();
        }
        
        if (obstaclePosition != null) {
            board.getBox(obstaclePosition).setObstacle();
        }
        return obstaclePosition;
    }

    private void placeTreasure(Position startPosition, Position obstaclePosition) {
        display.showMessage("Vendos numrin e thesareve qe deshiron te kete tabela (shtyp 0 per te vazhduar pa thesare): ");
        int treasureNr = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < treasureNr; i++) {
            Position treasurePosition = getValidTreasurePosition(i + 1, startPosition, obstaclePosition);
            board.getBox(treasurePosition).setTreasure();
        }
    }
    
    private Position getValidTreasurePosition(int treasureNumber, Position startPosition, Position obstaclePosition) {
        display.showMessage("Vendos poziten e thesarit " + treasureNumber + ": ");
        Position treasurePosition = display.readPosition();

        while (treasurePosition != null && (treasurePosition.equals(startPosition) || treasurePosition.equals(obstaclePosition))) {
            display.showMessage("Thesari nuk mund te vendoset mbi lojtarin ose pengesen. Vendos thesarin diku tjetër: ");
            treasurePosition = display.readPosition();
        }
        return treasurePosition;
    }

    public void addScore(int treasurePoints) {
    	totalScore += treasurePoints;
    }

    public void play() {
        while (true) {
            display.showMessage("Shtyp W, A, S, D per te levizur (Q per dalje):");
            char input = scan.next().toUpperCase().charAt(0);
            
            if(input == 'Q') {
            	display.showMessage("Loja perfundoi. Totali i pikeve: " + totalScore);
                break;
            }
            Position newPosition = movePlayer(input);
            board.updatePosition(newPosition);
            
            if (board.hasFoundTreasure()) {
            	addScore(5);
            	board.resetFoundTreasure();
            }
            display.showMessage(board.toString());
        }
    }

    private Position movePlayer(char direction) {
    	int newX = board.getCurrentPosition().getX();
    	int newY = board.getCurrentPosition().getY();
    	switch (direction) {
        case 'W':
            newX--;
            break;
        case 'S':
            newX++;
            break;
        case 'A':
            newY--;
            break;
        case 'D':
            newY++;
            break;
        default:
        	display.showMessage("Komande e gabuar!\n");
            return board.getCurrentPosition();
    	}
    	 Position newPosition = new Position(newX, newY);
    	 return newPosition;
    }
}
