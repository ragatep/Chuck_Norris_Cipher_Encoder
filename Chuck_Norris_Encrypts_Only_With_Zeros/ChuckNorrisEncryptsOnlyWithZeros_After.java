
import java.util.*;

public class ChuckNorrisEncryptsOnlyWithZeros {
  public static String encodeString(String input) {
    StringBuilder binaryRepresentation = new StringBuilder();
    char[] chars = input.toCharArray();
    for (char aChar : chars) {
      binaryRepresentation.append((String.format("%7s", Integer.toBinaryString(aChar)).replace(' ', '0')));
    }
    return binaryRepresentation.toString();
  }

  public static String encodeBinary(String binary) {
    StringBuilder chuckBinary = new StringBuilder();
    int i = 0;
    char currentChar;
    while (i < binary.length()) {
      if (binary.charAt(i) == '0') {
        chuckBinary.append("00 ");
        currentChar = '0';
      } else {
        chuckBinary.append("0 ");
        currentChar = '1';
      }
      while (binary.charAt(i) == currentChar) {
        chuckBinary.append("0");
        i++;
        if (i >= binary.length()) {
          break;
        }
      }
      if (i < binary.length()) {
        chuckBinary.append(" ");
      }
    }
    return chuckBinary.toString();
  }

  public static String encode(String input) {
    return encodeBinary(encodeString(input));
  }

  public static void main(String[] args) {
    System.out.println("Input string:");
    String input = "Hi <3";
    System.out.println("\nThe result:");
    System.out.print("Encoded string:");
    System.out.print(encode(input));
  }
}