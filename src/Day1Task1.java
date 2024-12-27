import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Day1Task1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        List<Integer> column1 = new ArrayList<>();
        List<Integer> column2 = new ArrayList<>();
        List<Integer> differences = new ArrayList<>();


        System.out.println("Day1Task1. Enter the data (format: number number) and type 'STOP' to finish:");

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();

            if (inputLine.equalsIgnoreCase("STOP")) {
                break;
            }

            String[] parts = inputLine.split("\\s+");

            if (parts.length == 2) {
                int num1 = Integer.parseInt(parts[0]);
                int num2 = Integer.parseInt(parts[1]);

                column1.add(num1);
                column2.add(num2);
            }
        }

        Collections.sort(column1);
        Collections.sort(column2);

        for (int i = 0; i < column1.size(); i++) {
            int diff = Math.abs(column1.get(i) - column2.get(i));
            differences.add(diff);
        }


        int sumOfDifferences = 0;
        for (int diff : differences) {
            sumOfDifferences += diff;
        }

        System.out.println("\nSum of Differences: " + sumOfDifferences);

        scanner.close();

    }
}