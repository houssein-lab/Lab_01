import java.util.Scanner;
public class SafeInputObj {
    private Scanner pipe;


    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    public String getNonZeroLengthString(String prompt) {
        String result = "";
        do {
            System.out.print(prompt + ": ");
            result = pipe.nextLine().trim();
        } while (result.length() == 0);
        return result;
    }


    public int getInt(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt + " (" + min + " - " + max + "): ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // consume newline
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                pipe.nextLine(); // discard invalid input
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    /**
     * Prompt user for a double within a range
     * @param prompt Message shown to the user
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return validated double
     */
    public double getDouble(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt + " (" + min + " - " + max + "): ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // consume newline
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                pipe.nextLine(); // discard invalid input
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    /**
     * Prompt user for a yes/no response
     * @param prompt Message shown to the user
     * @return true if yes, false if no
     */
    public boolean getYNConfirm(String prompt) {
        String response;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) return true;
            if (response.equals("N")) return false;
            System.out.println("Invalid input. Enter Y or N.");
        }
    }
}

