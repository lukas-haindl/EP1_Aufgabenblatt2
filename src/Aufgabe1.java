/*
    Aufgabe 1) Verschachtelte Schleifen - Optische Täuschung
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe1 {

    public static void main(String[] args) {

        int ws = 400;
        CodeDraw myDrawObj = new CodeDraw(ws, ws);
        double radius = 1f/60f * ws;
        double x = 2 * radius;
        double y = 2 * radius;
        int numbOfCircles = 15;
        int numbOfSquares = 7;
        for (int i = 0; i < numbOfCircles; i++) {
            for (int j = 0; j < numbOfCircles; j++) {
                myDrawObj.setColor(Color.BLACK);
                myDrawObj.fillCircle(x, y, radius);
                myDrawObj.setColor(Color.GRAY);
                myDrawObj.setLineWidth(3);
                myDrawObj.drawCircle(x, y, radius);
                x += radius * 4;
            }
            x = 2 * radius;
            y += radius * 4;
        }

        myDrawObj.setColor(Color.WHITE);
        myDrawObj.fillSquare(1f/4 * ws + radius, 1f/4 * ws + radius, 1f/2 * ws - 2 * radius);
        myDrawObj.setColor(Color.BLACK);
        myDrawObj.setLineWidth(1);
        myDrawObj.drawSquare(1f/4 * ws + radius, 1f/4 * ws + radius, 1f/2 * ws - 2 * radius);
        y = 1f/4 * ws + radius * 2;

        for (int i = 0; i < numbOfSquares; i++) {
            x = 1f/4 * ws + radius * 2;
            for (int j = 0; j < numbOfSquares; j++) {
                myDrawObj.drawSquare(x, y, radius * 2);
                x += radius * 4;
            }
            y += radius * 4;
        }
        myDrawObj.show();
    }
}
