import java.util.ArrayList;
import java.util.Scanner;

public class Day2Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Day2Task1. Enter the data (format: number number) and type 'STOP' to finish:");

        int count = 0;

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();

            if (inputLine.equalsIgnoreCase("STOP")) {
                break;
            }

            ArrayList<Integer> numberList = new ArrayList<>();
            String[] stringNumbers = inputLine.split("\\s+");

            for (String str : stringNumbers) {
                numberList.add(Integer.parseInt(str));
            }

            if (isValidTrend(numberList)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isValidTrend(ArrayList<Integer> numbers) {
        if (isAllIncreasing(numbers) || isAllDecreasing(numbers)) {
            return true;
        }

        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Integer> modifiedList = new ArrayList<>(numbers);
            modifiedList.remove(i);

            if (isAllIncreasing(modifiedList) || isAllDecreasing(modifiedList)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAllIncreasing(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int current = numbers.get(i);
            int next = numbers.get(i + 1);

            if (current >= next) {
                return false;
            }

            int difference = next - current;
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllDecreasing(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int current = numbers.get(i);
            int next = numbers.get(i + 1);

            if (current <= next) {
                return false;
            }

            int difference = current - next;
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }
}
