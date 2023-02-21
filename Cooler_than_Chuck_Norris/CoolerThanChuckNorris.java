package chucknorris;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        outerloop:
        while (true)    {
            String userOption = getUserOption();
            switch (userOption) {
                case "encode":
                    encode();
                    break;
                case "decode":
                    decode();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    System.exit(0);
                    break outerloop;
                default:
                    System.out.println("There is no '" + userOption + "' operation");
            }

        }
    }

    private static void encode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String inputStr = scanner.nextLine();
        StringBuilder binaryRepresentation = new StringBuilder();

        char[] chars = inputStr.toCharArray();
        for (char aChar : chars) {
            binaryRepresentation.append((String.format("%7s", Integer.toBinaryString(aChar)).replace(' ', '0')));
        }
        StringBuilder chuckBinary = new StringBuilder();
        int i = 0;
        char currentChar;
        while (i < binaryRepresentation.length()) {
            if (binaryRepresentation.charAt(i) == '0') {
                chuckBinary.append("00 ");
                currentChar = '0';
            } else {
                chuckBinary.append("0 ");
                currentChar = '1';
            }
            while (binaryRepresentation.charAt(i) == currentChar) {
                chuckBinary.append("0");
                i++;
                if (i >= binaryRepresentation.length()) {
                    break;
                }
            }
            if (i < binaryRepresentation.length()) {
                chuckBinary.append(" ");
            }
        }
        System.out.println("Encoded string:");
        System.out.println(chuckBinary.toString());
    }

    private static void decode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String encodedString = scanner.nextLine();
        ArrayList<String> encodedStringArray = new ArrayList<>();
        boolean inputIsCorrect = true;
        String stringResult = "";
        for (String s : encodedString.split(" ")) {
            encodedStringArray.add(s);
        }
        for (int i = 0; i < encodedStringArray.size(); i += 2) {
            if (!(encodedStringArray.get(i).equals("0") || encodedStringArray.get(i).equals("00"))) {
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
            System.out.println("Decoded string:");
            System.out.println(stringResult);
        }
    }
    private static String getUserOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input operation (encode/decode/exit):");
        return scanner.nextLine();
    }
}