package chucknorris;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String encodedString = scanner.nextLine();
        ArrayList<String> encodedStringArray = new ArrayList<>();
        boolean inputIsCorrect = true;
        String stringResult = "";
        for (String s : encodedString.split(" ")) {
            if (s.length() > 0) {
                encodedStringArray.add(s);
            }
        }
        for (int i = 0; i < encodedStringArray.size(); i += 2) {
            if (!(encodedStringArray.get(i).equals("0") || encodedStringArray.get(i).equals("00"))) {
                inputIsCorrect = false;
                break;
            }
            if (i + 1 <= encodedStringArray.size() && !encodedStringArray.get(i + 1).equals("0")) {
                inputIsCorrect = false;
                break;
            }
        }
        if (!encodedString.matches("[01 ]+")) {
            inputIsCorrect = false;
        } else if (!(encodedStringArray.get(0).equals("0") || encodedStringArray.get(0).equals("00"))) {
            inputIsCorrect = false;
        } else if (encodedStringArray.size() % 2 != 0) {
            inputIsCorrect = false;
        } else {
            StringBuilder decodedString = new StringBuilder();
            int count = 0;
            char currentChar = 0;
            for (int i = 0; i < encodedStringArray.size(); i++) {
                if (i % 2 == 0) {
                    if (encodedStringArray.get(i).equals("00")) {
                        currentChar = '0';
                    } else {
                        currentChar = '1';
                    }
                } else {
                    count = encodedStringArray.get(i).length();
                    for (int j = 0; j < count; j++) {
                        decodedString.append(currentChar);
                    }

                }

            }
            if (decodedString.length() % 7 != 0) {
                inputIsCorrect = false;
            }
            for (int i = 0; i < decodedString.length(); i++) {
                if (i % 8 == 0) {
                    decodedString.insert(i, " ");
                }
            }
            for (String s : decodedString.toString().trim().split(" ")) {
                stringResult += (char) Integer.parseInt(s, 2);
            }
        }
        if (!inputIsCorrect) {
            System.out.println("Input is not valid");
        } else {
            System.out.println("The result:");
            System.out.println(stringResult);
        }
        scanner.close();
    }
}
