/*
    Aufgabe 4) Password - Entropieberechnung
*/

import java.util.Random;

public class Aufgabe4 {

    public static void main(String[] args) {

        int passwordLength = 30;
        String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int seed = 0;
        Random myRand = new Random(seed);

        String password = "";
        for (int i = 0; i < passwordLength; i++) {
            password += characterSet.charAt(myRand.nextInt(characterSet.length()));
        }
        double entropy = calculateEntropy(password);
        String pwStrength = "";
        if (entropy >= 120.0) {
            pwStrength = "very strong";
        } else if (entropy >= 60.0 && entropy < 120.0) {
            pwStrength = "strong";
        } else {
            pwStrength = "weak";
        }
        System.out.println("The generated password is: " + password);
        System.out.println("Entropy of the password: " + entropy + " -> The password is: " + pwStrength);
    }

    private static double calculateEntropy(String password) {
        int length = password.length();
        int n = -1;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }
        if (hasDigit){
            if (hasLowerCase ^ hasUpperCase){
                n = 36;
            }
            else if (hasLowerCase && hasUpperCase){
                n = 62;
            }
            else{
                n = 10;
            }
        }
        else{
            if (hasLowerCase ^ hasUpperCase){
                n = 26;
            }
            else if (hasLowerCase && hasUpperCase){
                n = 52;
            }
        }
        return length * Math.log10(n) / Math.log10(2); //Zeile kann geändert oder entfernt werden.
    }
}
