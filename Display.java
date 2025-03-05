package oop_project;

import java.util.Scanner;

public class Display {
    private Scanner scan;

    public Display() {
        scan = new Scanner(System.in);
    }

    public void showMessage(String s) {
        System.out.print(s);
    }

    public Position readPosition() {
        String hyrja = scan.nextLine().trim();
        
        if(hyrja.isEmpty()) {
            return null;
        }

        String [] parts = hyrja.split(" ");
        if (parts.length != 2) {
            showMessage("Hyrje jo e duhur, vendos vetem dy numra te plote: ");
            return readPosition();
        }

        try {
            int x = Integer.parseInt(parts[0]);
            x--;
            int y = Integer.parseInt(parts[1]);
            y--;
            
            if (!Board.areInsideBounds(x, y)) {
                showMessage("Pozita jashte kufijve te tabeles. Vendos nje pozite valide: ");
                return readPosition();
            }
            return new Position(x, y);
        } catch (NumberFormatException e) {
            showMessage("Hyrje jo e duhur, vendos dy numra: ");
            return readPosition();
        }
    }
}
