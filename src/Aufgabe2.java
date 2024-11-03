/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    public static void printNumCharsInString(String text, int startIndex, int numChar){
        for (int i = 0; i < numChar; i++) {
            if (startIndex == text.length()) {
                startIndex = 0;
            }
            System.out.print(text.charAt(startIndex));
            startIndex ++;
        }
        System.out.println();
    }

    public static void printNumbersInInterval(int start, int end){
        for (int i = end; i >= start; i--) {
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static boolean isCharNTimesInString(String text, char character, int nTimes){
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character){
                count++;
            }
        }
        return count == nTimes;
    }

    public static String changeLettersInString(String text){
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if ((currentChar >= 'B' && currentChar <= 'Z') || (currentChar >= 'b' && currentChar <= 'z')){
                result += (char)(currentChar - 1);
            } else {
                result += currentChar;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.

        assert (isCharNTimesInString("nennenswerte Worte", 'n', 4));
        assert (!isCharNTimesInString("nennenswerte Worte", 'n', 3));
        assert (!isCharNTimesInString("nennenswerte Worte", 'e', 6));
        assert (isCharNTimesInString("Test", 'x', 0));

        assert (changeLettersInString("Hello World!").equals("Gdkkn Vnqkc!"));
        assert (changeLettersInString("Anfang und Ende.").equals("Ameamf tmc Dmcd."));
        assert (changeLettersInString("+ABC_123_DEF#").equals("+AAB_123_CDE#"));
        assert (changeLettersInString("ABCDYZ_abcdyz").equals("AABCXY_aabcxy"));

        //**********************************************************************

        //TODO: Testen Sie hier zusätzlich alle Methoden mit verschiedenen Inputs!
        printNumCharsInString("Carlos", 2, 7);
        printNumbersInInterval(1, 30);
    }
}
