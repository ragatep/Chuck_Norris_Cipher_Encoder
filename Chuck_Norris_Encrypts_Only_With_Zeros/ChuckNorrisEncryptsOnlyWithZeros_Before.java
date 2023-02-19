public class YourClassNameHere {
  public static void main(String[] args) {
    System.out.println("Input string:");
    String input = "Hi <3";
    System.out.println("\nThe result:");
    StringBuilder binaryRepresentation = new StringBuilder();
    char[] chars = input.toCharArray();
    for (char aChar : chars) {
      binaryRepresentation.append((String.format("%7s", Integer.toBinaryString(aChar)).replace(' ', '0')));
    }
    StringBuilder chuckBinary = new StringBuilder();
      int i = 0;
      char currentChar;
      System.out.println("\nBR Length: " + binaryRepresentation.length());
      while (i < binaryRepresentation.length()) {
        if (binaryRepresentation.charAt(i) == '0') {
            chuckBinary.append("00 ");
            currentChar = '0';
        } else {
            chuckBinary.append("0 ");
            currentChar = '1';
        }
        while (binaryRepresentation.charAt(i) == currentChar) {
            System.out.println("\nBR: " + binaryRepresentation.charAt(i));
            chuckBinary.append("0");
            i++;
            if (i >= binaryRepresentation.length()) {
              System.out.println("\nBR Length Line 28: " + binaryRepresentation.length());
              break;
            }
        }
        if (i < binaryRepresentation.length()) {
            System.out.println("\nBR Length Line 33: " + binaryRepresentation.length());
            chuckBinary.append(" ");
        }
        System.out.print("\nCurrent Char: " + currentChar);
        System.out.print("\nChuck Binary: " + chuckBinary);
      }
      System.out.print("Encoded string:");
      System.out.print(chuckBinary.toString());
}
}