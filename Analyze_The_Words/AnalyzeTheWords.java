package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Read a string from a console.
         * The input contains a single line.
         * Output all characters in the string, separated by one space.
         * Including the space characters themselves.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Input string:");
        String message = in.nextLine();

        System.out.println(message);

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            System.out.print(c + " ");
        }
    }
}