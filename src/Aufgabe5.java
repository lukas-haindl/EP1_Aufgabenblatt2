import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
    Aufgabe 5) Kreativaufgabe
*/

public class Aufgabe5 {

    public static Color determineColor(){
        Random rand = new Random();
        int randNumber = rand.nextInt(100);
        if (randNumber < 25) {
            return Color.BLUE;
        }
        else if (randNumber < 50) {
            return Color.RED;
        }
        else if (randNumber < 75) {
            return Color.GREEN;
        }
        else{
            return Color.YELLOW;
        }
    }

    public static int spinWheel(){
        int max = 3;
        int width = 1920;
        int height = 1080;
        CodeDraw myDrawObj = new CodeDraw(width, height);
        myDrawObj.setColor(Palette.RED);
        myDrawObj.drawText(width /2.0, 10, "SLOT MACHINE!");
        int ws = 600;
        double squareSize = ws / (double)max;
        myDrawObj.setColor(Palette.SANDY_BROWN);
        myDrawObj.fillSquare(width / 2.0 - (ws + squareSize) / 2.0, height / 2.0 - (ws + squareSize) / 2.0, ws + squareSize);
        myDrawObj.setLineWidth(5);
        double x = width / 2.0 - ws / 2.0;
        double y = height / 2.0 - ws / 2.0;

        Color[][] field = new Color[max][max];

        for (int col = 0; col < max; col++) {
            for (int row = 0; row < max; row++) {
                myDrawObj.setColor(determineColor());
                field[col][row] = myDrawObj.getColor();
                myDrawObj.fillSquare(x, y, squareSize);
                myDrawObj.setColor(Color.BLACK);
                myDrawObj.drawSquare(x, y, squareSize);
                y += squareSize;
            }
            myDrawObj.show(1000);
            x += squareSize;
            y = height / 2.0 - ws / 2.0;
        }

        boolean sameRow = true;
        int countSameRow = 0;
        Color tmp;
        for (int row = 0; row < max; row++) {
            tmp = field[0][row];
            for (int col = 1; col < max; col++) {
                if (field[col][row] != tmp) {
                    sameRow = false;
                    break;
                }
            }
            if (sameRow) {
                countSameRow++;
            }
            sameRow = true;
        }
        myDrawObj.show(3000);
        myDrawObj.close();
        return countSameRow;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int amount = 10;
        System.out.printf("Willkommen bei der Slot-Maschine! Ihr Start-Budget liegt bei: %d€\n",amount);
        while (amount > 0) {
            System.out.printf("Ihr Budget liegt bei %d€!\n", amount);
            System.out.print("Einsatz wählen: ");
            int bet = 0;
            try{
                bet = scanner.nextInt();
            } catch (InputMismatchException e){

                System.out.println("Fehler! Geben Sie eine Ganzezahl ein");
                scanner.nextLine();
                continue;
            }
            if (bet < 1 || bet > amount) {
                System.out.printf("Fehler! Der Einsatz muss sich zwischen 1 und %d befinden \n", amount);
            }
            else{
                amount -= bet;
                int result = spinWheel();
                if (result > 0){
                    int win = bet * (result + 1);
                    System.out.printf("Glückwunsch, Sie haben %d€ gewonnen!\n", win);
                    amount += win;
                }
                else{
                    System.out.println("Schade! Sie haben leider verloren");
                }
            }
        }
        System.out.println("Spiel vorbei! Kein Geld mehr übrig.");
        scanner.close();
    }
}
