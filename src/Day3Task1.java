import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Day3Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your text (type 'STOP' to finish): ");

        StringBuilder text = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            text.append(line).append("\n");
            if (line.equalsIgnoreCase("STOP")) {
                break;
            }
        }

        String pattern = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don\\'t\\(\\)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text.toString());

        int sum = 0;

        while (matcher.find()) {
            if (matcher.group(1) != null && matcher.group(2) != null) {
                int firstDigit = Integer.parseInt(matcher.group(1));
                int secondDigit = Integer.parseInt(matcher.group(2));
                sum += firstDigit * secondDigit;
            }
        }

        System.out.println("Sum: " + sum);
        scanner.close();
    }
}
